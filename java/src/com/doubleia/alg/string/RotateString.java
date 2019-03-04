package com.doubleia.alg.string;

/**
 * 
 * Given a string and an offset, rotate string by offset. (rotate from left to right)
 * 
 * Given "abcdefg".
 * 
 * offset=0 => "abcdefg"
 * offset=1 => "gabcdef"
 * offset=2 => "fgabcde"
 * offset=3 => "efgabcd"
 * 
 * Rotate in-place with O(1) extra memory.
 * 
 * @author wangyingbo
 *
 */
public class RotateString {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
	public void rotateString(char[] str, int offset) {
		// write your code here
		if (str.length == 0)
			return;
		
		int len = str.length;
		offset = offset % str.length;
		
		for (int i = 0; i < str.length / 2; i++) {
			char c = str[i];
			str[i] = str[len - 1 - i];
			str[len - 1 - i] = c;
		}
		for (int i = 0; i < offset / 2; i++) {
			char c = str[i];
			str[i] = str[offset - 1 - i];
			str[offset - 1 - i] = c;
		}
		for (int i = 0; i <  (len - offset + 1) / 2; i++) {
			char c = str[offset + i];
			str[offset + i] = str[len - 1 - i];
			str[len - 1 - i] = c;
		}
	}
	
	public static void main(String[] args) {
		RotateString ro = new RotateString();
		ro.rotateString("abcdefg".toCharArray(), 2);
	}
}
