public class Matrix {

  final static Number NUMBER_OF_COLUMNS = 3;
  final static Number NUMBER_OF_ROWS = 3;

  public static void main (String[] args) throws Exception {

    if (NUMBER_OF_COLUMNS != NUMBER_OF_ROWS) {
      System.out.println("This is not a square matrix");
    } else {
  
      int[][] m = {
        {10, 12, 11},
        {9, 8, 31},
        {2, 16, 24}
      };
    
      int numberOfColumnsToBeCalculated = NUMBER_OF_COLUMNS.intValue();
      int numberOfRowsToBeCalculated = NUMBER_OF_ROWS.intValue();
      int diagonalTotal = 0;

      int currentDiagonalRow = numberOfRowsToBeCalculated - 1;
      int currentDiagonalColumn = 0;
      System.out.println(currentDiagonalRow);
      for (int i = 0; i < m.length; i ++) {
        System.out.println(currentDiagonalRow);
        System.out.println(currentDiagonalColumn);
        // System.out.println(m[currentDiagonalRow][currentDiagonalColumn]);

        // diagonalTotal += m[currentDiagonalRow][currentDiagonalColumn];
        currentDiagonalRow = numberOfRowsToBeCalculated - 1;
        // currentDiagonalColumn = numberOfColumnsToBeCalculated + 1;
      }
  
      System.out.println(diagonalTotal);
    }
  }

}