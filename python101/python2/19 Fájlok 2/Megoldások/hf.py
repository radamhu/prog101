nevek = []
while True:
    nev = input('Név: ')
    if nev == '':
        break
    nevek += [nev]
nevek = sorted(nevek)
with open('nevek.txt','w') as f:
    for n in nevek:
        f.write(n + '\n')

