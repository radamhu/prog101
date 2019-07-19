# Hőmérséklet statisztika

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
        print('Fagyos napok:')
    elif v == '5':
        print('Javítás')
    elif v == '6':
        pass
    else:
        break

