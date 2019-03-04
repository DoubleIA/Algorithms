package com.doubleia.dp;

/**
 * 
 * Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.
 * For s1 = "aabcc", s2 = "dbbca"
 * 
 *   When s3 = "aadbbcbcac", return true.
 *   When s3 = "aadbbbaccc", return false.
 * 
 * O(n2) time or better
 * 
 * @author wangyingbo
 *
 */
public class InterleavingString {
	/**
	 * Determine whether s3 is formed by interleaving of s1 and s2.
	 * @param s1, s2, s3: As description.
	 * @return: true or false.
	 */
	public boolean isInterleave(String s1, String s2, String s3) {
		// write your code here
		if (s1.length() != 0 && s2.length() != 0) {
			if (s1.length() + s2.length() != s3.length()) 
				return false;
		} else if (s1.length() == 0) {
			if (!s2.equals(s3)) 
				return false;
		} else if (!s1.equals(s3))
			return false;
		
		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
		dp[0][0] = true;
		for (int i = 1; i <= s1.length(); i++) 
			dp[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
		
		for (int i = 1; i <= s2.length(); i++) 
			dp[0][i] = s2.substring(0, i).equals(s3.substring(0, i));

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
			}
		}
		
		return dp[s1.length()][s2.length()];
	}
	
//	System.out.println("dp["+i+"]["+j+"] : " + dp[i][j] + ", s2.charAt("+(j-1)+") : " + s2.charAt(j - 1) + ", s1.charAt("+(i-1)+") : " + s1.charAt(i - 1) + ", s3.charAt("+(i + j-1)+") : " + s3.charAt(i + j - 1));
	public static void main(String[] args) {
		InterleavingString inter = new InterleavingString();
		System.out.println(inter.isInterleave("bc", "a", "bca"));
	}
}
