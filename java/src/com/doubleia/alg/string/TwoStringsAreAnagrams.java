package com.doubleia.alg.string;

/**
 * 
 * Write a method anagram(s,t) to decide if two strings are anagrams or not.
 * 
 * Given s="abcd", t="dcab", return true.
 * 
 * O(n) time, O(1) extra space
 * 
 * @author wangyingbo
 *
 */
public class TwoStringsAreAnagrams {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
	public boolean anagram(String s, String t) {
		// write your code here
		if (s == null || t == null || s.length() != t.length())
			return false;
		
		for (int i = 0; i < s.length(); i++) {
			if (t.indexOf(s.charAt(i)) == -1)
				return false;
		}
		
		return true;
	}
}
