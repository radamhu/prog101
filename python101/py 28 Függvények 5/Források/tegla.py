from turtle import *

# Téglalap rajzolása
def teglalap(x,y,a,b,szog=0):
    penup()
    goto(x,y)
    pendown()
    setheading(szog)
    forward(a)
    left(90)
    forward(b)
    left(90)
    forward(a)
    left(90)
    forward(b)

# Minta rajzolása


# Teknőc elrejtése
hideturtle()

# Kattintásra kilépés
exitonclick()
