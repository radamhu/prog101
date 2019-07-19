# Tuvudsz...
mh = 'AÁEÉIÍOÓÖŐUÚÜŰ'
while True:
    s = input('Szöveg: ').upper()
    if s == '':
        break
    ki = ''
    for c in s:
        ki += c
        if c in mh:
            ki += 'V'+c
    print(ki)
