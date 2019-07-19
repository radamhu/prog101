# Hatos lottó statisztika
import random

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

def statisztika():
    'Kilistázza, melyik számot hányszor húzták ki'
    # számolás
    db = [0] * 46
    for sor in szamok:
        for szam in sor:
            db[szam] += 1
    # listázás
    for i in range(1,46):
        print(db[i],end=' ')
        if i % 5 == 0:
            print()
    # legkevesebbszer kihúzott szám
    print('A legkevesebbszer kihúzott szám:',db.index(min(db[1:])))

def hanyas(tipp,huzas):
    'Kiszámolja hányasunk lenne a tippel huzas esetén'
    h = 0
    for i in tipp:
        if i in huzas:
            h += 1
    return h

def esely():
    'Sorsol egyet, és megnézi, mennyi találatunk lett volna'
    # sorsolás
    v = sorted(random.sample(range(1,46),6))
    print('Tipp:',v)
    # vizsgálat
    talalat = [0] * 7
    for het in szamok:
        talalat[hanyas(v,het)] += 1
    # kiírás
    for i in range(7):
        print(i,talalat[i])
        
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
    elif v == 'S':
        statisztika()
    elif v == 'E':
        esely()

