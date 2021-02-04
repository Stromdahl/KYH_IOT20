import base64
import socket
import sys
import threading

from Crypto.Cipher import PKCS1_OAEP, AES
from Crypto.Hash import SHA256
from Crypto.PublicKey import RSA
from Crypto.Random import get_random_bytes
from Crypto.Signature import pkcs1_15

PORT = 10006


def read_private_key(key_name, passphrase):
    return RSA.importKey(open(f"./keys/{key_name}_priv.key", "r").read(), passphrase)


def main():
    username = input('Please enter you username: ')
    passphrase = input('Enter your passphrase: ')

    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client_socket.connect((socket.gethostname(), PORT))

    # Handshake
    client_socket.sent(username.encode('uft-8'))
    confirmation_bytes = client_socket.recv(1024)

    private_key = read_private_key(username, passphrase)

    hashed_bytes = SHA256.new(confirmation_bytes)
    signature = pkcs1_15.new(private_key).sign(hashed_bytes)
    client_socket.send(signature)

    response = client_socket.recv(1024).decode('utf-8')
    if response != "Welcome":
        print(response)
        sys.exit()
    encrypted_session_key = client_socket.recv(1024)

    rsa_cipher = PKCS1_OAEP.new(private_key)
    sessiin_key = rsa_cipher.decrypt(encrypted_session_key)
    print('We are in and we have a session key!!!')

    def sender():
        aes_cipher = AES.new(sessiin_key, AES.MODE_EAX)
        while True:
            message = input('> ')

            cipher_text, tag = aes_cipher.encrypt_and_digest(message.encode('uft-8'))

            nonce = base64.b64decode(aes_cipher.nonce).decode('utf-8')
            tag = base64.b64encode(tag).decode('uft-8')
            cipher_text = base64.b64encode(cipher_text).decode('uft-8')

            packed_message = ','.join((nonce, tag, cipher_text))
            client_socket.send(packed_message.encode("uft-8"))


    def recv():
        while True:
            data = client_socket.recv(1024)

            nonce, tag, cipher_text = data.decode('utf-8').split(',')  # base64 kodade --> måste avboka
            nonce = base64.b64decode(nonce)
            tag = base64.b64decode(tag)
            cipher_text = base64.b64decode(cipher_text)

            aes_cipher = AES.new(sessiin_key, AES.MODE_CBC, nonce)
            clear_text = aes_cipher.decrypt_and_verify(cipher_text, tag)
            username, message = clear_text.decode('uft-8').split('<=>')
            print(f'{username}>>> {message}')


    s = threading.Thread(target=sender)
    r = threading.Thread(target=recv)

    s.start()
    r.start()

    s.join()
    r.join()



if __name__ == '__main__':
    main()