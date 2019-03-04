package com.doubleia.linear.array;

/**
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * 
 * Given an example [4,4,6,1,1,4,2,5], return 6.
 * 
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 
 * @author wangyingbo
 *
 */
public class BestTimeToBuyAndSellStockIII {
	/**
	 * d[i] means max profit between i and n - 1
	 * 
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
    	int n = prices.length;
    	if (n < 2)
    		return 0;
    	if (n == 2 && prices[1] > prices[0])
    		return prices[1] - prices[0];
    	
    	int[] d = new int[n];
    	
    	for (int i = 0; i < d.length; i++) {
    		int curr = prices[i];
			for (int j = i + 1; j < d.length; j++) {
				curr = Math.min(curr, prices[j]);
				d[i] = Math.max(d[i], prices[j] - curr);
			}
		}
    	
    	int min = prices[0];
    	int max = 0;
    	for (int i = 1; i < n - 2; i++) {
			min = Math.min(min, prices[i]);
			max = Math.max(max, prices[i] - min + d[i + 1]);
		}
    	
    	return Math.max(max, d[0]);
    }
    
    public static void main(String[] args) {
		BestTimeToBuyAndSellStockIII stock = new BestTimeToBuyAndSellStockIII();
		System.out.println(stock.maxProfit(new int[] {1,2}));
	}
}
