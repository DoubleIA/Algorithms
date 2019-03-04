package com.doubleia.dp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than a given number target.
 * If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|
 * 
 * Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal. 
 * 
 * You can assume each number in the array is a positive integer and not greater than 100.
 * 
 * @author wangyingbo
 *
 */
public class MinimumAdjustmentCost {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
	public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
		// write your code here
		if (A == null || A.size() == 0)
			return 0;
		
		// dp[i][j] 前i个数，第i个数调整为j，满足相邻两数<=target，所需要的最小代价
		// dp[i][j] = min(dp[i - 1][k] + |A.get(i) - (j + 1)|, dp[i][j]) for each k in interval between (j - target)/0 and (j + target)/99
		int[][] dp =  new int[A.size()][100];
		for (int i = 0; i < 100; i++)
			dp[0][i] = Math.abs(A.get(0) - (i + 1));
		
		for (int i = 1; i < A.size(); i++) {
			for (int j = 0; j < 100; j++) {
				int diff = Math.abs(A.get(i) - (j + 1));
				int upper = Math.min(j + target, 99);
				int lower = Math.max(j - target, 0);
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = lower; k <= upper; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + diff);
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 100; i++)
			min = Math.min(min, dp[A.size() - 1][i]);
		
		return min;
	}
	
	public static void main(String[] args) {
		MinimumAdjustmentCost min = new MinimumAdjustmentCost();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.addAll(Arrays.asList(new Integer[]{1,4,2,3}));
		System.out.println(min.MinAdjustmentCost(arr, 1));
	}
}
