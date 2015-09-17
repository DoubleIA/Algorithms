package com.doubleia.hashtable;

/**
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * For example, the longest substring without repeating letters for 
 * "abcabcbb" is "abc", which the length is 3.
 * 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * O(n) time
 * 
 * @author wangyingbo
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	 /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
    	if (s == null)
    		return 0;
    	
    	int[] last = new int[128];
    	
    	for (int i = 0; i < last.length; i++) {
			last[i] = -1;
		}
    	
    	char[] chars = s.toCharArray();
    	int len = 0;
    	int start = 0;
    	for (int i = 0; i < chars.length; i++) {
			if (last[chars[i] - ' '] >= start) {
				if (i - start > len)
					len = i - start;
				start = last[chars[i] - ' '] + 1;
			}
			last[chars[i] - ' '] = i;
		}
    	
    	if (s.length() - start > len)
    		return s.length() - start;
    	
    	return len;
    }
    
    public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaa";
		LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(ls.lengthOfLongestSubstring(s));
	}
    
    /**
     * 
     * int pre = 0;
    	char[] chars = s.toCharArray();
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	
    	for (int i = 0; i < chars.length; i++) {
			if (!map.containsKey(chars[i]))
				map.put(chars[i], i);
			else {
				pre = Math.max(pre, map.size());
				i = map.get(chars[i]);
				map.clear();
			}
		}
    	
    	return Math.max(pre, map.size());
     * 
     */
    
}
