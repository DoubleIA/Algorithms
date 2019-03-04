package com.doubleia.sort;

/**
 * 
 * Given a string which contains only letters. Sort it by lower case first and upper case second.
 * 
 * For "abAcD", a reasonable answer is "acbAD"
 * 
 * It's not necessary to keep the original order of lower-case letters and upper case letters.
 * 
 * @author wangyingbo
 *
 */
public class SortLettersByCase {
	 /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
    	int left = 0;
    	int right = chars.length - 1;
    	while(left < right) {
    		if (Character.isLowerCase(chars[left])) {
    			left++;
    		} else if (Character.isUpperCase(chars[right])) {
    			right--;
    		} else {
    			exchange(chars, left, right);
    			left++;
    			right--;
    		}
    			
    	}
    }
    
    private void exchange(char[] chars, int i, int j) {
    	char temp = chars[i];
    	chars[i] = chars[j];
    	chars[j] = temp;
    }
    
    public static void main(String[] args) {
		char[] chars = {'a','b','A','c','D'};
		SortLettersByCase sort = new SortLettersByCase();
		sort.sortLetters(chars);
		for (int i = 0; i < chars.length; i++) {
			System.out.print(chars[i] + " ");
		}
	}
}
