package com.doubleia.lintcode.greedy;

/**
 * 
 * Given an array contains N numbers of 0 .. N, find which number doesn't exist in the array.
 * 
 * Given N = 3 and the array [0, 1, 3], return 2.
 * 
 * Do it in-place with O(1) extra memory and O(n) time.
 * 
 * @author wangyingbo
 *
 */
public class FindTheMissingNumber {
	/**
	 * @param nums : an array of integers
	 * @return: an integer
	 */
	public int findMissing(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0)
			return 0;
		int x1 = nums[0];
		int x2 = 1;
		
		for (int i = 1; i < nums.length; i++) {
			x1 ^= nums[i];
		}
		
		for (int i = 2; i <= nums.length; i++) {
			x2 ^= i;
		}
		
		return x1 ^ x2;
	}
	
	public static void main(String[] args) {
		FindTheMissingNumber find = new FindTheMissingNumber();
		System.out.println(find.findMissing(new int[]{0,1,3}));
	}
}
