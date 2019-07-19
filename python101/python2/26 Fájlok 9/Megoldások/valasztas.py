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


