# Parkettázás
import math

# --- negyzet() függvény ----
def negyzet():
    a = float(input('A négyzet oldala: '))
    t = a * a
    print('Terület:',math.ceil(t))
    print('Költség:',ar * math.ceil(t))

# --- teglalap() függvény ----
def teglalap():
    pass

# --- Főprogram ---
ar = 1000
print('Parkettázás')
while True:
    print('1 - Négyzet\n2 - Téglalap\n0 - Kilépés')
    v = input('Válasz: ')
    if v == '1':
        negyzet()
    elif v == '2':
        teglalap()
    else:
        break

