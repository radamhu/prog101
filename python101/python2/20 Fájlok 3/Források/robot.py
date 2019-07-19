# programok beolvasása
with open('program.txt','r') as fbe:
    db = int(fbe.readline())
    prog = []
    for sor in fbe:
        prog += [sor[:-1]]
        print(sor[:-1])
