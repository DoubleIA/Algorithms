package com.doubleia.linear.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Implement an algorithm to determine if a string has all unique characters.
 * 
 * Given "abc", return true.
 * Given "aab", return false.
 * 
 * What if you can not use additional data structures?
 * Tow pass O(n^2)
 * 
 * @author wangyingbo
 *
 */
public class UniqueCharacters {
    /**
     * @param str: a string
     * @return: a boolean
     */
	public boolean isUnique(String str) {
		// write your code here
		Set<Character> set = new HashSet<Character>();
		
		for (int i = 0; i < str.length(); i++) {
			if (set.contains(str.charAt(i)))
				return false;
			set.add(str.charAt(i));
		}
		
		return true;
	}
}
