package com.doubleia.srb.bfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 *  Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that: 
 *  1. Only one letter can be changed at a time
 *  2. Each intermediate word must exist in the dictionary
 * 
 *  Given:
 * 
 *   start = "hit"
 *   end = "cog"
 *   dict = ["hot","dot","dog","lot","log"]
 * 
 *  As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *  return its length 5. 
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * 
 * Breadth First Search
 * 
 * @author wangyingbo
 *
 */
public class WordLadder {
	/**
	 * @param start, a string
	 * @param end, a string
	 * @param dict, a set of string
	 * @return an integer
	 */
	public int ladderLength(String start, String end, Set<String> dict) {
		// write your code here
		if (start == null || end == null || start.equals(end) || start.length() != end.length())
			return 0;
		if (isOneDiff(start, end))
			return 2;
		
		Queue<String> queue = new LinkedList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		queue.add(start);
		map.put(start, 1);
		
		while (!queue.isEmpty()) {
			String head = queue.poll();
			int depth = map.get(head);
			
			for (int i = 0; i < head.length(); i++) {
				for (char j = 'a'; j < 'z'; j++) {
					if (head.charAt(i) == j)
						continue;
					
					StringBuilder builder = new StringBuilder(head);
					builder.setCharAt(i, j);
					if (builder.toString().equals(end))
						return depth + 1;
					if (dict.contains(builder.toString()) && !map.containsKey(builder.toString())) {
						queue.add(builder.toString());
						map.put(builder.toString(), depth + 1);
					}
				}
			}
		}
		
		return 0;
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
		WordLadder wl = new WordLadder();
		Set<String> dict = new HashSet<String>();
		dict.addAll(Arrays.asList(new String[]{"hot","dot","dog","lot","log"}));
		System.out.println(wl.ladderLength("hog", "cog", dict));
	}
}
