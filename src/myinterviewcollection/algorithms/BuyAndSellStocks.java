/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.algorithms;

/**
 *
 * @author saddam
 */
public class BuyAndSellStocks {
    
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 5, 5, 6};
        int k = 2;
        int maxProfit = getMaxProfit(prices, k);
        System.out.println("The maximum profit in " + k + " consecutive days is: " + maxProfit);
    }

    public static int getMaxProfit(int[] prices, int k) {
        // Calculate daily differences
        int n = prices.length;
        if (n < 2 || k <= 0) {
            return 0; // No profit can be made
        }
        
        int[] dailyDiff = new int[n - 1];
        for (int i = 1; i < n; i++) {
            dailyDiff[i - 1] = prices[i] - prices[i - 1];
        }

        // Use a sliding window to find the maximum sum of k consecutive differences
        int maxProfit = 0;
        for (int i = 0; i < k && i < dailyDiff.length; i++) {
            maxProfit += dailyDiff[i];
        }

        int currentProfit = maxProfit;
        for (int i = k; i < dailyDiff.length; i++) {
            currentProfit += dailyDiff[i] - dailyDiff[i - k];
            maxProfit = Math.max(maxProfit, currentProfit);
        }

        return maxProfit;
    }

}
