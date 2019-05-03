import java.io.*;
import icecream.TextIO;

/**
 A program which counts number of ice creams sold from a pre-defined file
 and also counts number of strawberry ice creams sold
*/

public class IceCreamConesCounter {

  public static void main (String[] args) {
    boolean endOfFile = false; // variable to tell whether end of file has been reached
    int iceCreamsSold = 0; // variable to contain number of ice creams sold
    int strawberryIceCreams = 0; // variable to contain number of strawberry ice creams sold

    TextIO obj = new TextIO(); // instantiate TextIO class

    obj.readFile("./icecream.dat"); // reads pre-defined file

    while(endOfFile == false) {
      String currentIceCream = TextIO.getln(); // reads text on file's current line
      iceCreamsSold ++;

      if (currentIceCream.equals("Strawberry")) {
        strawberryIceCreams ++;
      }
      if (TextIO.eof()) {
        endOfFile = true;
      }
    }
    
    System.out.println("There are " + iceCreamsSold + " ice creams sold and there are " + strawberryIceCreams + " strawberry ice creams sold");
  }
}