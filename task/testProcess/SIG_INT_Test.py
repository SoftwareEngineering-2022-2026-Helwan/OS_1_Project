import time

try :

    x = 0
    print(" x = " , x)
    
    while ( True ) :

        x += 1
        time.sleep(0.5)

except:

    print("\nx = {}".format(x))
