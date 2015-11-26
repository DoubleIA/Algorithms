package com.doubleia.dp;

/**
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
 * 
 * @author wangyingbo
 *
 */
public class MaximumProductSubarray {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
	public int maxProduct(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		
		int currMax = nums[0];
		int currMin = nums[0];
		
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < nums.length; i++) {
			int tmp = currMin * nums[i];
			currMin = Math.min(nums[i], Math.min(tmp, currMax * nums[i]));
			currMax = Math.max(nums[i], Math.max(tmp, currMax * nums[i]));
			max = Math.max(max, currMax);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		MaximumProductSubarray max = new MaximumProductSubarray();
		System.out.println(max.maxProduct(new int[]{2,3,-2,4}));
	}
}
