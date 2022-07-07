x = 5
y = 20

class HelloClass:
    def __init__(self, name):
        self.name = name
    def helloFunc(self,cond):
        print("Hello " + self.name) if cond else print("Hello bob")
    def goodbyeFunc(self):
        print("bye " + self.name)

helloClass = HelloClass(input("Enter your name: "))
helloClass.helloFunc(y<x)
helloClass.goodbyeFunc()

i = 0
#while(i<=10):
    #print(i)
    #i+=1

basket = ["Banana","apple","cherry","bread"]
while(i<len(basket)):
    print(basket[i])
    i+=1

for food in basket:
    print(food)




