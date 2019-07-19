# Átváltás tizesről kettes számrendszerre
while True:
    try:
        t = int(input('Tizes számrendszerben: '))
    except:
        continue
    if t == 0:
        break
    k = ''
    while t > 0:
        k = str(t % 2) + k
        t = t // 2
    print('Kettes számrendszerben:',k)
