def idobe():
    be = input('Idő(óó:pp:mm): ')
    try:
        return 3600*int(be[0:2])+60*int(be[3:5])+int(be[6:])
    except:
        return 0

