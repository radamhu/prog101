# Betűk megszámlálása a beolvasott szövegben

def db(par):
    return par[1]

while True:
    # Beolvasás
    be = input('Szöveg: ').lower()
    if be == '':
        break
    # Számlálás
    betuk = {}
    for c in be:
        betuk[c] = betuk.get(c,0)+1
    # Kiírás
    betulista = list(betuk.items())
    print(sorted(betulista,key=db,reverse=True))
    
