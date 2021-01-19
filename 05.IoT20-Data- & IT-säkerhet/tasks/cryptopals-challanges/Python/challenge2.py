import crypto
 

hex_string1 = "1c0111001f010100061a024b53535009181c"
hex_string2 = "686974207468652062756c6c277320657965"
expected = "746865206b696420646f6e277420706c6179"

def main():
    bytes1 = bytes.fromhex(hex_string1)
    bytes2 = bytes.fromhex(hex_string2)
    result_bytes = crypto.byte_xor(bytes1, bytes2)
    print(bytes1)
    print(bytes2)
    print(result_bytes)
    print("Expected and result are the same: {}".format(result_bytes.hex() == expected))



if __name__ == '__main__':
	main()
