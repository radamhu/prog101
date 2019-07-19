# Hőmérséklet statisztika
from turtle import *

def fagy(ho):
    'Megszámolja a nem pozitív hőmérsékletű napokat'
    nap = 0
    for t in ho:
        if t <= 0:
            nap += 1
    return nap

def oszlop(n):
    'Rajzol egy n magasságú oszlopot a következő helyre'
    begin_fill()
    forward(1)
    left(90)
    forward(n)
    left(90)
    forward(1)
    left(90)
    forward(n)
    left(90)
    forward(1)
    end_fill()

def diagram():
    'Diagramot rajzol'
    title('Februári adatok')
    setworldcoordinates(0,-30,31,30)
    fillcolor('green')

    tracer(0)
    # x tengely
    forward(31)
    backward(31)
    # oszlopok
    for i in feb:
        oszlop(i)
    tracer(1)

    hideturtle()
    done()

feb = [2,1,5,-3,3,2,8,-5,1,2,2,-5,0,5,
       -3,5,-3,3,-21,1,-9,-2,1,1,-9,-12,0,-5]

while True:
    print('1-Átlag 2-Min 3-Max 4-Fagy 5-Javít '+
          '6-Diagram 0-Kilép')
    v = input('Választás: ')
    if v == '1':
        print('Átlag:',sum(feb)/len(feb))
    elif v == '2':
        hideg = min(feb)
        print('Minimum:',hideg,'Nap:',
              feb.index(hideg)+1)
    elif v == '3':
        meleg = max(feb)
        print('Maximum:',meleg,'Nap:',
              feb.index(meleg)+1)
    elif v == '4':
        print('Fagyos napok:',fagy(feb))
    elif v == '5':
        print('Javítás')
    elif v == '6':
        diagram()
    else:
        break

