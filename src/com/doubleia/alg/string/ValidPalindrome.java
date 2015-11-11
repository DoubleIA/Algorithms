package com.doubleia.alg.string;

/**
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * O(n) time without extra memory.
 * 
 * @author wangyingbo
 *
 */
public class ValidPalindrome {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
	public boolean isPalindrome(String s) {
		// Write your code here
		if (s.length() == 0)
			return true;
		int left = 0;
		int right = s.length() - 1;
		
		while (left < right) {
			while (!isAlphanum(s.charAt(left))) {
				left++;
				if (left >= right)
					break;
			}
			while (!isAlphanum(s.charAt(right))) {
				right--;
				if (left >= right)
					break;
			}
//			System.out.println("left" + left + ": " + s.charAt(left) + " right" + right + ": " + s.charAt(right));
			if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)) && left < right)
				return false;
			left++;
			right--;
		}
		
		return true;
	}
	
	private boolean isAlphanum(char c) {
		return Character.isAlphabetic(c) || Character.isDigit(c);
	}
	
	public static void main(String[] args) {
		ValidPalindrome valid = new ValidPalindrome();
		String s = ".,";
		System.out.println(valid.isPalindrome(s));
	}
}
