package com.ashwin.practice.Knapsack.relatedSubProblems;

public class MinimumSubsetDifference {

    public static void main(final String[] args) {
        final int[] array = new int[] {1, 2, 7};
        final int minimumSubsetDifference = findMinimumSubsetDifference(array, array.length);
        System.out.println(minimumSubsetDifference + " is the minimum subset difference ");
    }

    private static int findMinimumSubsetDifference(final int[] array,
                                     final int size) {
        int totalSum = 0;
        for (int i = 0; i < array.length; i++) {
            totalSum = totalSum + array[i];
        }

        final boolean[][] t = new boolean[size + 1][totalSum + 1];

        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < totalSum + 1; j++) {
                if (i == 0) {
                    t[i][j] = false;
                }
                if (j == 0) {
                    t[i][j] = true;
                }
            }
        }

        for (int i = 1; i < size + 1; i++) {
            for (int j = 1; j < totalSum + 1; j++) {
                if (array[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] || t[i - 1][j - array[i - 1]];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        int largestSmallerSum = Integer.MIN_VALUE;
        for (int j = 0; j < (totalSum + 1) / 2; j++) {
            if (t[size][j]) {
                largestSmallerSum = j;
            }
        }

        return totalSum - 2 * largestSmallerSum;
    }
}
