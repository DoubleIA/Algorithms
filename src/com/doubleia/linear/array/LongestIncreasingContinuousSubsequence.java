package com.doubleia.linear.array;

/**
 * 
 * Give you an integer array (index from 0 to n-1, where n is the size of this array)，
 * find the longest increasing continuous subsequence in this array. 
 * (The definition of the longest increasing continuous subsequence here can be from right to left or from left to right)
 * 
 * For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.
 * For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
 * 
 * O(n) time and O(1) extra space.
 * 
 * @author wangyingbo
 *
 */
public class LongestIncreasingContinuousSubsequence {
	/**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
    	int len = A.length;
    	if (len == 0)
    		return 0;
    	
    	int i1 = 0;
    	int i2 = 0;
    	int mi1 = 1;
    	int mi2 = 1;
    	for (int i = 1; i < len; i++) {
			if (A[i] > A[i - 1]) {
				i2 = i;
				mi1 = Math.max(mi1, i - i1 + 1);
			} else if (A[i] < A[i - 1]) {
				i1 = i;
				mi2 = Math.max(mi2, i - i2 + 1);
			}
		}
    	
    	return Math.max(mi1, mi2);
    }
    
    public static void main(String[] args) {
		LongestIncreasingContinuousSubsequence lo = new LongestIncreasingContinuousSubsequence();
		System.out.println(lo.longestIncreasingContinuousSubsequence(new int[]{5, 4, 2, 1, 3}));
	}
}
