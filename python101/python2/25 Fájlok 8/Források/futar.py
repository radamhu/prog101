# Informatika érettségi 2012 május programozás----------

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


