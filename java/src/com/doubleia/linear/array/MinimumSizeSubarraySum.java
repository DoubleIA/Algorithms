package com.doubleia.linear.array;

/**
 * 
 * Given an array of n positive integers and a positive integer s, find the minimal length of 
 * a subarray of which the sum ≥ s. If there isn't one, return -1 instead.
 * 
 * Given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.
 * 
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 * 
 * @author wangyingbo
 *
 */
public class MinimumSizeSubarraySum {
	/**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
	public int minimumSize(int[] nums, int s) {
		// write your code here
		int len = nums.length;
		if (len == 0)
			return -1;
		
		int pre = 0;
		int post = -1;
		int sum = nums[0];
		int min = Integer.MAX_VALUE;
		
		while (pre < len && post < pre) {
			if (sum >= s) {
				post++;
				min = Math.min(pre - post + 1, min);
				sum = sum - nums[post];
			} else {
				if (pre == len - 1)
					break;
				pre++;
				sum += nums[pre];
			}
		}
		
		if (min == Integer.MAX_VALUE)
			return -1;
		
		return min;
	}
	
	public static void main(String[] args) {
		MinimumSizeSubarraySum min = new MinimumSizeSubarraySum();
		System.out.println(min.minimumSize(new int[]{2,3,1,2,4,3}, 7));
	}
}
