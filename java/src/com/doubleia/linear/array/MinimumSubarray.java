package com.doubleia.linear.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Given an array of integers, find the subarray with smallest sum.
 * Return the sum of the subarray.
 * 
 * For [1, -1, -2, 1], return -3
 * 
 * The subarray should contain at least one integer.
 * 
 * @author wangyingbo
 *
 */
public class MinimumSubarray {
	/**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
	public int minSubArray(ArrayList<Integer> nums) {
		// write your code
		if (nums.size() == 0)
			return Integer.MAX_VALUE;
		int min = nums.get(0);
		int sum = 0;
		for (Integer num : nums) {
			if (sum > 0)
				sum = 0;
			sum += num;
			min = Math.min(sum, min);
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		MinimumSubarray min = new MinimumSubarray();
		Integer[] ins = new Integer[]{-1, -2, 1, -3};
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.addAll(Arrays.asList(ins));
		System.out.println(min.minSubArray(nums));
	}
}
