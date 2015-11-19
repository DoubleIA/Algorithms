package com.doubleia.alg.string;

/**
 * 
 * Given an integer, convert it to a roman numeral.
 * The number is guaranteed to be within the range from 1 to 3999.
 * 
 * 4 -> IV
 * 12 -> XII
 * 21 -> XXI
 * 99 -> XCIX
 * 
 * @author wangyingbo
 *
 */
public class IntegerToRoman {
    /**
     * @param n The integer
     * @return Roman representation
     */
	public String intToRoman(int n) {
		// Write your code here
		String[][] roman = {
				{ "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
				{ "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
				{ "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
				{ "", "M", "MM", "MMM" } };

		String ret = "";
		int digit = 0;
		while (n != 0) {
			int remain = n % 10;
			ret = roman[digit][remain] + ret;
			digit++;
			n /= 10;
		}

		return ret;
	}
	
	public static void main(String[] args) {
		IntegerToRoman itr = new IntegerToRoman();
		System.out.println(itr.intToRoman(3999));
	}
}
