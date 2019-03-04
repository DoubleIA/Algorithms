package com.doubleia.alg.string;

/**
 * 
 * Given a roman numeral, convert it to an integer.
 * The answer is guaranteed to be within the range from 1 to 3999.
 * 
 * IV -> 4
 * XII -> 12
 * XXI -> 21
 * XCIX -> 99
 * 
 * @author wangyingbo
 *
 */
public class RomanToInteger {
    /**
     * @param s Roman representation
     * @return an integer
     */
	public int romanToInt(String s) {
		// Write your code here
		int sum = 0;
		
		for (int i = 0; i < s.length(); i++) {
			int a = 0;
			int b = 0;
			a = getNum(s.charAt(i));
			if (i + 1 < s.length())
				b = getNum(s.charAt(i + 1));
			
			if (a < b) {
				sum += b - a;
				i++;
			} else {
				sum += a;
			}
		}
		
		return sum;
	}
	
	private int getNum(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}
	
	public static void main(String[] args) {
		RomanToInteger roman = new RomanToInteger();
		System.out.println(roman.romanToInt("CMXCIX"));
	}
}
