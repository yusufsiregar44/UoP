public class Firstsubroutines {

  /**
   * @param args the command line argument of java program
   */
  public static void main (String[] args) {
    String userInput; // variable containing user input
    String reversedUserInput; // variable containining reversed user input
    String strippedUserInput; // variable containining stripped user input

    userInput =  args[0];

    strippedUserInput = stripper(userInput);
    System.out.println("stripped:\t" + strippedUserInput);

    reversedUserInput = reverser(strippedUserInput);
    System.out.println("reversed:\t" + reversedUserInput);

    if (reversedUserInput.equals(strippedUserInput)) {
      System.out.println("This is INDEED a palindrome");
    } else {
      System.out.println("This is NOT a palindrome");
    }
  }

    /**
   * @param text string to be reversed
   */
  static String reverser(String text) {
    String reversedText; // variable containing reversed text

    int i;
    int textLength;

    reversedText = "";
    textLength = text.length() - 1; // gets text length

    // loops text staring from the end
    for (i = textLength; i >= 0; i--) {
      reversedText = reversedText + text.charAt(i); 
    }

    return reversedText;
  }

  static String stripper(String text) {
    String strippedText; // variable containing stripped text

    text = text.toLowerCase(); // converts text to lower case
    char[] characters = text.toCharArray(); // converts text to array
    strippedText = "";

    // loops using for each and then checking if each char is a letter
    for (char c : characters) {
      if (Character.isLetter(c)) {
        strippedText = strippedText + c;
      }
    }

    return strippedText;
  }
}