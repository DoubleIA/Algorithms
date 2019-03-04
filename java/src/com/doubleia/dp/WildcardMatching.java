package com.doubleia.dp;

/**
 * 
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * * '?' Matches any single character.
 * * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * 
 * @author wangyingbo
 *
 */
public class WildcardMatching {
	/**
	 * @param s : A string
	 * @param p : A string includes "?" and "*"
	 * @return: A boolean
	 */
	public boolean isMatch(String s, String p) {
		// write your code here
		if (s.length() == 0)
			return p.length() == 0 || p.equals("*");
		if (p.equals("*"))
			return true;
		
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		
		for (int i = 1; i <= p.length(); i++) {
			if (dp[0][i - 1] && p.charAt(i - 1) == '*')
				dp[0][i] = true;
			for (int j = 1; j <= s.length(); j++) {
				if (p.charAt(i - 1) == '*')
					dp[j][i] = dp[j - 1][i] || dp[j][i - 1];
				else if (p.charAt(i - 1) == '?' || p.charAt(i - 1) == s.charAt(j - 1))
					dp[j][i] = dp[j - 1][i - 1];
				else
					dp[j][i] = false;
			}
		}
		
		return dp[s.length()][p.length()];
	}
}
