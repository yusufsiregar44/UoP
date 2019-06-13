public class JavaApplication2 {

  public static void main(String[] args) {
          
          int numberOfRows = 3;
          int numberOfColumns = 2;
          
          int[][] m   =  new  int[][] {  {1,2,3}, {4,5,6}, {7,8,9} };
          int result =  0;
  
          if (numberOfRows == numberOfColumns) {
              for (int rowIndex =  0;  rowIndex <  m.length;  rowIndex++) {
                  int columnIndex =  m.length  - (rowIndex  +  1);
                  result +=  m[rowIndex][columnIndex];
              } 
              System.out.println(result);
          }
          else {
              System.out.println("This is not a square matrix");
          }
      }
  }
  