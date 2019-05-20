
public class OopTheRealWay {
  public static void main(String[] args) {

    Constants constants = new Constants();

    System.out.println(constants.three);
  }

  
}

class Constants {
  final static double MAX_LENGTH = 9.0;

  final static int ONE = 1;

  final static String NAME = "John Doe";

  public static char A = 'a';

  static String location = "Jakarta";

  public Number ninety = 90;
}
