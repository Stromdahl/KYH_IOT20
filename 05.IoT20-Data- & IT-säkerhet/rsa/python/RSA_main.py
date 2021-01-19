import math
import random
import os
import sys

def miller_rabin(n, k):

    # Implementation uses the Miller-Rabin Primality Test
    # The optimal number of rounds for this test is 40
    # See http://stackoverflow.com/questions/6325576/how-many-iterations-of-rabin-miller-should-i-use-for-cryptographic-safe-primes
    # for justification

    # If number is even, it's a composite number

    if n == 2:
        return True

    if n % 2 == 0:
        return False

    r, s = 0, n - 1
    while s % 2 == 0:
        r += 1
        s //= 2
    for _ in range(k):
        a = random.randrange(2, n - 1)
        x = pow(a, s, n)
        if x == 1 or x == n - 1:
            continue
        for _ in range(r - 1):
            x = pow(x, 2, n)
            if x == n - 1:
                break
        else:
            return False
    return True

def is_prime(num):
    if num < 2:
        return False

    low_primes = [2 , 3 , 5 , 7 , 11 , 13 , 17 , 19 , 23 , 29 , 31 , 37 , 41 , 43 , 47 , 53 , 59 , 61 , 67 , 71 , 73 , 79 , 83 , 89 , 97 , 101 , 103 , 107 , 109 , 113 , 127 , 131 , 137 , 139 , 149 , 151 , 157 , 163 , 167 , 173 , 179 , 181 , 191 , 193 , 197 , 199 , 211 , 223 , 227 , 229 , 233 , 239 , 241 , 251 , 257 , 263 , 269 , 271 , 277 , 281 , 283 , 293 , 307 , 311 , 313 , 317 , 331 , 337 , 347 , 349 , 353 , 359 , 367 , 373 , 379 , 383 , 389 , 397 , 401 , 409 , 419 , 421 , 431 , 433 , 439 , 443 , 449 , 457 , 461 , 463 , 467 , 479 , 487 , 491 , 499 , 503 , 509 , 521 , 523 , 541 , 547 , 557 , 563 , 569 , 571 , 577 , 587 , 593 , 599 , 601 , 607 , 613 , 617 , 619 , 631 , 641 , 643 , 647 , 653 , 659 , 661 , 673 , 677 , 683 , 691 , 701 , 709 , 719 , 727 , 733 , 739 , 743 , 751 , 757 , 761 , 769 , 773 , 787 , 797 , 809 , 811 , 821 , 823 , 827 , 829 , 839 , 853 , 857 , 859 , 863 , 877 , 881 , 883 , 887 , 907 , 911 , 919 , 929 , 937 , 941 , 947 , 953 , 967 , 971 , 977 , 983 , 991 , 997 ]

    if num in low_primes:
        return True

    for prime in low_primes:
        if num % prime == 0:
            return False

    return miller_rabin(num, 100)

def generate_large_prime(key_size=1024):
    while True:
        num = random.randrange(2 ** (key_size - 1), 2 ** key_size)
        if is_prime(num):
            return num

def gcd(a, b):
    while a != 0:
        a, b = b % a, a
    return b

def mod_inverse(a, m):
    if gcd(a, m) != 1:
        return None
    u1, u2, u3 = 1, 0, a
    v1, v2, v3 = 0, 1, m

    while v3 != 0:
        q = u3 // v3
        v1, v2, v3, u1, u2, u3 = (u1 - q * v1), (u2 - q * v2), (u3 - q * v3), v1, v2, v3

    return u1 % m


def generate_keys(key_size):
    p = generate_large_prime(key_size // 2)
    q = generate_large_prime(key_size // 2)
    
    n = p * q
    phi_n = (p-1) * (q-1)

    while True:
        e = random.randrange(2 ** (key_size - 1), 2 ** key_size)
        if gcd(e, phi_n) == 1:
            break
    d = mod_inverse(e, phi_n)
    private_key = (d, n)
    public_key = (e, n)
    return public_key, private_key


def make_key_files(name, key_size):
    if os.path.exists(f"{name}_pub.key") or os.path.exists(f"{name}_priv.key"):
        sys.exit(f"WARNING: The file name {name}_pub.key or {name}_priv.key already exists")
    public_key, private_key = generate_keys(key_size)
    with open(f"{name}_pub.key", "w") as f:
        f.write(f"{key_size},{public_key[0]},{public_key[1]}")

    with open(f'{name}_priv.key', "w") as f:
        f.write(f"{key_size},{private_key[0]},{private_key[1]}")

def read_keys(name):
    if not os.path.exists(f"{name}_pub.key") or not os.path.exists(f"{name}_priv.key"):
        sys.exit(f"WARNING: The file name {name}_pub.key or {name}_priv.key does not exists")

    public_key = open(f"{name}_pub.key").read().split(',')
    private_key = open(f'{name}_priv.key').read().split(',')
    return public_key, private_key

def main():
    key_size = 2048
    name = input("Enter a key name ")

    if not os.path.exists(f"{name}_pub.key") or not os.path.exists(f"{name}_priv.key"):
        make_key_files(name, key_size)
    public_key, private_key = read_keys(name)

    print(public_key)
    print(private_key)


if __name__ == "__main__":
    main()