# Emelt szintű informatika érettségi, 2013. május

# 1. feladat ------------------------------------------------
print('1. feladat ------')
jeloltek = []
with open('szavazatok.txt','r') as fbe:
    for sor in fbe:
        s = sor.split()
        if s[4] == '-':
            s[4] = 'független'
        jeloltek.append([int(s[0]),int(s[1]),s[2],s[3],s[4]])
 
# 2. feladat ------------------------------------------------
print('2. feladat ------')
print('A helyhatósági választáson',
      len(jeloltek),'képviselőjelölt indult')

# 3. feladat ------------------------------------------------
print('3. feladat ------')
vnev = input('Vezetéknév: ')
knev = input('Keresztnév: ')
volt = False
for j in jeloltek:
    if j[2] == vnev and j[3] == knev:
        print('A jelölt',j[1],'szavazatot kapott.')
        volt = True
        break        
if not volt:
    print('Ilyen nevű képviselőjelölt nem szerepel',
          'a nyilvántartásban.')

# 4. feladat ------------------------------------------------
print('4. feladat ------')
VALASZTOK = 12345
szavazok = 0
for j in jeloltek:
    szavazok += j[1]
print('A választáson ',szavazok,' állampolgár,a jogosultak ',
      round(szavazok/VALASZTOK*100,2),'%-a vett részt.',sep='')

# 5. feladat ------------------------------------------------
print('5. feladat ------')
partok = {'GYEP'     :['Gyümölcsevők Pártja',0],
          'HEP'      :['Húsevők pártja',0],
          'TISZ'     :['Tejivók Szövetsége',0],
          'ZEP'      :['Zöldségevők Pártja',0],
          'független':['Független jelöltek',0]}
for j in jeloltek:
    partok[j[4]][1] += j[1]
for p in partok:
    print(partok[p][0],'= ',round(partok[p][1]/szavazok*100,2),
          '%',sep='')

# 6. feladat ------------------------------------------------
def szavazat(jelolt):
    return jelolt[1]

print('6. feladat ------')
legtobb = max(jeloltek,key=szavazat)
print('A legtöbb szavazatot kapták:')
for j in jeloltek:
    if j[1] == legtobb[1]:
        print(j[2],j[3],j[4])

# 7. feladat ------------------------------------------------
print('7. feladat ------')
kepviselok = {}
for j in jeloltek:
    if j[0] not in kepviselok or kepviselok[j[0]][0] < j[1]:
        kepviselok[j[0]] = j[1:]
with open('kepviselok.txt','w') as fki:
    for i in range(1,9):
        print(i,' '.join(kepviselok[i][1:]),file=fki)
