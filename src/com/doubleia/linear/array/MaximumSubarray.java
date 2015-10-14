package com.doubleia.linear.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Given an array of integers, find a contiguous subarray which has the largest sum.
 * 
 * Given the array [-2,2,-3,4,-1,2,1,-5,3], the continuous subarray [4,−1,2,1] has the largest sum = 6.
 * 
 * The subarray should contain at least one number.
 * 
 * Can you do it in time complexity O(n)?
 * 
 * @author wangyingbo
 *
 */
public class MaximumSubarray {
	 /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(ArrayList<Integer> nums) {
        // write your code
    	if (nums == null || nums.size() == 0)
    		return Integer.MIN_VALUE;
    	
    	int sum = nums.get(0);
    	int max = nums.get(0);
    	
    	for (int i = 1; i < nums.size(); i++) {
    		if (sum < 0)
				sum = 0;
    		sum += nums.get(i);
			if (max < sum)
				max = sum;
		}
    
    	return max;
    }
    
    public static void main(String[] args) {
		MaximumSubarray max = new MaximumSubarray();
		ArrayList<Integer> arrays = new ArrayList<Integer>();
		Integer[] array = new Integer[] {-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-1000};
		arrays.addAll(Arrays.asList(array));
		System.out.println(max.maxSubArray(arrays));
	}
}
