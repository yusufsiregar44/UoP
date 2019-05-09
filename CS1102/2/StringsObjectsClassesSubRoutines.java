/**
 * @author Yusuf Salman Noerinldy Siregar
 */

public class StringsObjectsClassesSubRoutines {

  enum TypeOfNumber { ODD, EVEN }; // enum of types of number in terms of divisibility

  public static void main (String[] args) {

    TypeOfNumber typeOfNumber;
    int numberToBeProcessed; // variable to contain number which will be processed

    numberToBeProcessed = Integer.parseInt(args[0]); // converts program argument to integer

    // modulus operator as a logic to determine if argument is even or odd
    if (numberToBeProcessed % 2 == 0) {
      typeOfNumber = TypeOfNumber.EVEN;
    } else {
      typeOfNumber = TypeOfNumber.ODD;
    }

    System.out.println(args[0] + "\t is an\t" + typeOfNumber + "\tnumber, and the square root of it is\t" + Math.sqrt(numberToBeProcessed));
  }
}