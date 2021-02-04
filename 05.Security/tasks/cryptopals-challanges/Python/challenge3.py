import crypto

input_hex = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736"

59666f7a2e677d2e7a666f7a2e68677c6b312e59666f7a2e677d2e7a666f7a2e474d4b31
def main():
	result = crypto.get_best_english_string(bytes.fromhex(input_hex))
	print("Key: {}({})".format(result['key'], chr(result['key'])))
	print("Score: {}".format(result['score']))
	print("text: {}".format(result['text']))
	pass

if __name__ == '__main__':
	main()