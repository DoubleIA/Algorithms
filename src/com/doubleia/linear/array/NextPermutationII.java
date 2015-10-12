package com.doubleia.linear.array;

/**
 * 
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * @author wangyingbo
 *
 */
public class NextPermutationII {
	/**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
	public void nextPermutation(int[] nums) {
		// write your code here
		int length = nums.length;
		if (length < 2)
			return;

		int begin = 0;

		for (int i = length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				begin = i;
				break;
			}
		}

		for (int i = length - 1; i >= begin; i--) {
			if (begin == 0)
				break;
			int temp = nums[begin - 1];
			if (nums[i] > temp) {
				nums[begin - 1] = nums[i];
				nums[i] = temp;
				break;
			}
		}

		int end = length - 1;

		while (begin < end) {
			int temp = nums[begin];
			nums[begin] = nums[end];
			nums[end] = temp;
			begin++;
			end--;
		}
	}
}
