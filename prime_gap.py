import math

def is_prime(n):
    if n == 2:
        return True
    if n % 2 == 0 or n <= 1:
        return False

    sqr = int(math.sqrt(n)) + 1

    for divisor in range(3, sqr, 2):
        if n % divisor == 0:
            return False
    return True


def gap(g, m, n):
    counter = 0
    stored = 0
    for i in range(m,n+1):
        print(counter,stored)
        if counter > 0:
            counter+=1 
        if is_prime(i):
            if counter-1 == g:
                return [stored, i]
            if counter == 0:
                stored = i
                counter+=1 
            if counter>0:
                stored = i
                counter = 1  
        if(counter>g): 
            stored = i 
            counter = 0
    return

