# -*- coding: utf-8 -*-

# Euro <-> Ft átváltó program

# Árfolyam beolvasása


# Menü kiírása (1: Euro -> Ft, 2: Ft->Euró)
# Válasz beolvasása
arfolyam = float(input('Hány Ft 1 euro? '))

print('1: Euro -> Ft, 2: Ft-> Euro')
valasz = input('Választás: ')
# Ha a válasz 1
#    Összeg beolvasása EUR-ban
#    Összeg * Árfolyam kiírása egészekre kerekítve
# Egyébként (ha a válasz 2 vagy más)
#    Összeg beolvasása Ft-ban
#    Összeg/Árfolyam kiírása két tizedessel
if valasz == '1':
    osszeg = float(input('Átváltandó összeg (EUR): '))
    print('Az összeg Ft-ban:', round(osszeg*arfolyam))
else:
    osszeg = float(input('Átváltandó összeg (Ft): '))
    print ('Az összeg EUR-ban:', round(osszeg/arfolyam,2))

print("hello world")

