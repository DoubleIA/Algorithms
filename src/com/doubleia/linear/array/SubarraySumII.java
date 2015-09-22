package com.doubleia.linear.array;

import java.util.Arrays;

/**
 * 
 * Given an integer array, find a subarray where the sum of numbers is between two given interval.
 * Your code should return the number of possible answer.
 * 
 * Given [1,2,3,4] and interval = [1,3], return 4. The possible answers are:
 * 
 * [0, 0]
 * [0, 1]
 * [1, 1]
 * [2, 2]
 * 
 * @author wangyingbo
 *
 */
public class SubarraySumII {
	/**
     * @param A an integer array
     * @param start an integer
     * @param end an integer
     * @return the number of possible answer
     */
    public int subarraySumII(int[] A, int start, int end) {
        // Write your code here
    	int len = A.length;
    	
    	if (A == null || len == 0)
    		return 0;
    	
    	int[] sums = new int[len + 1];
    	
    	sums[0] = 0;
    	for (int i = 1; i < sums.length; i++) {
			sums[i] = sums[i - 1] + A[i - 1];
		}
    	
    	Arrays.sort(sums);
    	
    	int count = 0;
    	
    	for (int i = 0; i < len; i++) {
    		int temp = sums[i + 1] - sums[i];
    		int j = i + 2;
    		while (temp >= start && temp <= end) {
    			count++;
    			if (j > len || temp > end)
    				break;
    			temp = sums[j++] - sums[i];
    		}
		}
    	
    	return count;
    }
    
    public static void main(String[] args) {
		SubarraySumII sub = new SubarraySumII();
		System.out.println(sub.subarraySumII(new int[] {1,3,4,5,6,7,1,2,3,4,5}, 1, 19));
	}
}
