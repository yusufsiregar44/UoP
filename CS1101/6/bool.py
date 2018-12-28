def compare(a, b):
    if a > b:
        return 1
    elif a == b:
        return 0
    elif a < b:
        return -1

firstNumber = input("enter first value ")

secondNumber = input("enter second value ")

print(compare(firstNumber, secondNumber))
