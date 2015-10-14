package com.doubleia.linear.array;

/**
 * 
 * Given n and k, return the k-th permutation sequence.
 * 
 * For n = 3, all permutations are listed as follows:
 * 	"123"
 * 	"132"
 *	"213"
 * 	"231"
 * 	"312"
 * 	"321"
 * If k = 4, the fourth permutation is "231"
 * 
 * n will be between 1 and 9 inclusive.
 * 
 * O(n*k) in time complexity is easy, can you do it in O(n^2) or less?
 * 
 * @author wangyingbo
 *
 */
public class PermutationSequence {
	/**
     * @param n: n
     * @param k: the kth permutation
     * @return: return the k-th permutation
     */
	public String getPermutation(int n, int k) {
		String result = "";
		
		int[] nums = new int[n];
		int pCount = 1;
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
			pCount *= i + 1;
		}
		
		k--;
		for (int i = 0; i < n; i++) {
			pCount = pCount / (n - i);
			int index = k / pCount;
			result += nums[index];
			for (int j = index; j < n - i - 1; j++)
				nums[j] = nums[j + 1];
			k = k % pCount;
		}
		
		return result;
	}
	

	public static void main(String[] args) {
		PermutationSequence per = new PermutationSequence();
		System.out.println(per.getPermutation(3, 4));
	}
	/**
	 * 
	 * O(n*k)
	 * 
	 * public String getPermutation(int n, int k) {
		String result = "";

		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}
		
		for (int i = 1; i < k; i++) {
			nextPermutation(nums);
		}
		
		for (int i = 0; i < n; i++) {
			result += nums[i];
		}
		
		return result;
	}
	
	public void nextPermutation(int[] nums) {
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
	 * 
	 */
}
