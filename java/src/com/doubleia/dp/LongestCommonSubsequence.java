package com.doubleia.dp;

/**
 * 
 * Given two strings, find the longest common subsequence (LCS).
 * Your code should return the length of LCS.
 * 
 * For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.
 * For "ABCD" and "EACB", the LCS is "AC", return 2.
 * 
 * @author wangyingbo
 *
 */
public class LongestCommonSubsequence {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
	public int longestCommonSubsequence(String A, String B) {
		// write your code here
		int max = 0;
		if (A == null || B == null || A.length() == 0 || B.length() == 0)
			return max;
		
		int[][] dp = new int[A.length() + 1][B.length() + 1];
		for (int i = 0; i < A.length(); i++)
			dp[i][0] = 0;
		for (int i = 0; i < B.length(); i++)
			dp[0][i] = 0;
		
		for (int i = 1; i <= A.length(); i++) {
			for (int j = 1; j <= B.length(); j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else 
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				max = Math.max(max, dp[i][j]);
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		LongestCommonSubsequence lon = new LongestCommonSubsequence();
		System.out.println(lon.longestCommonSubsequence("bedaacbade", "dccaeedbeb"));
	}
}
