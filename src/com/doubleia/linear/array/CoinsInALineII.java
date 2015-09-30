package com.doubleia.linear.array;

/**
 * 
 * There are n coins with different value in a line. 
 * Two players take turns to take one or two coins from left side until there are no more coins left. 
 * The player who take the coins with the most value wins.
 * 
 * Could you please decide the first player will win or lose?
 * 
 * Given values array A = [1,2,2], return true.
 * Given A = [1,2,4], return false.
 * 
 * @author wangyingbo
 *
 */
public class CoinsInALineII {
	/**
	 * 
	 * d[i] : most value form i to n
	 * d[i] = max(sum[i] - d[i + 1], sum[i] - d[i + 2])
	 * 
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
    	int n = values.length;
    	if (n == 0) 
    		return false;
    	else if (n == 1 || n == 2)
    		return true;
    	
    	int[] d = new int[n];
    	int[] sum = new int[n];
    	
    	sum[n - 1] = values[n - 1];
    	for (int i = n - 2; i >= 0; i--) {
			sum[i] = sum[i + 1] + values[i];
		}
    	
    	d[n - 1] = values[n - 1];
    	d[n - 2] = values[n - 2] + values[n - 1];
    	
    	for (int i = n - 3; i >= 0; i--) {
			d[i] = sum[i] - Math.min(d[i + 1], d[i + 2]);
    	}
    	
    	if (d[0] >= sum[0] - d[0])
    		return true;
    	else
    		return false;
    }
    
    public static void main(String[] args) {
		CoinsInALineII coins = new CoinsInALineII();
		System.out.println(coins.firstWillWin(new int[] {2,11,6,3,7,13,4,9,5,12,8,1,10}));
	}
}
