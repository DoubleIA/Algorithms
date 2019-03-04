package com.doubleia.alg.string;

/**
 * 
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * 
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * 
 * @author wangyingbo
 *
 */
public class RegularExpressionMatching {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
	public boolean isMatch(String s, String p) {
		// write your code here
		if (p.length() == 0) 
			return s.length() == 0;
		if (p.length() == 1)
			return p.equals(s) || p.equals(".");
		if (s.length() == 0) {
			int count = 0;
			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) != '*') {
					count++;
					if (count == 2) return false;
				} else {
					count = 0;
				}
			}
			return true;
		}
		
		if (p.charAt(1) != '*') {
			if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
				return isMatch(s.substring(1), p.substring(1));
			else
				return false;
		} else {
			while (s.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
				if (isMatch(s, p.substring(2))) {
					return true;
				}
				s = s.substring(1);
			}
			return isMatch(s, p.substring(2));
		}
	}

	public static void main(String[] args) {
		RegularExpressionMatching reg = new RegularExpressionMatching();
		System.out.println(reg.isMatch("aaaaabcgdhdhjajajajawababaw", "..........................."));
	}
	
}
