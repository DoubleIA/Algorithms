package com.doubleia.srb.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 *  Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that: 
 *  
 *  1. Only one letter can be changed at a time
 *  2. Each intermediate word must exist in the dictionary
 *  
 *  Given
 *   start = "hit"
 *   end = "cog"
 *   dict = ["hot","dot","dog","lot","log"]
 *  
 *  Return
 *    [
 *    ["hit","hot","dot","dog","cog"],
 *    ["hit","hot","lot","log","cog"]
 *    ]
 *  
 *  All words have the same length.
 *  All words contain only lowercase alphabetic characters.
 *  
 * @author wangyingbo
 *
 */
public class WordLadderII {
	/**
	 * @param start, a string
	 * @param end, a string
	 * @param dict, a set of string
	 * @return a list of lists of string
	 */
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		// write your code here
		List<List<String>> results = new ArrayList<List<String>>();
		List<String> res = new ArrayList<String>();
		if (start == null || end == null || start.equals(end) || start.length() != end.length()) {
			results.add(res);
			return results;
		}
		if (isOneDiff(start, end)) {
			res.add(start);
			res.add(end);
			results.add(res);
			return results;
		}
		
		Queue<String> queue = new LinkedList<String>();
			
		return results;
	}
	
	private boolean isOneDiff(String start, String end) {
		int cnt = 0;
		for (int i = 0; i < start.length(); i++) {
			if (start.charAt(i) != end.charAt(i))
				cnt++;
		}
		if (cnt == 1)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		WordLadderII wl2 = new WordLadderII();
		Set<String> dict = new HashSet<String>();
		dict.addAll(Arrays.asList(new String[]{"hot","dot","dog","lot","log"}));
		System.out.println(wl2.findLadders("hit", "cog", dict));
	}
}
