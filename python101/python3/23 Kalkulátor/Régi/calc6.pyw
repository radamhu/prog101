from tkinter import *
from tkinter.messagebox import *
from math import *

def szamol(e=None):
    try:
        x = eval(be.get().replace(',','.'))
        ki.config(text='= '+str(x).replace('.',','))
    except:
        ki.config(text= '')

def torol(e=None):
    be.delete(0,END)
    be.focus()
    szamol()

def sugo(e=None):
    s ='''Hatvány: **
Négyzetgyök: sqrt()\nPi: pi
Zárójelek használhatók, a műveleti sorrendet ismeri.
Tizedesvesszőt használ.

Ctrl+y: Eredmény másolása a vágólapra
F1: Súgó
F4: Kilépés
F5: Ablak kerete ki/be
F6: Mindig felül be/ki
F7: Átlátszó ablak be/ki
'''
    showinfo('Súgó',s)

def masol(e=None):
    a.clipboard_clear()
    a.clipboard_append(ki.cget('text')[2:])

def beallit():
    a.geometry(beallitas['hely'])
    a.overrideredirect(beallitas['keret'])
    a.attributes("-topmost", beallitas['felul'])
    a.attributes("-alpha", beallitas['alpha'])

def keret(e=None):
    beallitas['keret']= not beallitas['keret']
    beallit()
    
def felul(e=None):
    beallitas['felul']= not beallitas['felul']
    beallit()

def atlatszo(e=None):
    if beallitas['alpha']==0.8:
        beallitas['alpha']=1.0
    else:
        beallitas['alpha']=0.8
    beallit()

def kilep(e=None):
    a.destroy()

beallitas = {'hely':'-140+0','felul':False,
             'keret':False,'alpha':1.0}

# Ablak
a = Tk()
a.title('Számológép (F1->Súgó)')
a.minsize(600,30)
a.resizable(False,False)
beallit()

# Beviteli mező
be = Entry(a,font='MS 12',width=40)
be.grid(row=0,column=1,padx=2,pady=2)
be.bind('<KeyRelease>',szamol)
be.focus()

# Eredmény
ki = Label(a,text='',font='MS 12 bold')
ki.grid(row=0,column=2,padx=2,pady=2)

# Billentyűk
a.bind('<Escape>',torol)
a.bind('<F1>',sugo)
a.bind('<F4>',kilep)
a.bind('<F5>',keret)
a.bind('<F6>',felul)
a.bind('<F7>',atlatszo)
a.bind('<Control-y>',masol)
a.mainloop()
