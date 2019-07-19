try:
    with open('vers2.txt','r',encoding='utf-8') as f:
        for sor in f:
            print(sor[:-1])
except:
    print('Hiba a fájl olvasásakor!')


