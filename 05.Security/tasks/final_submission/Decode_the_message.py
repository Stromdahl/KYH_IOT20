import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

p = 34170657950616
c = "H_eo: Wrld!"

# Write an answer using print
# To debug: print("Debug messages...", file=sys.stderr, flush=True)

######################################################################################

base = len(c)

result = ""
while p:
    val = p % base - 1 if len(result) else 0
    result+=c[val]
    p //= base

print(result)

# result = []
# while p:
#     val = p % base
#     result.append(val)
#     p = int(base / p)

# result = to_base(p, base)

# clear_text = [c[d] for d in result]
# print("".join(clear_text))