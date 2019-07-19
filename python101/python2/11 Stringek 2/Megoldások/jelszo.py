# Jelszó generátor program
import random
kar = 'abcdefghijklmnopqrstuvwxyz'
kar += kar.upper()
kar += '0123456789'
for i in range(5):
    jelszo = ''
    for j in range(10):
        jelszo += random.choice(kar)
    print(jelszo)

