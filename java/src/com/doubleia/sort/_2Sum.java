package com.doubleia.sort;

import java.util.Arrays;

/**
 * 
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * O(n) Space, O(nlogn) Time 
 * O(n) Space, O(n) Time
 * 
 * @author wangyingbo
 *
 */
public class _2Sum {

	/*
	 * @param numbers : An array of Integer
	 * @param target : target = numbers[index1] + numbers[index2]
	 * @return : [index1 + 1, index2 + 1] (index1 < index2)
	 */
	public int[] twoSum(int[] nums, int target) {
		// write your code here
		int[] numbers = Arrays.copyOf(nums, nums.length);
		Arrays.sort(numbers);

		int[] indices = { -1, -1 };
		int left = 0;
		int right = numbers.length - 1;
		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum == target) {
				indices[0] = numbers[left];
				indices[1] = numbers[right];
				break;
			} else if (sum < target)   {
				left++;
			} else {
				right--;
			}
 		}
		
		left = 0;
		right = nums.length;
		while (left < right) {
			if (indices[0] == nums[left]) {
				indices[0] = left + 1;
				break;
			}
			left++;
		}
		
		left = 0;
		right = nums.length;
		while (left < right) {
			if (indices[1] == nums[left]) {
				indices[1] = left + 1;
				break;
			}
			left++;
		}
		
		if (indices[0] > indices[1]) {
			int temp = indices[0];
			indices[0] = indices[1];
			indices[1] = temp;
		}

		return indices;
	}

	public static void main(String[] args) {
		_2Sum sum = new _2Sum();
		int[] nums = {1, 0, -1};
		int[] result = sum.twoSum(nums, -1);
		System.out.println("Index1: " + result[0]);
		System.out.println("Index2: " + result[1]);
	}

}
