import textio.TextIO;
public class Firstsubroutines {

  /**
   * @param args the command line argument of java program
   */
  public static void main (String[] args) {
    String userInput; // variable containing user input
    String reversedUserInput; // variable containining reversed user input
    String strippedUserInput; // variable containining stripped user input

    TextIO.put("Please enter a word or a phrase: ");

    userInput = TextIO.getln();

    strippedUserInput = stripper(userInput);
    TextIO.putln("stripped:\t" + strippedUserInput);

    reversedUserInput = reverser(strippedUserInput);
    TextIO.putln("reversed:\t" + reversedUserInput);

    if (reversedUserInput.equals(strippedUserInput)) {
      TextIO.putln("This is INDEED a palindrome");
    } else {
      TextIO.putln("This is NOT a palindrome");
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