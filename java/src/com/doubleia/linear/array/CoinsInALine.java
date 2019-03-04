package com.doubleia.linear.array;

/**
 * 
 * There are n coins in a line. Two players take turns to take one or two coins from right side 
 * until there are no more coins left. The player who take the last coin wins.
 * 
 * Could you please decide the first play will win or lose?
 * 
 * n = 1, return true.
 * n = 2, return true.
 * n = 3, return false.
 * n = 4, return true.
 * n = 5, return true.
 * 
 * O(n) time and O(1) memory
 * 
 * @author wangyingbo
 *
 */
public class CoinsInALine {
	/**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
    	if (n % 3 == 0)
    		return false;
    	return true;
    }

    public static void main(String[] args) {
		CoinsInALine coins = new CoinsInALine();
		System.out.println(coins.firstWillWin(3));
	}
}
