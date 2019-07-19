from tkinter import *
from math import *

def szamol(e=None):
    try:
        x = eval(be.get())
        ki.config(text = str(x))
    except:
        ki.config(text = 'Hiba!')

def torol(e=None):
    be.delete(0,END)

a = Tk()
a.title('Számológép')

ki = Label(a,text='0',font='MS 12 bold')
ki.grid(columnspan=2,padx=5,pady=5,sticky=E)

be = Entry(a,font='MS 12',justify=RIGHT,width=40)
be.grid(columnspan=2,padx=5,pady=5)
be.focus()

gsz = Button(a,text='Számol',width=15,command=szamol)
gsz.grid(padx=5,pady=5)

gt = Button(a,text='Töröl',width=15,command=torol)
gt.grid(row=2,column=1,padx=5,pady=5)

a.bind('<Return>',szamol)
a.bind('<Escape>',torol)
a.mainloop()
