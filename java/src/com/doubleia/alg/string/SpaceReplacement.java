package com.doubleia.alg.string;

/**
 * 
 * Write a method to replace all spaces in a string with %20. The string is given in a characters array, 
 * you can assume it has enough space for replacement and you are given the true length of the string.
 * 
 * Given "Mr John Smith", length = 13.
 * The string after replacement should be "Mr%20John%20Smith".
 * 
 * If you are using Java or Python，please use characters array instead of string.
 * 
 * Do it in-place.
 * 
 * @author wangyingbo
 *
 */
public class SpaceReplacement {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
	public int replaceBlank(char[] string, int length) {
		// Write your code here
		if (string == null || length == 0)
			return 0;

		int len = length;
		for (int i = 0; i < length; i++) {
			if (string[i] == ' ')
				len += 2;
		}
		
		int res = len;
		len--;
		for (int i = length - 1; i >= 0; i--) {
			if (string[i] == ' ') {
				string[len--] = '0';
				string[len--] = '2';
				string[len--] = '%';
			} else {
				string[len--] = string[i];
			}
				
		}
		return res;
	}
	
	public static void main(String[] args) {
		SpaceReplacement spa = new SpaceReplacement();
		char[] string = new char[17];
		String input = "Mr John Smith";
		for (int i = 0; i < input.length(); i++) {
			string[i] = input.charAt(i);
		}
		System.out.println(spa.replaceBlank(string, 13));
	}
}
