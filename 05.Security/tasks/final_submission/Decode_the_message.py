import math

p = 13484
c = "abcdefghijklmnopqrstuvwxyz"
m = "ja"

################################################################33


def decode(num, alfabet):
    base = len(alfabet)
    result = ""
    while num >= 0:
        result+= alfabet[num % base]
        if(num < base):
            break
        num = num // base-1 

    return result

print(decode(p, c))