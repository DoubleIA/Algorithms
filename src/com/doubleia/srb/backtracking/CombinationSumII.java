package com.doubleia.srb.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * 
 * For example, given candidate set 10,1,6,7,2,1,5 and target 8,
 * A solution set is: 
 * [1,7]
 * [1,2,5]
 * [2,6]
 * [1,1,6]
 * 
 * Note
 * 
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * 
 * @author wangyingbo
 *
 */
public class CombinationSumII {
	List<List<Integer>> com = new ArrayList<List<Integer>>();
	
	/**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
    	if (num.length == 0)
    		return com;
    	
    	Arrays.sort(num);
    	List<Integer> list = new ArrayList<Integer>();
    	backTracking(list, num, 0, target);

    	return com;
    }

	private void backTracking(List<Integer> list, int[] num, int index, int target) {
		if (target == 0) {
			if (!com.contains(list))
				com.add(list);
			return;
		}
		for (int i = index; i < num.length; i++) {
			int tar = target - num[i];
			if (tar >= 0) {
				List<Integer> copy = new ArrayList<Integer>(list);
				copy.add(num[i]);
				backTracking(copy, num, i + 1, tar);
			} else {
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		CombinationSumII com = new CombinationSumII();
		System.out.println(com.combinationSum2(new int[] {2,3,6,7}, 13));
	}
	
}
