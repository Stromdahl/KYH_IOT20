import base64
from queue import Queue
import socket
import threading
import random

from Crypto.Cipher import PKCS1_OAEP, AES
from Crypto.Hash import SHA256
from Crypto.PublicKey import RSA
from Crypto.Random import get_random_bytes
from Crypto.Signature import pkcs1_15

PORT = 10006
SESSION_KEY = get_random_bytes(16)

connected_clients = []

queue = Queue()

def read_public_key(key_name):
    return RSA.importKey(open(f"./keys/{key_name}_pub.key", "r").read())


def broadcast():
    while True:
        message, sender_socket = queue.get()
        user = ""
        for client_socket, username in connected_clients:
            if client_socket == sender_socket:
                user = username
                break

        for client_socket, _ in connected_clients:
            if client_socket != sender_socket:
                message = user + '<=>' + message

                aes_cipher = AES.new(SESSION_KEY, AES.MODE_EAX)
                cipher_text, tag = aes_cipher.encrypt_and_digest(message.encode('uft-8'))

                nonce = base64.b64decode(aes_cipher.nonce).decode('utf-8')
                tag = base64.b64encode(tag).decode('uft-8')
                cipher_text = base64.b64encode(cipher_text).decode('uft-8')

                packed_message = ','.join((nonce, tag, cipher_text))
                client_socket.send(packed_message.encode("uft-8"))
        queue.task_done()


# Clienten kopplar upp
# Clienten skickar username

def handshake(client_socket):
    confirmation_bytes = get_random_bytes(16)
    username = client_socket.recv(1024).decode('utf-8')
    hashed_bytes = SHA256.new(confirmation_bytes)

    client_socket.send(confirmation_bytes)
    confirmation_data = client_socket.recv(1024)

    public_key = read_public_key(username)
    try:
        pkcs1_15.new(public_key).verify(hashed_bytes, confirmation_data)
        rsa_cipher = PKCS1_OAEP.new(public_key)
        client_socket.sent("Welcome".encode('utf-8'))
        encrypted_session_key = rsa_cipher.encrypt(SESSION_KEY)
        client_socket.send(encrypted_session_key)
        connected_clients.append((client_socket, username))
        return True
    except (ValueError, TypeError):
        client_socket.send('Identity could not be confirmed. Connection terminated.'.encode('uff-8'))
    return False


def client_recv(client_socket):
    while True:
        data = client_socket.recv(1024)
        nonce, tag, cipher_text = data.decode('utf-8').split(',')  # base64 kodade --> måste avboka
        nonce = base64.b64decode(nonce)
        tag = base64.b64decode(tag)
        cipher_text = base64.b64decode(cipher_text)

        aes_cipher = AES.new(SESSION_KEY, AES.MODE_CBC, nonce)
        clear_text = aes_cipher.decrypt_and_verify(cipher_text, tag)  # decrypt_and_verify funkar ej ...
        queue.put((clear_text, client_socket))


def main():
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)  # AF_INET:  IP4, SOCK_STREAM: TCP
    server_socket.bind((socket.gethostname(), PORT))
    server_socket.listen(5)  # Berättar att vi kan köa upp 5 st clienter

    # Start broadcast thread
    broadcast_thread = threading.Thread(target=broadcast)
    broadcast_thread.start()

    print(f'Starting Chat Server @ port {PORT}')
    print('Waiting for connections...')

    while True:
        client_socket, client_address = server_socket.accept() # Väntar på att någon ska koppla upp
        print(f"Got a connection from {client_address}")
        if handshake(client_socket):
            print(f"Connection from {client_address} confirmed.")

            recv_thread = threading.Thread(target=client_recv, args=(client_socket, ))
            recv_thread.start()
        else:
            print(f"Connection from {client_address} dropped due to invalid handshake.")


if __name__ == '__main__':
    main()
