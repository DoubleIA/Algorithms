package com.doubleia.alg.string;

/**
 * 
 * For a given source string and a target string, you should output the first index(from 0) of target string in source string.
 * If target does not exist in source, just return -1.
 * 
 * If source = "source" and target = "target", return -1.
 * If source = "abcdabcdefg" and target = "bcd", return 1.
 * 
 * O(n2) is acceptable. Can you implement an O(n) algorithm? (hint: KMP)
 * 
 * Do I need to implement KMP Algorithm in a real interview?
 * 
 * Not necessary. When you meet this problem in a real interview, the interviewer may just want to test your basic implementation ability. 
 * But make sure your confirm with the interviewer first.
 * 
 * @author wangyingbo
 *
 */
public class StrStr {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
	public int strStr(String source, String target) {
		// write your code here
		return pattern(source, target);
	}
	
	/**
	 * 
	 * pattern[j] != pattern[f(j)]，next[j] = f(j)
	 * pattern[j] = pattern[f(j)]，next[j] = next[f(j)]
	 * 
	 * 该next其实为f(j)
	 * 
	 * @param target
	 * @return
	 */
	private int[] next(String target) {
		int[] next = new int[target.length()];
		char[] c = target.toCharArray();
		int len = target.length();
		next[0] = -1;

		int i = 0;
		for (int j = 1; j < len; j++) {
			i = next[j - 1];
			while (i >=0 && c[j] != c[i + 1]) 
				i = next[i];
			if (c[j] == c[i + 1]) 
				next[j] = i + 1;
			else
				next[j] = -1;
		}
		return next;
	}
	
	private int pattern(String source, String target) {
	   if (source == null || target == null)
	        return -1;
		if (target.equals(""))
			return 0;
		
		int[] next = next(target);
		
		char[] src = source.toCharArray();
		char[] tar = target.toCharArray();
		
		int j = 0;
		for (int i = 0; i < src.length; i++) {
			if (src[i] == tar[j]) {
				if (j == tar.length - 1) 
					return i - tar.length + 1;
				j++;
			} else if (j != 0) {
				j = next[j - 1] + 1;
				i--;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		String target = "aabaccfaddddaabc";
		String source = "gdsaadfdgffccsdaabaccfdaddaabaccfaddddaabcga";
		StrStr s = new StrStr();
		System.out.println(s.strStr(source, target));
	}
}
