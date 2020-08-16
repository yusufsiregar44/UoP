package com.week_1.benchmark_algorithm;

import java.util.Arrays;

public class BenchmarkAlgorithm {
    int constant = 100000;
    int[] intArr1 = new int[constant];
    int[] intArr2 = intArr1;

    public BenchmarkAlgorithm() {
        for (int i = 0; i < constant; i++) {
            int currentInt = (int)(Integer.MAX_VALUE * Math.random());
            intArr1[i] = currentInt;
            intArr2[i] = currentInt;
        }

        long startTime1 = System.currentTimeMillis();
        selectionSort(intArr1);
        long runTime1 = System.currentTimeMillis() - startTime1;

        long startTime2 = System.currentTimeMillis();
        Arrays.sort(intArr2);
        long runTime2 = System.currentTimeMillis() - startTime2;

        System.out.println("selection sort -> " + runTime1);
        System.out.println("insertion sort -> " + runTime2);
    }

    static void selectionSort(int[] A) {
        // Sort A into increasing order, using selection sort

        for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {
            // Find the largest item among A[0], A[1], ...,
            // A[lastPlace], and move it into position lastPlace
            // by swapping it with the number that is currently
            // in position lastPlace.

            int maxLoc = 0;  // Location of largest item seen so far.

            for (int j = 1; j <= lastPlace; j++) {
                if (A[j] > A[maxLoc]) {
                    // Since A[j] is bigger than the maximum we've seen
                    // so far, j is the new location of the maximum value
                    // we've seen so far.
                    maxLoc = j;
                }
            }

            int temp = A[maxLoc];  // Swap largest item with A[lastPlace].
            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;

        }  // end of for loop

    }

}
