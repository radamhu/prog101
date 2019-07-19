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


print('Átlag számítás')
while True:
    be = input('Osztályzatok: ')
    if be == '':
        break
    db = 0
    osszeg = 0
    for c in be:
        if c >= '1' and c <= '5':
            db += 1
            osszeg += int(c)
    if db > 0:
        print('Átlag:',round(osszeg/db,2))

