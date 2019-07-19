from tkinter import *
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
    a2 = Toplevel()
    a2.title('Súgó')
    a2.minsize(width=200,height=90)
    s = 'Hatvány: **\nNégyzetgyök: sqrt()\nPi: pi\n'+\
    'Zárójelek használhatók,\na műveleti sorrendet ismeri.'
    c2 = Label(a2,text=s,justify=LEFT)
    c2.pack()
    a2.mainloop()

# Ablak
a = Tk()
a.title('Számológép (F1->Súgó, ESC->Törlés)')
a.minsize(width=600,height=50)
a.resizable(False,False)

# Töröl gomb
g = Button(a,text='Töröl',command=torol)
g.pack(side=LEFT,padx=5,pady=5)

# Beviteli mező
be = Entry(a,font='MS 12',width=35)
be.pack(side=LEFT,padx=5,pady=5)
be.bind('<KeyRelease>',szamol)
be.focus()

# Eredmény
ki = Label(a,text='',font='MS 12 bold')
ki.pack(side=LEFT,padx=5,pady=5)

# Billentyűk
a.bind('<Escape>',torol)
a.bind('<F1>',sugo)
a.mainloop()
