package com.ashwin.practice.Knapsack;

public class Knapsack01TopDown {

    public static int findMaxProfit(final int[] weights,
                                    final int[] value,
                                    final int capacity,
                                    final int size,
                                    final int[][] dp) {
        // Base Condition

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                if (size == 0 || capacity == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        //Choice Diagram
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 8; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(value[i - 1] + dp[i - 1][j - weights[i - 1]]
                            , dp[i - 1][j]);
                }

                if (weights[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[size][capacity];
    }

    public static void main(final String[] args) {
        final int[] weights = new int[] {1, 3, 4, 5};
        final int[] value = new int[] {1, 4, 5, 7};
        final int maxWeight = 7;
        final int[][] dp = new int[4 + 1][7 + 1];
        final int maxProfit = findMaxProfit(weights, value, maxWeight, 4, dp);
        System.out.println("Max Profit for the given inputs is " + maxProfit);
    }
}
