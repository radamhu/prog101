from tkinter import *
from math import *

def szamol(e=None):
    try:
        x = eval(be.get().replace(',','.'))
        ki.config(text = '= '+str(x).replace('.',','))
    except:
        ki.config(text = '')

def torol(e=None):
    be.delete(0,END)
    be.focus()
    szamol()

a = Tk()
a.title('Számológép')
a.minsize(width=600,height=50)

gt = Button(a,text='Töröl',command=torol)
gt.pack(side=LEFT,padx=5,pady=5)

be = Entry(a,font='MS 12',width=35)
be.pack(side=LEFT,padx=5,pady=5)
be.bind('<KeyRelease>',szamol)
be.focus()

ki = Label(a,text='',font='MS 12 bold')
ki.pack(side=LEFT,padx=5,pady=5)

a.bind('<Escape>',torol)
a.mainloop()
