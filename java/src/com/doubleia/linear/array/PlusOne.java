package com.doubleia.linear.array;

/**
 * 
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * Given [1,2,3] which represents 123, return [1,2,4].
 * Given [9,9,9] which represents 999, return [1,0,0,0].
 * 
 * @author wangyingbo
 *
 */
public class PlusOne {
	/**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        // Write your code here
    	for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;
				if (i == 0) {
					int[] res = new int[digits.length + 1];
					res[0] = 1;
					for (int j = 1; j < res.length; j++) {
						res[j] = digits[j - 1];
					}
					return res;
				}
			} else {
				digits[i] += 1;
				return digits;
			}
		}
    	
    	return digits;
    }
    
    public static void main(String[] args) {
		PlusOne plus = new PlusOne();
		int[] digits = new int[] {9,9,9};
		int[] res = plus.plusOne(digits);
		System.out.print("[");
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]);
			if (i < res.length - 1)
				System.out.print(",");
		}
		System.out.println("]");
	}
}
