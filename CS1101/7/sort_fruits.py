infile = open("./unsorted_fruits.txt", "r")
outfile= open("./sorted_fruits.txt","w")

# for line in infile.readlines():
#   if (line[0] != ''):
#     print(line)

fruits = infile.readlines()

sortedFruit = []

for fruit in fruits:
  if fruit != '\n':
    sortedFruit.append(fruit)

sortedFruit.sort()

for fruit in sortedFruit:
  outfile.write(fruit)

infile.close()
outfile.close()


