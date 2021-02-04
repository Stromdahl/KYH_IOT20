def charToUpper(word, i):
    l = list(word)
    l[i] = l[i].upper()
    return "".join(l)
    
    


wordList = ["hej"]

for word in wordList:
    for i, _ in enumerate(word):
        print(charToUpper(word, i))
