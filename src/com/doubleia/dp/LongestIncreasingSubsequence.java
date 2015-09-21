package com.doubleia.dp;

/**
 * 
 * Given a sequence of integers, find the longest increasing subsequence (LIS).
 * You code should return the length of the LIS.
 * 
 * For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3
 * For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4
 * 
 * Time complexity O(n^2) or O(nlogn)
 * 
 * What's the definition of longest increasing subsequence?
 * 
 *  The longest increasing subsequence problem is to find a subsequence of a given sequence
 *  in which the subsequence's elements are in sorted order, lowest to highest, 
 *  and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.  
 * 
 * @author wangyingbo
 *
 */
public class LongestIncreasingSubsequence {
	/**
	 * 
	 * end[0] means the length of longest increasing subsequence
	 * end[i] means the minimum end of LIS which length is i
	 * 
	 * @param nums: The integer array
	 * @return: The length of LIS (longest increasing subsequence)
	 */
	public int longestIncreasingSubsequence(int[] nums) {
	    // write your code here
		int len = nums.length;
		if (nums == null || len == 0)
		    return 0;
		int[] end = new int[len + 1];
		
		end[1] = nums[0];
		end[0] = 1;
		for (int i = 1; i < len; i++) {
			int pos = upper_bound(end, 1, end[0], nums[i]);
			end[pos] = nums[i];
			if (end[0] < pos)
				end[0] = pos;
		}
		
		return end[0];
	}
	
	private int upper_bound(int[] arrays, int s, int e, int key) {
		int mid = s;
		if (arrays[e] <= key)
			return e + 1;
		
		while (s < e) {
			mid = s + (e - s) / 2;
			if (arrays[mid] > key)
				e = mid;
			else 
				s = mid + 1;
		}
		
		return s;
	}
	
	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		System.out.println(lis.longestIncreasingSubsequence(new int[] {4, 2, 4, 5, 3, 7}));
	}
	
	/**
	 * 
	 * d[i] means the longest increasing continuous subsequence length between 0 and i
	 * d[i] = Math.max(d[j] + 1, 1) where j < i and A[j] < A[i]
	 * 
	 * Time complexity O(n^2)
	 * 
	 * 		int len = nums.length;
		int[] d = new int[len];
		
		int max = 0;
		for (int i = 0; i < len; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) 
				if (nums[i] >= nums[j] && d[j] + 1 > d[i])
					d[i] = Math.max(d[j] + 1, d[i]);
			max = Math.max(d[i], max);
		}
		
		return max;
	 */
}
