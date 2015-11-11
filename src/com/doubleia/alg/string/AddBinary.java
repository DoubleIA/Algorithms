package com.doubleia.alg.string;

/**
 * 
 * Given two binary strings, return their sum (also a binary string).
 * 
 * a = 11
 * b = 1
 * Return 100
 * 
 * @author wangyingbo
 *
 */
public class AddBinary {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
	public String addBinary(String a, String b) {
		// Write your code here
		int alen = a.length() - 1;
		int blen = b.length() - 1;
		int carry = 0;
		
		String sum = "";
		
		while (alen >= 0 || blen >= 0 || carry > 0) {
			int c = carry;
			if (alen >= 0) c += a.charAt(alen) - '0';
			if (blen >= 0) c += b.charAt(blen) - '0';
			carry = c / 2;
			sum = ('0' + c&1) + sum;
			alen--;
			blen--;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		AddBinary add = new AddBinary();
		System.out.println(add.addBinary("111", "1"));
	}
}
