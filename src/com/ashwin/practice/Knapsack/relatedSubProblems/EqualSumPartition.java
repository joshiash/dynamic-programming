package com.ashwin.practice.Knapsack.relatedSubProblems;

public class EqualSumPartition {

    public static void main(final String[] args) {
        final int[] array = new int[] {1, 5, 11, 5};
        final boolean doesSubsetExist = findSubsetSum(array, array.length);
        System.out.println( doesSubsetExist );
    }

    private static boolean findSubsetSum(final int[] array,
                                         final int n) {

        //Base Condition
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum = totalSum + array[i];
        }

        if ( totalSum % 2 != 0) {
            return false;
        }

        final int sumToFind = totalSum / 2;
        return FindSubsetSum(array, n, sumToFind);
    }

    private static boolean FindSubsetSum(final int[] array,
                                         final int n,
                                         final int sumToFind) {
        final boolean[][] t = new boolean[n + 1][sumToFind + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < sumToFind; j++) {
                if (i == 0) {
                    t[i][j] = false;
                }
                if (j == 0) {
                    t[i][j] = true;
                }
            }
        }

        //Choice Diagram
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sumToFind + 1; j++) {
                if (array[i - 1] <= j) {
                    t[i][j] = t[i - 1][ j - array[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }


        return t[n][sumToFind];
    }
}
