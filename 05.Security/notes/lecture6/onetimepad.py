from random import choice
import secrets
from scipy.io import wavfile
import numpy as np


def main():
    samplerate, data = wavfile.read("soundKey.wav")

    message = "message" # input('Enter message to encrypt: ')

    # Klartext: ABC
    # Klartext: 65, 66, 67
    # Nyckelkrav
    # 1. Den måste vara totalt slumpmässig, inga upprepade mönster
    # 2. Måste vara minst lika långt som meddelandet
    # 3. Nyckeln får ABSOLUT bara användas en gång
    # Nyckel: 34, 17, 97

    # Encrypt
    message_bytes = message.encode('utf-8')
    byte_values = list(range(256))
    key = data #[secrets.choice(byte_values) for _ in message_bytes]
    cipher = [c ^ key[i] for i, c in enumerate(message_bytes)]
    print(cipher)
    # Decrypt
    #
    clear = [chr(c ^ key[i]) for i, c in enumerate(cipher)]
    print(clear)

    wavfile.write("example.wav", samplerate, np.array(cipher).astype(np.int16))


if __name__ == '__main__':
    main()
