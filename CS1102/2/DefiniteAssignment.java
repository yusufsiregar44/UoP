public class DefiniteAssignment {
  public static void main (String[] args) {
    int x;
    int y;

    x = 1;
    y = 0;

    if (x == 1) {
      y = 2;
    } 
    
    if (x == 0){
      y = 3;
    }

    /**
     * 
     * This code below will result in an error because
     * the variable y is not going to be initialized
     * 
     * The code above, though nearly simillar, will be succesfully compiled because
     * variable y is indeed initialized
     * 
    int x;
    int y;

    x = 1;

    if (x == 1) {
      y = 2;
    } 
    
    if (x == 0){
      y = 3;
    }
     */

    System.out.println(y);
  }
}