package com.doubleia.linear.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array of integers and a number k, the majority number is the number that occurs more than 1/k of the size of the array. 
 * Find it.
 * 
 * Given [3,1,2,3,2,3,3,4,4,4] and k=3, return 3.
 * 
 * There is only one majority number in the array.
 * 
 * O(n) time and O(k) extra space
 * 
 * @author wangyingbo
 *
 */
public class MajorityNumberIII {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
	public int majorityNumber(ArrayList<Integer> nums, int k) {
		// write your code
		int size = nums.size();
		int n = size / k;
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		
		int sum = 1;
		for (int i = 0; i < size; i++) {
			sum = 1;
			if (mp.containsKey(nums.get(i)))
				sum = mp.get(nums.get(i)) + 1;
			mp.put(nums.get(i), sum);
			if (mp.get(nums.get(i)) > n)
				return nums.get(i);
		}
		
		return -1;
	}
}
