
public class Block {
  public static void main(String args[]) {

    {
      String output = "Hello World in Block";
      System.out.println(output);
    }


    /**
     * System.out.println("Out -> ", output); 
     * 
     * This statement is not applicable for the varibale output is declared inside a block, thus
     * making it a local variable to the block, saving memory after the block has been executed
     */
    
    System.out.println("Hello World out Block"); 
  }
}