# Két kocka

import random
dobasok = []
for i in range(7):
    dobasok += [[0]*7]
    
for i in range(1000):
    sor = random.randrange(1,7)
    oszlop = random.randrange(1,7)
    dobasok[sor][oszlop] += 1

print('    1   2   3   4   5   6')
for sor in range(1,len(dobasok)):
    print(sor,dobasok[sor][1:])
    print('')

hetes = dobasok[1][6]+dobasok[6][1]+\
        dobasok[2][5]+dobasok[5][2]+\
        dobasok[4][3]+dobasok[3][4]
print('Hetesek:',hetes)

tizenegyes = dobasok[5][6]+dobasok[6][5]
print('Tizenegyesek:',tizenegyes)

