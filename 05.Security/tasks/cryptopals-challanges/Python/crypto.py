from itertools import cycle

def byte_xor(A, B):
	zip_list = zip(A, cycle(B)) if len(A) > len(B) else zip(cycle(A), B)
	return bytes([_a ^ _b for _a, _b in zip_list])

def get_character_score(character):
	keys = {
	'a': 0.08167,
    'b': 0.01492,
    'c': 0.02782,
    'd': 0.04253,
    'e': 0.12702,
    'f': 0.02228,
    'g': 0.02015,
    'h': 0.06094,
    'i': 0.06094,
    'j': 0.00153,
    'k': 0.00772,
    'l': 0.04025,
    'm': 0.02406,
    'n': 0.06749,
    'o': 0.07507,
    'p': 0.01929,
    'q': 0.00095,
    'r': 0.05987,
    's': 0.06327,
    't': 0.09056,
    'u': 0.02758,
    'v': 0.00978,
    'w': 0.02360,
    'x': 0.00150,
    'y': 0.01974,
    'z': 0.00074,
    ' ': 0.13000}
	if(character in keys):
		return keys[character]
	return 0


def get_best_english_string(_bytes):
	result = {"key":' ', "score":0, "text":' '}
	for key in range(32,127):
		xor_bytes = byte_xor(_bytes, (key).to_bytes(2, byteorder='big'))
		text = xor_bytes.decode("utf-8") 
		text_score = get_english_score(text)
		if text_score > result["score"]:
			result["key"] = key
			result["score"] = text_score
			result["text"] = text
	return result

def get_english_score(text):
	text = text.lower()
	text_scores = []
	for character in text:
		text_scores.append(get_character_score(character))
	return sum(text_scores)


def main():
    print(get_character_score('a') + get_character_score('b') + get_character_score('c'))
    print(get_english_score("abc"))
    _bytes = bytes.fromhex("1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736")
    print(get_english_score(byte_xor(_bytes, b'X').decode("utf-8")))
    print(get_english_score(byte_xor(_bytes, bytes(b'z')).decode("utf-8")))

if __name__ == '__main__':
    main()
