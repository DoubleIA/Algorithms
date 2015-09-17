package com.doubleia.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a string s, find the length of the longest substring T that contains at most k distinct characters.
 * 
 * For example, Given s = "eceba", k = 3,
 * T is "eceb" which its length is 4.
 * 
 * O(n), n is the size of the string s.
 * 
 * @author wangyingbo
 *
 */
public class LongestSubstringwithAtMostKDistinctCharacters {
	/**
     * @param s : A string
     * @return : The length of the longest substring that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
    	if (s == null || k <= 0)
    		return 0;
    	if (k >= s.length())
    		return s.length();
    	
    	int start = 0;
    	int len = 0;
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	
    	for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
				while (map.size() > k) {
					char startChar = s.charAt(start++);
					int count = map.get(startChar);
					if (count > 1)
						map.put(startChar, count - 1);
					else
						map.remove(startChar);
				}
			}
			len = Math.max(len, i - start + 1);
		}
    	
    	return len;
    }
    
    public static void main(String[] args) {
		String s = "abaaaaaacdefa";
		LongestSubstringwithAtMostKDistinctCharacters ls = new LongestSubstringwithAtMostKDistinctCharacters();
		System.out.println(ls.lengthOfLongestSubstringKDistinct(s, 2));
	}
}
