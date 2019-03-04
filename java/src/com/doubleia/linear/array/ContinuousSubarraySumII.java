package com.doubleia.linear.array;

import java.util.ArrayList;

/**
 * 
 * Given an integer array, find a continuous rotate subarray where the sum of numbers is the biggest. 
 * Your code should return the index of the first number and the index of the last number. 
 * (If their are duplicate answer, return anyone. The answer can be rorate array or non- rorate array)
 * 
 * Give [3, 1, -100, -3, 4], return [4,1].
 * 
 * @author wangyingbo
 *
 */
public class ContinuousSubarraySumII {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
	public ArrayList<Integer> continuousSubarraySumII(int[] A) {
		// Write your code here
		ArrayList<Integer> res = new ArrayList<Integer>(2);
		
		int length = A.length;
		if (length == 0)
			return res;
		
		int[] minIndices = new int[2];
		int[] maxIndices = new int[2];
		int minPreFix = 0;
		int maxPreFix = 0;
		int maxSum = 0;
		int minSum = 0;
		int max = A[0];
		int min = A[0];
		int sum = 0;
		
		for (int i = 0; i < length; i++) {
			sum += A[i];
			if (minSum > 0) {
				minSum = 0;
				minPreFix = i;
			} else if (maxSum < 0) {
				maxSum = 0;
				maxPreFix = i;
			}
			minSum += A[i];
			maxSum += A[i];
			if (maxSum > max) {
				max = maxSum;
				maxIndices[0] = maxPreFix;
				maxIndices[1] = i;
			}
			if (minSum < min) {
				min = minSum;
				minIndices[0] = minPreFix;
				minIndices[1] = i;
			}
			max = Math.max(max, maxSum);
			min = Math.min(min, minSum);
		}
//		System.out.println(max + " " + maxIndices[0] + " " + maxIndices[1] + " " + min + " " + minIndices[0] + " " + minIndices[1] + " " + sum);
		if (sum - min > max && sum != min) {
			res.add(minIndices[1] == length - 1 ? 0 : minIndices[1] + 1);
			res.add(minIndices[0] == 0 ? length - 1 : minIndices[0] - 1);
		} else {
			res.add(maxIndices[0]);
			res.add(maxIndices[1]);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		ContinuousSubarraySumII con = new ContinuousSubarraySumII();
		System.out.println(con.continuousSubarraySumII(new int[]{3, 1, -100, -3, -4}));
	}
}
