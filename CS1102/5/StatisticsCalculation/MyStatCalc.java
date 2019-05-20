public class MyStatCalc {
  public static void main (String[] args) {
    StatCalc myStatCalc;
    double[] setOfNumbers = {5, 7, 12, 23, 3, 2, 8, 14, 10, 5, 9, 13};

    myStatCalc = new StatCalc();

    for (double n : setOfNumbers) {
      myStatCalc.enter(n);
    }

    System.out.println("Count -> \t" + myStatCalc.getCount());
    System.out.println("Mean -> \t" + myStatCalc.getMean());
    System.out.println("Standard Deviation -> \t" + myStatCalc.getStandardDeviation());
  }
}

class StatCalc {
 
  private int count;   // Number of numbers that have been entered.
  private double sum;  // The sum of all the items that have been entered.
  private double squareSum;  // The sum of the squares of all the items.

  /**
   * Add a number to the dataset.  The statistics will be computed for all
   * the numbers that have been added to the dataset using this method.
   */
  public void enter(double num) {
         count++;
         sum += num;
         squareSum += num*num;
  }

  /**
   * Return the number of items that have been entered into the dataset.
   */
  public int getCount() {
         return count;
  }

  /**
   * Return the sum of all the numbers that have been entered.
   */
  public double getSum() {
         return sum;
  }

  /**
   * Return the average of all the items that have been entered.
   * The return value is Double.NaN if no numbers have been entered.
  */
  public double getMean() {
         return sum / count;
  }

  /**
   * Return the standard deviation of all the items that have been entered.
   * The return value is Double.NaN if no numbers have been entered.
   */
  public double getStandardDeviation() {
         double mean = getMean();
         return Math.sqrt( squareSum/count - mean*mean );
  }         
}  // end class StatCalc