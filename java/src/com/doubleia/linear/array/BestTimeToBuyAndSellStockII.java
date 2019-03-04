package com.doubleia.linear.array;

/**
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 * 
 * Given an example [2,1,2,0,1], return 2
 * 
 * @author wangyingbo
 *
 */
public class BestTimeToBuyAndSellStockII {
	/**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
    	if (prices.length < 2) 
    		return 0;
    	
    	int max = 0;
    	
    	for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i + 1] > prices[i]) 
				max += prices[i + 1] - prices[i];
		}
    	
    	return max;
    }
    
    public static void main(String[] args) {
		BestTimeToBuyAndSellStockII stock = new BestTimeToBuyAndSellStockII();
		System.out.println(stock.maxProfit(new int[] {2,1,2,0,1}));
	}
}
