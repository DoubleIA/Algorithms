package com.doubleia.alg.string;

/**
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.If the last word does not exist, return 0.
 * 
 * Given s = "Hello World", return 5.
 * 
 * A word is defined as a character sequence consists of non-space characters only.
 * 
 * @author wangyingbo
 *
 */
public class LengthOfLastWord {
    /**
     * @param s A string
     * @return the length of last word
     */
	public int lengthOfLastWord(String s) {
		// Write your code here
		if (s == null || s.length() == 0)
			return 0;
/*		int len = s.length();
		int res = 0;
		while (len > 0) {
			if (s.charAt(len - 1) == ' ') {
				if (res == 0) {
					len--;
					continue;
				}
				break;
			}
			res++;
			len--;
		}
		return res;*/
		String[] strs = s.split(" ");
		return strs[strs.length - 1].length();
	}
	
	public static void main(String[] args) {
		LengthOfLastWord len = new LengthOfLastWord();
		System.out.println(len.lengthOfLastWord("b a "));
	}
}
