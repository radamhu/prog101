a = [3,2,5,2,1,3,4,4]
b = []
for x in a:
    if x not in b:
        b += [x]
print(b)

