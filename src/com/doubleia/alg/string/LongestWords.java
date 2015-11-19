package com.doubleia.alg.string;

import java.util.ArrayList;

/**
 * 
 * Given a dictionary, find all of the longest words in the dictionary.
 * 
 * Given 
 * {
 *  "dog",
 *  "google",
 *  "facebook",
 *  "internationalization",
 *  "blabla"
 * }
 * the longest words are(is) ["internationalization"].
 * 
 * Given
 * 
 * {
 *  "like",
 *  "love",
 *  "hate",
 *  "yes"
 * }
 * the longest words are ["like", "love", "hate"].
 * 
 * It's easy to solve it in two passes, can you do it in one pass?
 * 
 * @author wangyingbo
 *
 */
public class LongestWords {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
	ArrayList<String> longestWords(String[] dictionary) {
		// write your code here
		if (dictionary == null || dictionary.length == 0)
			return null;
		ArrayList<String> res = new ArrayList<String>();
		int max = 0;
		
		for (String s : dictionary) {
			if (s.length() > max) {
				max = s.length();
				res.clear();
				res.add(s);
			} else if (s.length() == max) {
				res.add(s);
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		LongestWords lon = new LongestWords();
		System.out.println(lon.longestWords(new String[]{"abc", "def", "eld"}));
	}
}
