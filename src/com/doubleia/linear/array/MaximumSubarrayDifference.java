package com.doubleia.linear.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Given an array with integers.
 * Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.
 * Return the largest difference.
 * 
 * For [1, 2, -3, 1], return 6
 * 
 * The subarray should contain at least one number
 * 
 * O(n) time and O(n) space.
 * 
 * @author wangyingbo
 *
 */
public class MaximumSubarrayDifference {
	/**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two Subarrays
     */
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
        // write your code
    	if (nums == null || nums.size() == 0)
    		return 0;
    	int len = nums.size();
    	int rDiff = 0;
    	int lDiff = 0;
    	
    	int[] array = new int[nums.size()];
    	
    	array[len - 1] = nums.get(len - 1);
    	int min = nums.get(len - 1);
    	for (int i = len - 2; i >= 0; i--) {
    		min = Math.min(nums.get(i), min + nums.get(i));
			array[i] = Math.min(min, array[i + 1]);
		}
    	
    	int max = nums.get(0);
    	rDiff = Math.abs(max - array[1]);
    	for (int i = 1; i < len - 1; i++) {
    		if (max < 0)
    			max = 0;
			max += nums.get(i);
			rDiff = Math.max(rDiff, Math.abs(max - array[i + 1]));
		}
    	
    	array[len - 1] = nums.get(len - 1);
    	max = nums.get(len - 1);
    	for (int i = len - 2; i >= 0; i--) {
    		if (max < 0)
    			max = 0;
			max += nums.get(i);
			array[i] = Math.max(array[i + 1], max);
		}
    	
    	min = nums.get(0);
    	lDiff = Math.abs(array[1] - min);
    	for (int i = 1; i < len - 1; i++) {
    		min = Math.min(nums.get(i), nums.get(i) + min);
			lDiff = Math.max(lDiff, Math.abs(array[i + 1] - min));
		}
    	
    	System.out.println("lDiff : " + lDiff + ", rDiff : " + rDiff);
    	return Math.max(lDiff, rDiff);
    }
    
    /**
     * 
     * Input: -5,3,-4,0,0,0,-1,20,1,1,-1,-1,-1,-1,-1
     * Return : 29
     * 
     * @param args
     */
    public static void main(String[] args) {
		MaximumSubarrayDifference max = new MaximumSubarrayDifference();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.addAll(Arrays.asList(new Integer[] {1,1,1,1,1,1,1,1,1,-19,1,1,1,1,1,1,1,-2,1,1,1,1,1,1,1,1,-2,1,-15,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
		System.out.println(max.maxDiffSubArrays(nums));
	}
}
