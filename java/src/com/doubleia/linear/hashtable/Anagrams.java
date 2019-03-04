package com.doubleia.linear.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].
 * Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].
 * 
 * All inputs will be in lower-case
 * 
 * @author wangyingbo
 *
 */
public class Anagrams {
	/**
     * @param strs: A list of strings
     * @return: A list of strings
     */
	public List<String> anagrams(String[] strs) {
		// write your code here
		List<String> list = new ArrayList<String>();
		
		if (strs == null || strs.length == 0)
			return list;
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		for (int i = 0; i < strs.length; i++) {
			char[] chars = strs[i].toCharArray();
			Arrays.sort(chars);
			String key = new String(chars);
			if (map.containsKey(key)) {
				map.get(key).add(strs[i]);
			} else {
				List<String> li = new ArrayList<String>();
				li.add(strs[i]);
				map.put(key, li);
			}
		}
		
		for (String key : map.keySet()) {
			int size = map.get(key).size();
			if (size > 1)
				list.addAll(map.get(key));
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		Anagrams ana = new Anagrams();
		System.out.println(ana.anagrams(new String[] {"lint", "intl", "inlt", "code"}));
	}
	
}
