package com.doubleia.srb.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a set of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7]
 * [2, 2, 3]
 * 
 * Note : 
 * 
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * 
 * @author wangyingbo
 *
 */
public class CombinationSum {
	List<List<Integer>> com = new ArrayList<List<Integer>>();
	
	/**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
    	if (candidates.length == 0)
    		return com;
    	
    	Arrays.sort(candidates);
    	List<Integer> li = new ArrayList<Integer>();
    	backTracking(li, candidates, 0, target);
    	
    	return com;
    }

	private void backTracking(List<Integer> list, int[] candidates, int index, int target) {
		if (target == 0) {
			com.add(list);
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			int tar = target - candidates[i];
			if (tar >= 0) {
				List<Integer> copy = new ArrayList<Integer>(list);
				copy.add(candidates[i]);
				backTracking(copy, candidates, i, tar);
			} else {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		CombinationSum com = new CombinationSum();
		System.out.println(com.combinationSum(new int[] {8,7,4,3}, 11));
	}
	
}
