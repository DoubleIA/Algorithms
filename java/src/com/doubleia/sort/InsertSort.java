package com.doubleia.sort;

public class InsertSort {
	public void insertSort(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		
		for (int i = 1; i < nums.length; i++) {
			int temp = nums[i];
			int j = i;
			while (j > 0 && temp < nums[j - 1]) {
				nums[j] = nums[j - 1];
				j--;
			}
			nums[j] = temp;
		}
		
	}
	
	private static void printArray(int[] arrays) {
		for (int i = 0; i < arrays.length; i++) {
			System.out.print(arrays[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {5,4,-3,6,2,8,-6,-4,0};
		InsertSort sort = new InsertSort();
		sort.insertSort(nums);
		printArray(nums);
	}
}
