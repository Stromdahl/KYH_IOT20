# My code for Hacking at Robbercity

```python
import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

message_1 = input()
message_2 = input()
message_3 = input()

# Write an answer using print
# To debug: print("Debug messages...", file=sys.stderr, flush=True)


def xor_3_bytes(bytes1, bytes2, bytes3):
	result = [b1 ^ b2 ^ b3 for b1, b2, b3 in zip(bytes1, bytes2, bytes3)]
	return bytearray(result)

def mitm(message_1, message_2, message_3):
	bytes1 = bytes.fromhex(message_1)
	bytes2 = bytes.fromhex(message_2)
	bytes3 = bytes.fromhex(message_3)
	return xor_3_bytes(bytes1, bytes2, bytes3)

print(mitm(message_1, message_2, message_3).decode())
```

# My code for Decode the message

```python
import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

p = int(input())
c = input()

# Write an answer using print
# To debug: print("Debug messages...", file=sys.stderr, flush=True)

base = len(c)

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
```