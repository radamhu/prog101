# Mit ír ki?
import random

def kiir():
    while True:
        x = random.randrange(10,31)
        print(x, end=' ')
        if x % 9 == 0:
            break
    print()

kiir()
kiir()
