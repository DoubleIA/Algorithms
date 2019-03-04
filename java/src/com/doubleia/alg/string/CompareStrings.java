package com.doubleia.alg.string;

import java.util.Arrays;

/**
 * 
 * Compare two strings A and B, determine whether A contains all of the characters in B.
 * The characters in string A and B are all Upper Case letters.
 * 
 * For A = "ABCD", B = "ACD", return true.
 * For A = "ABCD", B = "AABC", return false.
 * 
 * The characters of B in A are not necessary continuous or ordered. 
 * 
 * @author wangyingbo
 *
 */
public class CompareStrings {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
	public boolean compareStrings(String A, String B) {
		// write your code here
		if (A == null || (A.length() == 0 && B.length() != 0))
			return false;
		if (A != null && B.length() == 0)
			return true;
		
		char[] ca = A.toCharArray();
		char[] cb = B.toCharArray();
		Arrays.sort(ca);
		Arrays.sort(cb);
		
		int a = 0;
		int b = 0;
		while (a < A.length() && b < B.length()) {
			if (ca[a] == cb[b]) {
				a++;
				b++;
			} else {
				a++;
			}
		}
		
		if (b != B.length())
			return false;
		else
			return true;
	}
	
	public static void main(String[] args) {
		CompareStrings cmp = new CompareStrings();
		System.out.println(cmp.compareStrings("ABCD", "AACD"));
	}
}
