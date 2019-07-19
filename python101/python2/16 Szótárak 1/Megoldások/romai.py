# Átváltás római számról arab számra

# Római számjegyek
romai = {'I':1,
         'V':5,
         'X':10,
         'L':50,
         'C':100,
         'D':500,
         'M':1000}

while True:
    # Beolvasás
    be = input('Római szám: ').upper()
    if be == '':
        break
    # Számjegyek értéke
    arab = []
    for c in be:
        szamjegy = romai.get(c,0)
        if szamjegy != 0:
            arab += [szamjegy]
    # számjegyek előjele
    for i in range(len(arab)-1):
        if arab[i] < arab[i+1]:
            arab[i] = -arab[i]
    # Összegzés és kiírás
    print(sum(arab))

