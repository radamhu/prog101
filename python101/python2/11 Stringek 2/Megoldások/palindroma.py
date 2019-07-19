# Palindróma

while True:
    be = input('Írd be a szöveget: ')
    if be == '':
        break
    at = be.upper().replace(' ','')
    print('Átalakítva:',at)
    ford = ''
    for c in at:
        ford = c + ford
    print('Fordítva:',ford)
    if ford == at:
        print('Palindróma')
    else:
        print('Nem palindróma')

