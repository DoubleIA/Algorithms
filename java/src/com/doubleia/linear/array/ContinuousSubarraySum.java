package com.doubleia.linear.array;

import java.util.ArrayList;

/**
 * 
 * Given an integer array, find a continuous subarray where the sum of numbers is the 
 * biggest. Your code should return the index of the first number and the index of the last 
 * number. (If their are duplicate answer, return anyone)
 * 
 * Give [-3, 1, 3, -3, 4], return [1,4].
 * 
 * @author wangyingbo
 *
 */
public class ContinuousSubarraySum {
	/**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
    	ArrayList<Integer> list = new ArrayList<Integer>(2);
    	
    	if (A.length == 0)
    		return list;
    	
    	list.add(0);
    	list.add(0);
    	int sum = A[0];
    	int max = Integer.MIN_VALUE;
    	int start = 0;
    	int m = A[0];
    	int index = 0;
    	for (int i = 1; i < A.length; i++) {
    		if (max >= 0 && A[i] < 0 && m < A[i]) {
    			m = A[i];
    			index = i;
    		}
			if (sum < 0) {
				sum = 0;
				start = i;
			}
			sum += A[i];
			if (sum > max) {
				list.remove(0);
				list.remove(0);
				list.add(start);
				list.add(i);
				max = sum;
			} 
		}
    	if (max < m) {
    		list.remove(0);
			list.remove(0);
			list.add(index);
			list.add(index);
    	}
    	return list;
    }
    
    public static void main(String[] args) {
		ContinuousSubarraySum con = new ContinuousSubarraySum();
		System.out.println(con.continuousSubarraySum(new int[]{-101,-33,-44,-55,-67,-78,-101,-33,-44,-55,-67,-78,-100,-200,-1000,-22,-100,-200,-1000,-22}));
	}
}
