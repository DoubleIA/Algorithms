package com.doubleia.linear.array;

/**
 * 
 * There are n coins in a line. Two players take turns to take a coin from one of the ends of the line
 * until there are no more coins left. The player with the larger amount of money wins.
 * 
 * Could you please decide the first player will win or lose?
 * 
 * Given array A = [3,2,2], return true.
 * Given array A = [1,2,4], return true.
 * Given array A = [1,20,4], return false.
 * 
 * Challenge :
 *   Follow Up Question:
 *   
 *   If n is even. Is there any hacky algorithm that can decide 
 *   whether first player will win or lose in O(1) memory and O(n) time?
 * 
 * @author wangyingbo
 *
 */
public class CoinsInALineIII {
	/**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
    	int n = values.length;
    	int[][] d = new int[n][n];
    	int[][] sum = new int[n][n];
    	
    	for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < sum.length; j++) {
				sum[i][j] = values[j] + (i==j ? 0 : sum[i][j - 1]);
			}
		}
    	
    	for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < sum.length; j++) {
				if (i == j) {
					d[i][j] = values[j];
				} else {
					d[i][j] = sum[i][j] - Math.min(d[i + 1][j], d[i][j - 1]);
				}
//				System.out.println("i : " + i + ", j : " + j + ", d["+i+"]["+j+"] : " + d[i][j]);
			}
		}
    	
    	if (2 * d[0][n - 1] - sum[0][n - 1] > 0)
    		return true;
    	else
    		return false;
    }
    
    public static void main(String[] args) {
		CoinsInALineIII coins = new CoinsInALineIII();
		System.out.println(coins.firstWillWin(new int[] {6,13,8,12,3,1,11,9,4,2,5,10,7}));
	}
}
