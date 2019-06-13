public class Matrix {

  final static Number NUMBER_OF_COLUMNS = 3;
  final static Number NUMBER_OF_ROWS = 3;

  public static void main (String[] args) throws Exception {

    if (NUMBER_OF_COLUMNS != NUMBER_OF_ROWS) {
      System.out.println("This is not a square matrix");
    } else {
  
      int[][] m = new int[][] {
        {10, 12, 11},
        {9, 8, 31},
        {2, 16, 24}
      };

      int totalDiagonal = 0;
      for (int i = 0; i < m.length; i ++) {
        int columnIndex = m.length - (i + 1);
        totalDiagonal += m[i][columnIndex];
      }
  
      System.out.println(totalDiagonal);
    }
  }

}