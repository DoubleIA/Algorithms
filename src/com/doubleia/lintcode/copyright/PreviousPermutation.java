package com.doubleia.lintcode.copyright;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Given a list of integers, which denote a permutation.
 * Find the previous permutation in ascending order.
 * 
 * For [1,3,2,3], the previous permutation is [1,2,3,3]
 * For [1,2,3,4], the previous permutation is [4,3,2,1]
 * 
 * The list may contains duplicate integers.
 * 
 * @author wangyingbo
 *
 */
public class PreviousPermutation {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
	public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		// write your code

		
		return nums;
	}

	public static void main(String[] args) {
		PreviousPermutation pre = new PreviousPermutation();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.addAll(Arrays.asList(new Integer[]{1,3,2,4}));
		System.out.println(pre.previousPermuation(nums));
	}
}
