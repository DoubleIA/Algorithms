package com.doubleia.lintcode.copyright;

/**
 * 
 * Given a list of integers, which denote a permutation.
 * Find the next permutation in ascending order.
 * 
 * For [1,3,2,3], the next permutation is [1,3,3,2]
 * For [4,3,2,1], the next permutation is [1,2,3,4]
 * 
 * The list may contains duplicate integers.
 * 
 * @author wangyingbo
 *
 */
public class NextPermutation {
	/**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
	public int[] nextPermutation(int[] nums) {
		// write your code here
		int length = nums.length;
		if (length < 2)
			return nums;
		
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
		
		return nums;
	}

	public static void main(String[] args) {
		NextPermutation next = new NextPermutation();
		int[] nums = next.nextPermutation(new int[]{1,4,3,2});
		System.out.print("[");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			if (i != nums.length - 1)
				System.out.print(", ");
		}
		System.out.println("]");
	}
}
