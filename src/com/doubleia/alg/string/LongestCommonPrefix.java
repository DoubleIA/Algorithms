package com.doubleia.alg.string;

/**
 * 
 * Given k strings, find the longest common prefix (LCP).
 * 
 * For strings "ABCD", "ABEF" and "ACEF", the LCP is "A"
 * For strings "ABCDEFG", "ABCEFG" and "ABCEFA", the LCP is "ABC"
 * 
 * @author wangyingbo
 *
 */
public class LongestCommonPrefix {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
	public String longestCommonPrefix(String[] strs) {
		// write your code here
		if (strs == null || strs.length == 0 || strs[0].equals(""))
			return "";
		String res = strs[0];
		int min = 0;
		
		for (int i = 1; i < strs.length; i++) {
			String s = strs[i];
			if (s.equals(""))
				return "";
			min = Math.min(res.length(), s.length());
			for (int j = 0; j < min; j++) {
				if (res.charAt(j) != s.charAt(j)) {
					if (j == 0)
						return "";
					else {
						res = res.substring(0, j);
						break;
					}
				}
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		LongestCommonPrefix lon = new LongestCommonPrefix();
		System.out.println(lon.longestCommonPrefix(new String[]{"ABCD", "ABEF", "ACEF"}));
	}
}
