package com.doubleia.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * Given [1, 20, 23, 4, 8], the largest formed number is 8423201.
 * 
 * @author wangyingbo
 *
 */
public class LargestNumber {
	/**
	 * @param num : A list of non negative integers
	 * @return: A string
	 */
	public String largestNumber(int[] num) {
		// write your code here
		StringBuilder builder = new StringBuilder("");
		String[] nums = new String[num.length];
		for (int i = 0; i < num.length; i++) {
			nums[i] = String.valueOf(num[i]);
		}
		
		Arrays.sort(nums, new Comparator<String>() {

			@Override
			public int compare(String str1, String str2) {
				
				String s1 = str2 + str1;
				String s2 = str1 + str2;
				for (int i = 0; i < s1.length(); i++) {
					if (s1.charAt(i) != s2.charAt(i))
						return (int)s1.charAt(i) - (int)s2.charAt(i);
				}
				
				return 0;
			}
			
		});
		
		for (int i = 0; i < nums.length; i++) {
			builder.append(nums[i]);
		}
		
		String result = builder.toString();
		
		if (result.charAt(0) == '0')
			return "0";
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int[] nums = {2147483647,2147483647,2147483646,9,1,8};
		
		LargestNumber ln = new LargestNumber();
		String result = ln.largestNumber(nums);
		System.out.println(result);
		
	}
}
