print("Enter text to encrypt:")
text=(input())

def encrypt_text(text):
	encoded_text = '-'
	lister = []
	alpha = 'a'
	alphabets = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
	all_numbers = [1,2,3,4,5,6,7,8,9]
	for letter in text:
		if letter in str(all_numbers):
			ind = str(alphabets[int(letter)-1])
			lister.append(ind)
		else:
			lowered_case = letter.lower()
			if lowered_case in alphabets:
				ind = alphabets.index(lowered_case)
				lister.append(str(ind+1))
	return encoded_text.join(lister)
	
print(encrypt_text(text))