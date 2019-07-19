# Ki: Darts játék
# pont = 0
# Amíg pont != 0
#     Ki: pont
#     Be: dobas
#     Ha pont+dobas <= 301
#         pont += dobas
# Ki: Nyertél!

print('Darts játék')
pont = 0
while pont != 301:
    print('Pont: ',pont)
    dobas = int(input('Dobás: '))
    if pont+dobas <= 301:
        pont += dobas
print('Nyertél!')