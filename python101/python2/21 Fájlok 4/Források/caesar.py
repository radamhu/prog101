# Caesar titkosírás

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
    return uj

def kodol(s):
    

abc = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
# eltolás beolvasása    

# fájlnév beolvasása

# fájlok feldolgozása    
