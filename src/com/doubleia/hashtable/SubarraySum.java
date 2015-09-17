package com.doubleia.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * Given an integer array, find a subarray where the sum of numbers is zero. 
 * Your code should return the index of the first number and the index of the last number.
 * 
 * Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
 * 
 * @author wangyingbo
 *
 */
public class SubarraySum {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
	public ArrayList<Integer> subarraySum(int[] nums) {
		// write your code here
		ArrayList<Integer> subarray = new ArrayList<Integer>(2);
		if (nums == null || nums.length == 0)
			return subarray;
		
		Element[] elements = new Element[nums.length + 1];
		elements[0] = new Element(0, -1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			elements[i + 1] = new Element(sum, i);
		}
		
		Arrays.sort(elements, new Comparator<Element>() {

			@Override
			public int compare(Element ele0, Element ele1) {
				return ele0.val - ele1.val;
			}
			
		});
		
		for (int i = 1; i < elements.length; i++) {
			if (elements[i].val - elements[i - 1].val == 0) {
				if (elements[i].index < elements[i - 1].index) {
					subarray.add(elements[i].index + 1);
					subarray.add(elements[i - 1].index);
				} else {
					subarray.add(elements[i - 1].index + 1);
					subarray.add(elements[i].index);
				}
				return subarray;
			}
		}
		
		return subarray;
	}

	private class Element {
		private int val;
		private int index;

		Element(int val, int index) {
			this.val = val;
			this.index = index;
		}
	}

	public static void main(String[] args) {
		SubarraySum sum = new SubarraySum();
		ArrayList<Integer> res = sum.subarraySum(new int[] {-3, 1, 2, -1, 4});
		System.out.println(res);
	}
}
