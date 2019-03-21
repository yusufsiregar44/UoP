mylist = [ [2,4,1], [1,2,3], [2,3,5] ]
a=0
b=0
total = 0
while a <= 2:
    while b < 2:
        total += mylist[a][b]
        b += 1
    a += 1
    b = 0  
print (total)