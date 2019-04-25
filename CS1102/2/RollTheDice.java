import java.io.*;

public class RollTheDice {

  public static void main(String[] arguments) {

    int numberOfTimes = 0;
    boolean doWhile = true;
    
    while (doWhile) {
      double dice1 = (int)(Math.random() * 6) + 1;

      double dice2 = (int)(Math.random() * 6) + 1;

      numberOfTimes ++;

      if (dice1 == 1 && dice2 == 1) {
        doWhile = false;
      }
    }

    System.out.println(numberOfTimes);
  }
}