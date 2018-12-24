# addition function
def addition(int1, int2):
    return int1 + int2

# substraction function
def substraction(int1, int2):
    return int1 - int2

# multiplication function
def multiplication(int1, int2):
    return int1 * int2

# division function
def division(int1, int2):
    return int1 / int2

# function to check if integer is number or not
def intChecker(intToBeChecked):
    if (intToBeChecked <= 0 and type(intToBeChecked) is int):
        return False
    else:
        return True


def calc(int1, int2, operator):
    if (intChecker(int1) and intChecker(int2)):
        if (operator == '+'):
            return addition(int1, int2)
        elif (operator == '-'):
            return substraction(int1, int2)
        elif (operator == '*'):
            return multiplication(int1, int2)
        elif (operator == '/'):
            return division(int1, int2)
        else:
            return 'operators are invalid'
    else:
        return 'integers are invalid'

# function to be called at the end of calculation, asks user to run cacluatio again or end program
def askAgain():
    response = input("Would you like another operation? (Y/N)")
    if response == 'Y':
        inputPrompt()
    elif response == 'N':
        print('See You later!')
    else:
        print('I don\'t get what you mean')
        askAgain()

# function to promt user input and execute calc funtion using user inputs
def inputPrompt():
    inputInt1 = float(input("Input first number... "))
    inputInt2 = float(input("Input second number... "))
    inputOperator = input("Input desired mathematical operation... ")
    print(calc(inputInt1, inputInt2, inputOperator))
    askAgain()

# initial execution of program
inputPrompt()
