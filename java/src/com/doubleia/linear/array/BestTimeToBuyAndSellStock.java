package com.doubleia.linear.array;

/**
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction 
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * 
 * Given an example [3,2,3,1,2], return 1
 * 
 * @author wangyingbo
 *
 */
public class BestTimeToBuyAndSellStock {
	/**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
    	if (prices.length == 0)
    		return 0;
    	
    	int ans = 0;
    	int max = prices[prices.length - 1];
    	for (int i = prices.length - 2; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			ans = Math.max(ans, max - prices[i]);
		}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
		BestTimeToBuyAndSellStock stock = new BestTimeToBuyAndSellStock();
		System.out.println(stock.maxProfit(new int[] {1,2}));
	}
}
