#------------------------------------------------------------------------------------------
#this function should return the first pair of two prime numbers 
# spaced with a gap of g between the limits m, n
#
#Examples:
#gap(2, 5, 7) --> [5, 7] or (5, 7) or {5, 7}
#gap(2, 5, 5) --> nil. In C++ {0, 0}. In F# [||]. In Kotlin, Dart and Prolog return []`
#gap(4, 130, 200) --> [163, 167] or (163, 167) or {163, 167}
#------------------------------------------------------------------------------------------- 

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

