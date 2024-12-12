package com.ashwin.practice.Knapsack;

public class Knapsack01Recursion {

    public static int findMaxProfit(final int[] weights,
                                    final int[] value,
                                    final int capacity,
                                    final int size) {
        // Base Condition
        if (size == 0 || capacity == 0) {
           return 0;
        }

        //Choice Diagram
        if (weights[size - 1] <= capacity) {
             return Math.max(value[size - 1] +
                     findMaxProfit(weights, value, capacity - weights[size - 1], size - 1),
                     findMaxProfit(weights, value, capacity , size - 1));
        }

        if (weights[size - 1] > capacity) {
           return findMaxProfit(weights, value, capacity, size - 1);
        }

        return 0;
    }

    public static void main(final String[] args) {
        final int[] weights = new int[] {1, 3, 4, 5};
        final int[] value = new int[] {1, 4, 5, 7};
        final int maxWeight = 7;
        final int maxProfit = findMaxProfit(weights, value, maxWeight, 4);
        System.out.println("Max Profit for the given inputs is " + maxProfit);
    }
}
