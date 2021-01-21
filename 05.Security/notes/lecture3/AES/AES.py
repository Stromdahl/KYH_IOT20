from Crypto.Cipher import AES
from Crypto.Util.Padding import pad, unpad
from Crypto.Random import get_random_bytes
from base64 import b64encode, b64decode
import json


def main():

    # Encrypt
    message = input("Enter message to encrypt: ").encode('utf-8')
    key = get_random_bytes(16)  # uppsättning bytes

    cipher = AES.new(key, AES.MODE_CBC)
    ct_bytes = cipher.encrypt(
        pad(message, AES.block_size))  # krypterade data #pad fyller ut om den inte är 128 bytes lång, meddelandet då.
    iv = b64encode(cipher.iv).decode('utf-8')  # initialization vector = iv
    ct = b64encode(ct_bytes).decode('utf-8')

    with open('message.enc', 'w') as file_out:
        json.dump({'iv': iv, 'ciphertext': ct}, file_out)



    # Decrypy
    with open('message.enc', 'r') as file_in:
        data = json.load(file_in)
    iv = b64decode(data['iv'])
    ct = b64decode(data['ciphertext'])
    cipher = AES.new(key, AES.MODE_CBC, iv)
    message = unpad(cipher.decrypt(ct), AES.block_size)
    message = message.decode()
    print(f'This message was {message}')

if __name__ == "__main__":
    main()