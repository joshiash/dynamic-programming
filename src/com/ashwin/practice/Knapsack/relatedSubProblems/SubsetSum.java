package com.ashwin.practice.Knapsack.relatedSubProblems;

public class SubsetSum {

    public static void main(final String[] args) {
        final int[] array = new int[] {2, 3, 7, 8, 10};
        final int sum = 11;
        final boolean doesSubsetExist = findSubsetSum(array, sum, array.length);
        System.out.println(doesSubsetExist + " :: subset with weight " + sum);
    }

    private static boolean findSubsetSum(final int[] array,
                                         final int sum,
                                         final int size) {

        final boolean[][] t = new boolean[size + 1][sum + 1];

        //Base Condition

        for (int j = 0; j < sum + 1; j++) {
            for (int i = 0; i < size + 1; i++) {
                if (i == 0) {
                    t[i][j] = false;
                }
                if (j == 0) {
                    t[i][j] = true;
                }
            }
        }


        //Choice Diagram
        for (int i = 1; i < size + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (array[i - 1] <= j) {
                    t[i][j] = t[i - 1][ j - array[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[size][sum];
    }

}
