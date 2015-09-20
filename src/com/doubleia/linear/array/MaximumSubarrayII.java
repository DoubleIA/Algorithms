package com.doubleia.linear.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Given an array of integers, find two non-overlapping subarrays which have the largest sum.
 * The number in each subarray should be contiguous.
 * Return the largest sum.
 * 
 * For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or [1, 3, -1, 2] and [2], 
 * they both have the largest sum 7.
 * 
 * The subarray should contain at least one number
 * 
 * Can you do it in time complexity O(n) ?
 * 
 * @author wangyingbo
 *
 */
public class MaximumSubarrayII {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
    	if (nums == null || nums.size() == 0)
    		return Integer.MIN_VALUE;
    	
    	int length = nums.size();
    	int[] rightMax = new int[length];
    	int max = Integer.MIN_VALUE;
    	
    	int sum = nums.get(length - 1);
    	rightMax[length - 1] = nums.get(length - 1);
    	for (int i = length - 2; i >= 0; i--) {
    		sum = Math.max(nums.get(i), sum + nums.get(i));
			rightMax[i] = Math.max(sum, rightMax[i + 1]);
		}
    	
    	sum = nums.get(0);
    	max = sum + rightMax[1];
    	for (int i = 1; i < length - 1; i++) {
			if (sum < 0)
				sum = 0;
			sum += nums.get(i);
			max = Math.max(max, sum + rightMax[i + 1]);
    	}
    	
    	
    	return max;
    }
    
    public static void main(String[] args) {
    	MaximumSubarrayII max = new MaximumSubarrayII();
		ArrayList<Integer> arrays = new ArrayList<Integer>();
		Integer[] array = new Integer[] {1, 3, -1, 2, -1, 2};
		arrays.addAll(Arrays.asList(array));
		System.out.println(max.maxTwoSubArrays(arrays));
	}
}
