from tkinter import *
import random

def szinez(e):
    global szinkod
    szinkod = '#{0:02x}{1:02x}{2:02x}'.format(r.get(),g.get(),b.get()).upper()
    c.config(bg = szinkod)
    ck.config(text = szinkod)

def veletlen():
    r.set(random.randrange(256))
    g.set(random.randrange(256))
    b.set(random.randrange(256))

# ablak
a = Tk()
a.title('Színkeverés')
a.resizable(False,False)

# színes címke
c = Label(a,width=20,height=10,bg='black')
c.grid(column=0,rowspan=4)

# csúszkák
r = Scale(a,from_=0,to=255,orient=HORIZONTAL,
          length=255,fg='red',command=szinez)
r.grid(row=0,column=1,columnspan=2)

g = Scale(a,from_=0,to=255,orient=HORIZONTAL,
          length=255,fg='dark green',command=szinez)
g.grid(row=1,column=1,columnspan=2)

b = Scale(a,from_=0,to=255,orient=HORIZONTAL,
          length=255,fg='blue',command=szinez)
b.grid(row=2,column=1,columnspan=2)

# hexa színkód
szinkod='#000000'
ck = Label(a,text=szinkod)
ck.grid(row=3,column=1)

# véletlen gomb
Button(a,text=' Véletlen szín ',command=veletlen).grid(row=3,column=2)

a.mainloop()
