# Informatika érettségi 2012 május programozás----------

# Díjszámító függvény ----------------------------------
def dij(km):
    if km < 3:
        return(500)
    if km < 6:
        return(700)
    if km < 11:
        return(900)
    if km < 21:
        return(1400)
    return(2000)

# 1.feladat --------------------------------------------
utak = []
with open('tavok.txt','r') as fbe:
    for sor in fbe:
        s = sor.split()
        utak.append([int(s[0]),int(s[1]),int(s[2])])
utak = sorted(utak)

# 2. feladat -------------------------------------------
print('--- 2. feladat ---')
print('A hét legelső útja',utak[0][2],'km hosszú volt.')

# 3.feladat --------------------------------------------
print('--- 3. feladat ---')
print('A hét utolsó útja',utak[-1][2],'km hosszú volt.')

# Előkészítés a következő feladatokhoz -----------------
fuvarok = [0]*8        # fuvarok száma az egyes napokon
tavok = [0]*8          # távolságok az egyes napokon
for ut in utak:
    fuvarok[ut[0]] += 1
    tavok[ut[0]] += ut[2]

# 4.feladat --------------------------------------------
print('--- 4. feladat ---')
print('Szabadnap(ok):', end=' ')
for i in range(1,8):
    if fuvarok[i] == 0:
        print(i, end=' ')
print()

# 5.feladat --------------------------------------------
print('--- 5. feladat ---')
print('Ezen a napon volt a legtöbb fuvar:',
      fuvarok.index(max(fuvarok)))

# 6.feladat --------------------------------------------
print('--- 6. feladat ---')
for i in range(1,8):
    print(i,'. nap:',tavok[i],'km')

# 7.feladat --------------------------------------------
print('--- 7. feladat ---')
print('Díjazás:',dij(int(input('Távolság (km): '))),'Ft')

# 8-9.feladat ------------------------------------------
heti = 0
with open('dijazas.txt','w') as fki:
    for ut in utak:
        ar = dij(ut[2])
        heti += ar
        print(ut[0],'. nap ',ut[1],'. út: ',ar,' Ft',
              sep='',file=fki)
print('--- 9. feladat ---')
print('A futár a heti munkájáért',heti,'Ft-ot kap.')
