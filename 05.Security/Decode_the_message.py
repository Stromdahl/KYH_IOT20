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


def decode2(p):
    q = p
    times = 0
    while True:
        q = int(q / len(c))
        times += 1
        if q <= 0:
            break
    my_answer = ''
    for i in range(0, times, +1):
        my_answer += c[p % len(c)]
        p = int((p / len(c))-1) 
    return my_answer

print(decode(p, c))

# #include <bits/stdc++.h>

# int main() {
#     long long    P; std::cin >> P; std::cin.ignore();
#     std::string C, res;
#     std::getline(std::cin, C);

#     while ( P >= 0 ) {
#         res += C[ P % C.size() ];
#         P = P / C.size() - 1;
#     } 

#     std::cout << res << std::endl;
# }

# String result = "";
#         while (num > 0) {
#             num--;
#             long remainder = num % base;
#             char digit = characters[(int)remainder];
#             result = digit + result;
#             num = (num - remainder) / base;
#         }

#         return result;