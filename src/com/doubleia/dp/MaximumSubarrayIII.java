package com.doubleia.dp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Given an array of integers and a number k, find k non-overlapping subarrays which have the largest sum.
 * The number in each subarray should be contiguous.
 * Return the largest sum.
 * 
 * Given [-1,4,-2,3,-2,3], k=2, return 8
 * 
 * The subarray should contain at least one number
 * 
 * @author wangyingbo
 *
 */
public class MaximumSubarrayIII {
	/**
	 * 
	 * d[i][j] means the maximum sum we can get by selecting j subarrays from the first i elements.
	 * d[i][j] = max{d[p][j-1]+max(p+1,i)} j-1 <= p <= i-1
	 * max(p+1,i) means the maximum subarray between p+1 and i
	 * 
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
	public int maxSubArray(ArrayList<Integer> nums, int k) {
        // write your code
		if (nums == null || nums.size()<k) 
			return Integer.MIN_VALUE;
	    int len = nums.size();
	    
	    int[][] d = new int[len + 1][k + 1];
	    
	    for (int i = 0; i < d.length; i++) {
			d[i][0] = 0;
		}
	    
	    for (int j = 1; j <= k ; j++) {
			for (int i = 1; i <= len; i++) {
				d[i][j] = Integer.MIN_VALUE;
				int endMax = 0;
				int max = nums.get(i - 1);
				for (int p = i - 1; p >= j - 1; p--) {
					endMax = Math.max(nums.get(p), nums.get(p) + endMax);
					max = Math.max(endMax, max);
					if (d[i][j] < d[p][j - 1] + max)
						d[i][j] = d[p][j - 1] + max;
				}
			}
		}
	    
	    return d[len][k];
    }
     
    public static void main(String[] args) {
    	MaximumSubarrayIII max = new MaximumSubarrayIII();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(Arrays.asList(new Integer[] {-1,-4,-2,-3,-2,-3}));
		System.out.println(max.maxSubArray(list, 2));
	}
    /**
     * 
     * Time Limited Exceeded
     * 
     public int maxSubArray(ArrayList<Integer> nums, int k) {
        // write your code
    	int length = nums.size();
    	if (nums == null || length == 0 || k <= 0 || k > length)
    		return Integer.MIN_VALUE;
    	Integer[] arrays = new Integer[length];
    	nums.toArray(arrays);
    	int max = arrays[0] + max(arrays, 1, k - 1);
    	int sum = arrays[0];
    	for (int i = 1; i < arrays.length - k; i++) {
			if (sum < 0)
				sum = 0;
			sum += arrays[i];
			max = Math.max(max, sum + max(arrays, i + 1, k - 1));
		}
    	return max(arrays, 0, k);
    }
    
    private int max(Integer[] nums, int start, int k) {
    	int length = nums.length;
    	
    	int max = Integer.MIN_VALUE;
    	if (k > 1) {
    		int sum = nums[start];
    		max = nums[start] + max(nums, start + 1, k - 1);
    		for (int i = start + 1; i < length - k; i++) {
				if (sum < 0)
					sum = 0;
				sum += nums[i];
				max = Math.max(max, sum + max(nums, i + 1, k - 1));
			}
    	} else {
    		int sum = nums[start];
    		max = nums[start];
    		for (int i = start + 1; i < length; i++) {
				if (sum < 0)
					sum = 0;
				sum += nums[i];
				max = Math.max(sum, max);
			}
    	}
    	
    	return max;
    }
     * 
     * 
     */
}
