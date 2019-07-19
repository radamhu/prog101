from tkinter import *

def kiir(e):
    t = s.get()
    if t<=0:
        c.config(text='Jég')
        kc.config(image=kj)
    elif t<100:
        c.config(text='Víz')
        kc.config(image=kv)
    else:
        c.config(text='Gőz')
        kc.config(image=kg)

a = Tk()
a.title('Halmazállapot')
a.minsize(250,200)

s = Scale(a,from_=120,to=-20,command=kiir)
s.set(25)
s.pack(side='left',fill='y')

c = Label(a,text='Víz',font='Arial 24')
c.pack()

kg = PhotoImage(file="gőz.gif")
kv = PhotoImage(file="víz.gif")
kj = PhotoImage(file="jég.gif")

kc = Label(a, image=kv)
kc.pack(pady=10)

a.mainloop()
