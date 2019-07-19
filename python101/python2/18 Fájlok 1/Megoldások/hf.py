f = open('vers.txt','r')
for s in f:
    print(len(s.split()),end=' ')
f.close()
