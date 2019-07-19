# Caesar titkosírás
import os

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
    uj =''
    for c in s:
        # karakter helyének meghatározása
        i = abc.find(c)
        # karakter helyettesítése
        if i > -1:
            k = i + tol
            if k > len(abc) - 1:
                k -= len(abc)
            elif k < 0:
                k += len(abc)
            uj += abc[k]
    return uj

abc = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
# eltolás beolvasása    
while True:
    tol = int(input('Eltolás (-25...+25): '))
    if abs(tol)<26:
        break
# fájlnév beolvasása
while True:
    fnev = input('A bemenő fájl neve: ')
    if os.path.exists(fnev):
        break
# fájlok feldolgozása    
with open(fnev,'r') as fbe, open(fnev+'.csr','w') as fki:
    for sor in fbe:
        at = atalakit(sor[:-1].upper())
        kodolt = kodol(at)
        print(kodolt,file=fki)
