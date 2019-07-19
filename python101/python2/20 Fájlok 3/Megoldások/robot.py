import math
from turtle import *

def tavolsag(ut):
    'Távolság a kezdőponttól'
    # cél koordinátái
    x = 0
    y = 0
    for c in ut:
        if c == 'K':
            x += 1
        elif c == 'N':
            x -= 1
        elif c == 'E':
            y += 1
        elif c == 'D':
            y -= 1
    # távolság
    return math.sqrt(x**2+y**2)
            
def energia(ut):
    'Kiszámítja az út energiaszükségletét'
    e = 3
    for i in range(1,len(ut)):
        e += 1
        if ut[i] != ut[i-1]:
            e +=2
    return e

def rajzol(ut):
    'Megrajzolja a robot útját'
    title('Robot')
    setworldcoordinates(-10,-10,10,10)
    # rajzolás
    for c in ut:
        if c == 'K':
            setheading(0)
        elif c == 'N':
            setheading(180)
        elif c == 'E':
            setheading(90)
        elif c == 'D':
            setheading(270)
        forward(1)
    hideturtle()
    done()

# programok beolvasása
with open('program.txt','r') as fbe:
    db = int(fbe.readline())
    prog = []
    for sor in fbe:
        prog += [sor[:-1]]
        print(sor[:-1])

# számítások és fájlba írás
with open('kimenet.txt','w') as fki:
    for p in prog:
        print('Eredeti:',p,file=fki)
        print('Távolság:',round(tavolsag(p),2),file=fki)
        print('Energia:',energia(p),file=fki)
print(db,'program kiírva.')

# robot útjának megrajzolása
while True:
    p = int(input('Út száma: '))
    if p >= 0 and p < db:
        rajzol(prog[p])
    else:
        break
