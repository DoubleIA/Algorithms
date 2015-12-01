package com.doubleia.srb.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * 
 * Given s = "aab", return:
 * 
 * [
 *  ["aa","b"],
 *  ["a","a","b"]
 * ]
 * 
 * @author wangyingbo
 *
 */
public class PalindromePartitioning {
	/**
	 * @param s : A string
	 * @return: A list of lists of string
	 */
	public List<List<String>> partition(String s) {
		// write your code here
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> array = new ArrayList<String>();
		
		if (s == null || s.length() == 0) {
			result.add(array);
			return result;
		}
		
		boolean[][] dp = new boolean[s.length()][s.length()];
		
		dp(s, dp);
		dfs(s, 0, dp, array, result);
		
		return result;
	}
	
	private void dp(String s, boolean[][] dp) {
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				dp[i][j] = false;
				if (i == j)
					dp[i][j] = true;
				else {
					if (s.charAt(i) == s.charAt(j))
						if (j == i + 1 || dp[i + 1][j - 1])
							dp[i][j] = true;
				}
			}
		}
	}
	
	private void dfs(String s, int begin, boolean[][] dp, List<String> array, List<List<String>> result) {
		if (begin == s.length()) {
			result.add(array);
			return;
		}
		
		for (int i = begin; i < s.length(); i++) {
			if (dp[begin][i]) {
				List<String> tmp = new ArrayList<String>(array);
				tmp.add(s.substring(begin, i + 1));
				dfs(s, i + 1, dp, tmp, result);
			}
		}
	}
	
	public static void main(String[] args) {
		PalindromePartitioning pal = new PalindromePartitioning();
		System.out.println(pal.partition("aab"));
	}
}
