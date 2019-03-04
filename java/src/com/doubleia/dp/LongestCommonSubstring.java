package com.doubleia.dp;

/**
 * 
 * Given two strings, find the longest common substring.
 * Return the length of it.
 * 
 * Given A = "ABCD", B = "CBCE", return 2.
 * 
 * The characters in substring should occur continuously in original string. This is different with subsequence.
 * 
 * O(n x m) time and memory.
 * 
 * @author wangyingbo
 *
 */
public class LongestCommonSubstring {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
	public int longestCommonSubstring(String A, String B) {
		// write your code here
		int max = 0;
		if (A == null || B == null || A.length() == 0 || B.length() == 0)
			return max;
		
		int[][] dp = new int[A.length() + 1][B.length() + 1];
		
		for (int i = 0; i <= A.length(); i++)
			dp[i][0] = 0;
		for (int i = 0; i <= B.length(); i++)
			dp[0][i] = 0;
		
		for (int i = 1; i <= A.length(); i++) {
			for (int j = 1; j <= B.length(); j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = 0;
				max = Math.max(max, dp[i][j]);
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		LongestCommonSubstring lon = new LongestCommonSubstring();
		System.out.println(lon.longestCommonSubstring("abccccccccccde", "dbccccccabccde"));
	}
}
