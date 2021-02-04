import binascii

message_1 = "391813c092a2d5ac9acb705dfe41be3df08de67d1145cbcc3f"
message_2 = "03adeae2c8c2f2336c8a8d312733c2456e76e0b2d9068adc3f"
message_3 = "72d0954e354045f09461dc4c911d0b58ff8963efb12c34303f"

def messageFromAToB():
	raw_message = "M".encode('utf-8')
	m = raw_message[0]

	A_key = 0b10010110
	B_key = 0b01110100

	m1 = m ^ A_key
	m2 = m1 ^ B_key
	m3 = m2 ^ A_key

	r = m3 ^ B_key

	print(f'raw message: {m:08b}')
	print(f'enc A:       {m1:08b}')
	print(f'enc A n A:   {m2:08b}')
	print(f'enc B:       {m3:08b}')
	print(f'decrypted:   {r:08b}')

def xor_3_bytes(bytes1, bytes2, bytes3):
	result = [b1 ^ b2 ^ b3 for b1, b2, b3 in zip(bytes1, bytes2, bytes3)]
	return bytearray(result)

# def xor_3_bytes(bytes1, bytes2, bytes3):
# 	result = bytearray()
# 	for b1, b2, b3 in zip(bytes1, bytes2, bytes3):
# 		result.append(b1 ^ b2 ^ b3)
# 	return result

def mitm(message_1, message_2, message_3):
	bytes1 = bytes.fromhex(message_1)
	bytes2 = bytes.fromhex(message_2)
	bytes3 = bytes.fromhex(message_3)
	return xor_3_bytes(bytes1, bytes2, bytes3)

def main():
	print(mitm(message_1, message_2, message_3).decode())
	pass

if __name__ == '__main__':
	main()