package com.ashwin.practice.Knapsack;

public class Knapsack01Memorization {

    public static int findMaxProfit(final int[] weights,
                                    final int[] value,
                                    final int capacity,
                                    final int size,
                                    final int[][] dp) {
        // Base Condition
        if (size == 0 || capacity == 0) {
           return 0;
        }
        if (dp[size][capacity] != -1) {
            return dp[size][capacity];
        }

        //Choice Diagram
        if (weights[size - 1] <= capacity) {
             dp[size][capacity] = Math.max(value[size - 1] +
                     findMaxProfit(weights, value, capacity - weights[size - 1], size - 1, dp),
                     findMaxProfit(weights, value, capacity , size - 1, dp));
             return dp[size][capacity];
        }

        if (weights[size - 1] > capacity) {
            dp[size][capacity] = findMaxProfit(weights, value, capacity, size - 1, dp);
            return dp[size][capacity];
        }

        return 0;
    }

    public static void main(final String[] args) {
        final int[] weights = new int[] {1, 3, 4, 5};
        final int[] value = new int[] {1, 4, 5, 7};
        final int maxWeight = 7;
        final int[][] dp = new int[4 + 1][7 + 1];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                dp[i][j] = -1;
            }
        }
        final int maxProfit = findMaxProfit(weights, value, maxWeight, 4, dp);
        System.out.println("Max Profit for the given inputs is " + maxProfit);
    }
}
