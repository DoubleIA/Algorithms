package com.doubleia.alg.string;

/**
 * 
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n, generate the nth sequence.
 * 
 * Given n = 5, return "111221".
 * 
 * @author wangyingbo
 *
 */
public class CountAndSay {
    /**
     * @param n the nth
     * @return the nth sequence
     */
	public String countAndSay(int n) {
		// Write your code here
		if (n <= 0) return "";
		
		String say = "1";
		
		for (int i = 1; i < n; i++) {
			say = count(say);
		}
		
		return say;
	}

	private String count(String say) {
		String ss = "";
		int count = 0;
		char last = say.charAt(0);
		for (int i = 0; i < say.length(); i++) {
			if (say.charAt(i) == last) {
				count++;
			} else {
				ss += count;
				ss += last;
				count = 1;
				last = say.charAt(i);
			}
		}
		
		ss += count;
		ss += last;
		
		return ss;
	}
	
	public static void main(String[] args) {
		CountAndSay cas = new CountAndSay();
		System.out.println(cas.countAndSay(5));
	}
}
