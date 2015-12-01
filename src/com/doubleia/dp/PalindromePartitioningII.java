package com.doubleia.dp;

/**
 * 
 * Given a string s, cut s into some substrings such that every substring is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 
 * @author wangyingbo
 *
 */
public class PalindromePartitioningII {
	/**
	 * @param s a string
	 * @return an integer
	 */
	public int minCut(String s) {
		// write your code here
		if (s == null || s.length() == 0)
			return 0;
		
		boolean[][] dp = new boolean[s.length()][s.length()];
		
		int[] min = new int[s.length() + 1];
		for (int i = 0; i <= s.length(); i++) 
			min[i] = s.length() - i - 1;
		
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				dp[i][j] = false;
				if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
					dp[i][j] = true;
					min[i] = Math.min(min[i], min[j + 1] + 1);
				}
			}
		}
		
		return min[0];
	}
	
	public static void main(String[] args) {
		PalindromePartitioningII pal = new PalindromePartitioningII();
		System.out.println(pal.minCut("abcba"));
	}
}
