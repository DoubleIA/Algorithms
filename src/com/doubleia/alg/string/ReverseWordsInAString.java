package com.doubleia.alg.string;

/**
 * 
 * Given an input string, reverse the string word by word.
 * 
 * For example,
 *  Given s = "the sky is blue",
 *  return "blue is sky the".
 * 
 * @author wangyingbo
 *
 */
public class ReverseWordsInAString {
    /**
     * @param s : A string
     * @return : A string
     */
	public String reverseWords(String s) {
		// write your code
		if (s == null)
			return null;
		if (s.isEmpty() || s.length() == 1)
			return s;
		
		String[] cs = s.split(" ");
		int len = cs.length;
		for (int i = 0; i < cs.length / 2; i++) {
			String c = cs[i];
			cs[i] = cs[len - i - 1];
			cs[len - i - 1] = c;
		}
		s = "";
		for (int i = 0; i < cs.length; i++) {
			s += cs[i];
			if (i != cs.length - 1)
				s += " ";
		}
		return s;
	}
	
	public static void main(String[] args) {
		ReverseWordsInAString rev = new ReverseWordsInAString();
		System.out.println(rev.reverseWords("the sky is blue"));
	}
}
