package com.doubleia.alg.string;

/**
 * 
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * 
 * Given the string = "abcdzdcab", return "cdzdc".
 * 
 * O(n2) time is acceptable. Can you do it in O(n) time.
 * 
 * @author wangyingbo
 *
 */
public class LongestPalindromicSubstring {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
	public String longestPalindrome(String s) {
		// Write your code here
		if (s == null || s.isEmpty())
			return null;
		if (s.length() == 1)
			return s;
		
		String longest = s.substring(0, 1);
		
		for (int i = 0; i < s.length(); i++) {
			String tmp = find(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
			tmp = find(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
		
		return longest	;
	}
	
	private String find(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}
	
	public static void main(String[] args) {
		LongestPalindromicSubstring lon = new LongestPalindromicSubstring();
		System.out.println(lon.longestPalindrome("abcdzdcab"));
	}
}
