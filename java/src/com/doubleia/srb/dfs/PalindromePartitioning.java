package com.doubleia.srb.dfs;

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
			for (int j = 0; j < s.length(); j++) {
				dp[i][j] = false;
				if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]))
					dp[i][j] = true;
			}
		}
	}
	
	private void dfs(String s, int start, boolean[][] dp, List<String> array, List<List<String>> result) {
		if (start == s.length()) {
			result.add(array);
			return;
		}
		for (int i = start; i < s.length(); i++) {
			if (dp[start][i]) {
				List<String> arr = new ArrayList<String>(array);
				arr.add(s.substring(start, i + 1));
				dfs(s, i + 1, dp, arr, result);
			}
		}
	}


	public static void main(String[] args) {
		PalindromePartitioning pal = new PalindromePartitioning();
		System.out.println(pal.partition("aab"));
	}
}
