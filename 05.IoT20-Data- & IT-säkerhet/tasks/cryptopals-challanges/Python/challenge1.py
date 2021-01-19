import base64 

input_hex = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d"


def main():
	byte = bytes.fromhex(input_hex)
	print(str(byte, "utf-8"))
	
	base64_result = base64.b64encode(byte)
	print(base64_result)

	expected_result = b'SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t'
	print("Result is equal to expected: {}".format(base64_result == expected_result))


if __name__ == '__main__':
	main()