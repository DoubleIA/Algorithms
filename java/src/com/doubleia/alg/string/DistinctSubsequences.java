package com.doubleia.alg.string;

/**
 * 
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original string by deleting 
 * some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * 
 * Given S = "rabbbit", T = "rabbit", return 3.
 * 
 * Do it in O(n2) time and O(n) memory. 
 * O(n2) memory is also acceptable if you do not know how to optimize memory.
 * 
 * @author wangyingbo
 *
 */
public class DistinctSubsequences {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
	public int numDistinct(String S, String T) {
		// write your code here
		if (S == null || T == null || S.length() < T.length())
			return 0;
		
		int[] dp = new int[T.length()];
		
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			for (int j = dp.length - 1; j >= 0; j--) {
				if (c == T.charAt(j))
					dp[j] = dp[j] + (j != 0 ? dp[j - 1] : 1);
			}
		}
		
		return dp[T.length() - 1];
	}
	
	public static void main(String[] args) {
		DistinctSubsequences dis = new DistinctSubsequences();
		System.out.println(dis.numDistinct("rabbbit", "rabbit"));
	}
	/**
	 * 
	 * if (S == null || T == null || S.length() < T.length())
			return 0;
		
		int[][] dp = new int[S.length() + 1][T.length() + 1];
		
		for (int i = 0; i <= S.length(); i++) {
			dp[i][0] = 1;
		}
		
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length() && j <= i; j++) {
				dp[i][j] = dp[i - 1][j];
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					dp[i][j] += dp[i - 1][j - 1];
				}
			}
		}
		
		return dp[S.length()][T.length()];
	 * 
	 */
}
