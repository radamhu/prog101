# egyszerű editor
fnev = input('A fájl neve: ')
f = open(fnev,'a',encoding='utf-8')
print('Írd be a sorokat! * -> vége')
while True:
    sor = input()
    if sor == '*':
        break
    f.write(sor + '\n')
f.close()

