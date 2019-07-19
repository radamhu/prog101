# Beatles
beatles = [['John',1940],['Paul',1942],
           ['George',1943],['Ringo',1940]]

print('Paul:',beatles[1])
print('Ringo születési éve:',beatles[3][1])

max = 0
for tag in beatles:
    if max < tag[1]:
        max = tag[1]
        nev = tag[0]
print(nev,max)

