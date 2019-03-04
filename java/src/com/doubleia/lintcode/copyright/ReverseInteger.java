package com.doubleia.lintcode.copyright;

/**
 * 
 * Reverse digits of an integer. Returns 0 when the reversed integer overflows (signed 32-bit integer).
 * 
 * Given x = 123, return 321
 * Given x = -123, return -321
 * 
 * @author wangyingbo
 *
 */
public class ReverseInteger {
	/**
	 * @param n the integer to be reversed
	 * @return the reversed integer
	 */
	public int reverseInteger(int n) {
		// Write your code here
		boolean isPositive = true;
		if (n < 0) {
			n = -n;
			isPositive = false;
		}
		
		long result = 0;
		while (n > 0) {
			result = result * 10 + n % 10;
			n = n / 10;
		}

		if (!isPositive)
			result = -result;
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			return 0;
		return (int)result;
		
	}
	
	public static void main(String[] args) {
		ReverseInteger rev = new ReverseInteger();
		System.out.println(rev.reverseInteger(4236469));
	}
}
