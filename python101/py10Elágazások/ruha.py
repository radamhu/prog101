# Mit vegyek fel?

# Be: t
t = int(input('Hány fok van? '))

# Ha t < 10
#    Ki: kabátot vegyél fel!
# Egyébként ha t < 20
#    Ki: pulóvert vegyél fel!
# Egyébként
#    Ki: pólót vegyél fel!
if t < 10:
    print('Kabátot vegyél fel!')
elif t < 20:
    print('Pulóvert vegyél fel!')
else:
    print('Pólót vegyél fel!')
    
