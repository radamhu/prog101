# hatos lottó statisztika

def egeszek(sor):
    'Egész számokból álló listát készít egy sorból'
    s = sor.split()
    for i in range(len(s)):
        s[i] = int(s[i])
    return s

def ujadatok():
    'Beolvassa az új számokat, és hozzáfűzi az eddigi adatokhoz'
    global szamok
    # új számok
    sor = input('A számok: ')
    uj = sorted(egeszek(sor))
    print('Rendezve:',uj)
    # hozzáfűzés
    szamok += [uj]
    with open('hatos.txt','a') as f:
        for i in uj[:-1]:
            print(i,end='\t',file=f)
        print(uj[-1],file=f)

# beolvasás    
szamok = []
with open('hatos.txt','r') as f:
    for sor in f:
        szamok += [egeszek(sor)]

# menü
while True:
    print('(Ú)j adatok, (S)tatisztika, (E)sélyek, (K)ilépés')
    v = input('Választás: ').upper()
    if v == 'K':
        break
    elif v == 'Ú':
        ujadatok()

