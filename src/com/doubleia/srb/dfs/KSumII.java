package com.doubleia.srb.dfs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Given n unique integers, number k (1<=k<=n) and target. 
 * Find all possible k integers where their sum is target.
 * 
 * Given [1,2,3,4], k = 2, target = 5. Return:
 * 
 * [
 *  [1,4],
 *  [2,3]
 * ]
 * 
 * @author wangyingbo
 *
 */
public class KSumII {
	/**
	 * @param A : an integer array.
	 * @param k : a positive integer (k <= length(A))
	 * @param target : a integer
	 * @return a list of lists of integer
	 */
	public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
		// write your code here
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (A == null || A.length == 0)
			return results;
		
		Arrays.sort(A);
		dfs(A, 0, k, target, res, results);
		
		return results;
	}

	private void dfs(int[] A, int start, int k, int target, ArrayList<Integer> res,
			ArrayList<ArrayList<Integer>> results) {
		if (res.size() == k && 0 == target) {
			if (!results.contains(res))
				results.add(new ArrayList<Integer>(res));
			return;
		}
		if (start >= A.length || A[start] > target)
			return;
		for (int i = start; i < A.length; i++) {
			res.add(A[i]);
			dfs(A, i + 1, k, target - A[i], res, results);
			res.remove(res.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		KSumII ksum = new KSumII();
		System.out.println(ksum.kSumII(new int[]{1,1,2,3,4}, 2, 5));
	}
}
