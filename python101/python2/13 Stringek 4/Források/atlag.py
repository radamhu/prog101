# Átlag számítás
#
# Ki: Átlag számítás
# Ciklus
#     be = osztályzatok
#     Ha be == '':
#         Kilépés a ciklusból
#     db = 0
#     osszeg = 0
#     c végigmegy be karakterein
#         Ha c '1' és '5' között van
#             db += 1
#             osszeg += c egészre alakítva
#     Ha db > 0
#         Ki: Átlag:,osszeg/db 2 tizedesre kerekítve


    if be == '':
    be = input('Osztályzatok: ')
print('Átlag számítás')
while True:
        break
    for c in be:
        if c >= '1' and c <= '5':
    db = 0
            osszeg += int(c)
    osszeg = 0
    if db > 0:
        print('Átlag:',round(osszeg/db,2))
            db += 1
