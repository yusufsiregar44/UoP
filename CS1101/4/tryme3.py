def three_lines():
# printing three lines
  print()
  print()
  print()

def nine_lines():
  # calling three lines three times
  three_lines()
  three_lines()
  three_lines()

def clear_screen():
  # uses while loop to print twentyfive lines
  i = 1
  while i < 26:
    print()
    i += 1

print("------ printing nine lines ------")
nine_lines()
print("------ printing twentyfive lines ------")
clear_screen()