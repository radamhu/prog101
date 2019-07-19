# Titkosírás

def atalakit(s):
    return s

def kodol(s):
    return s
    
abc = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'

while True:
    nyilt = input('A nyílt szöveg: ').upper()
    if nyilt == '':
        break
    at = atalakit(nyilt)
    print('Átalakítva:',at)
    kodolt = kodol(at)
    print('Kódolva:',kodolt)

