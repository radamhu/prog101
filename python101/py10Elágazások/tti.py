# Testtömegindex

import webbrowser

# Be: cm, kg
cm = float(input('Hány cm magas vagy? '))
kg = float(input('Hány kg a tömeged? '))


# tti kiszámítása
tti = kg/(cm/100)**2

# Ha tti<20
#   alkat = 'alultáplált'
# Különben ha tti<25
#   alkat = 'normális'
# Különben ha tti<30
#   alkat = 'túlsúlyos'
# Különben ha tti<35
#   alkat = 'elhízott'
# Egyébként
#   alkat = 'erősen elhízott'
if tti<20:
    alkat = 'alultáplált'
elif tti<25:
    alkat = 'normális'
elif tti<30:
    alkat = 'túlsúlyos'
elif tti<35:
    alkat = 'elhízott'
else:
    alkat = 'erősen elhízott'

# Ki: tti kerekítve,alkat
print('Testömegindexed: ',round(tti,2),alkat)

url='http://index.hu'
valasz = input('Táblázat megjelenítése (i/n): ')
if valasz == 'i':
    webbrowser.open_new_tab(url)

