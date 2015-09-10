package com.doubleia.sort;

import java.util.Arrays;

/**
 * 
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers.
 * 
 * @author wangyingbo
 *
 */
public class _3SumCloset {
	/**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
	public int threeSumClosest(int[] numbers ,int target) {
        // write your code here
		Arrays.sort(numbers);
		
		int sum = Integer.MIN_VALUE;
		int dis = Integer.MAX_VALUE;
		int tar;
		for (int i = 0; i < numbers.length - 2; i++) {
			if (i > 0 && numbers[i] == numbers[i - 1]) {
				continue;
			}
			tar = target - numbers[i];
			int sum2 = twoSum(numbers, i, tar);
			int temp = Math.abs(sum2 + numbers[i] - target);
			if (temp < dis) {
				sum = sum2 + numbers[i];
				dis = temp;
			}
		}
		
		return sum;
    }
	
	public int twoSum(int[] numbers, int start, int target) {
		// write your code here
		int sum2 = Integer.MIN_VALUE;
		int dis = Integer.MAX_VALUE;
		int left = start + 1;
		int right = numbers.length - 1;
		while (left < right) {
			int sum = numbers[left] + numbers[right];
			int temp = Math.abs(sum - target);
			if (temp < dis) {
				dis = temp;
				sum2 = sum;
			} else if (sum < target)   {
				left++;
			} else {
				right--;
			}
 		}

		return sum2;
	}
	
	public static void main(String[] args) {
		int[] nums = {-2,-3,-4,-5,-100,99,1,4,4,4,5,1,0,-1,2,3,4,5};
		
		_3SumCloset sum = new _3SumCloset();
		int result = sum.threeSumClosest(nums, 77);
		
		System.out.println(result);
	}
}
