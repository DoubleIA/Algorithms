package com.doubleia.dp;

/**
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * 
 * Given prices = [4,4,6,1,1,4,2,5], and k = 2, return 6.
 * 
 * You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * 
 * O(nk) time.
 * 
 * @author wangyingbo
 *
 */
public class BestTimeToBuyAndSellStockIV {
	/**
	 * 
	 * global[i][j] means the maximum profit by completing at most j transactions in the first i days.
	 * local[i][j] means the maximum profit by completing j transactions in the first i days, 
	 * and the last transaction happens on day i.
	 * 
	 * local[i][j] = max(global[i - 1][j - 1] + max(diff, 0), local[i - 1][j] + diff)
	 * global[i][j] = max(global[i - 1][j], local[i][j])
	 * diff = prices[i] - prices[i - 1]
	 * 
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        // write your code here
    	int n = prices.length;
    	if (n < 2) 
    		return 0;
    	
    	if (k >= n / 2) {
    		int max = 0;
    		for (int i = 0; i < n - 1; i++) {
				if (prices[i + 1] > prices[i])
					max += prices[i + 1] - prices[i];
			}
    		return max;
    	}
    	
    	int[] local = new int[n];
    	int[] global = new int[n];
    	
    	for (int i = 1; i < n; i++) {
    		int diff = prices[i] - prices[i - 1];
			for (int j = i; j > 0; j--) {
				local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
				global[j] = Math.max(global[j], local[j]);
			}
		}
    	
    	return global[k];
    }
    
    public static void main(String[] args) {
		BestTimeToBuyAndSellStockIV stock = new BestTimeToBuyAndSellStockIV();
		System.out.println(stock.maxProfit(2, new int[] {4,4,6,1,1,4,2,5}));
	}
}
