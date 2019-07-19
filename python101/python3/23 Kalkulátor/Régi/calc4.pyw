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
    s = 'Hatvány: **\nNégyzetgyök: sqrt()\nPi: pi\n'+\
    'Zárójelek használhatók,\na műveleti sorrendet ismeri.'
    showinfo('Súgó',s)

def kilep(e=None):
    a.destroy()

# Ablak
a = Tk()
a.title('Számológép (ESC->Törlés, F1->Súgó, F4->Kilépés)')
a.minsize(width=600,height=40)
a.resizable(False,False)

# Töröl gomb
g = Button(a,text='Töröl',command=torol)
g.grid(padx=5,pady=5)

# Beviteli mező
be = Entry(a,font='MS 12',width=35)
be.grid(row=0,column=1,padx=5,pady=5)
be.bind('<KeyRelease>',szamol)
be.focus()

# Eredmény
ki = Label(a,text='',font='MS 12 bold')
ki.grid(row=0,column=2,padx=5,pady=5)

# Billentyűk
a.bind('<Escape>',torol)
a.bind('<F1>',sugo)
a.bind('<F4>',kilep)
a.mainloop()
