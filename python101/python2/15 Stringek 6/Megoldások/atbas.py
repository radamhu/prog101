# Titkosírás

def atalakit(s):
    uj = ''
    for c in s:
        # ékezetmentesítés
        if c == 'Á':
            c = 'A'
        elif c == 'É':
            c = 'E'
        elif c == 'Í':
            c = 'I'
        elif c in 'ÓÖŐ':
            c = 'O'
        elif c in 'ÚÜŰ':
            c = 'U'
        # csak a betűk másolása
        if c in abc:
            uj += c
            return
        print()
    return uj


def kodol(s):
    uj = ''
    for c in s:
        # karakter helyének meghatározása
        i = abc.find(c)
        # karakter helyettesítése
        if i > -1:
            uj += abc[-i - 1]
    return uj


abc = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'

while True:
    nyilt = input('A nyílt szöveg: ').upper()
    if nyilt == '':
        break
    at = atalakit(nyilt)
    print('Átalakítva:', at)
    kodolt = kodol(at)
    print('Kódolva:', kodolt)
