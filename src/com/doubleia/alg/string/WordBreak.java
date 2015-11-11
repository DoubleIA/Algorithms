package com.doubleia.alg.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one or more dictionary words.
 * 
 * Given s = "lintcode", dict = ["lint", "code"].
 * Return true because "lintcode" can be break as "lint code".
 * 
 * @author wangyingbo
 *
 */
public class WordBreak {
	/**
	 * @param s : A string s
	 * @param dict : A dictionary of words dict
	 */
	public boolean wordBreak(String s, Set<String> dict) {
		// write your code here
		boolean[] word = new boolean[s.length() + 1];
		word[0] = true;
		for (int i = 1; i < word.length; i++) {
			word[i] = false;
		}
		
		for (int i = 1; i < s.length() + 1; i++) {
//			System.out.println("word["+ (i - 1) + "]: " + word[i - 1]);
			for (int j = i - 1; j >= 0; j--) {
//				System.out.println("i: " + i + ", j: " + j + ", s.sub: " + s.substring(j, i));
				if (word[j] && dict.contains(s.substring(j, i))) {
					word[i] = true;
					break;
				}
			}
		}
		
		return word[s.length()];
	}
	
	public static void main(String[] args) {
		WordBreak word = new WordBreak();
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		System.out.println(word.wordBreak("ab", dict));
	}
}
