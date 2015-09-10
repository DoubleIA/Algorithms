package com.doubleia.sort;

public class CountSort {

	public void countSort(int[] nums, int limit) throws Exception {
		
		if (nums == null || nums.length == 0 || limit <= 0)
			return;
		
		int[] countArray = new int[limit + 1];
		for (int i = 0; i < nums.length; i++) {
			int value = nums[i];
			if (value < 0 || value > limit) {
				throw new Exception("array value overflow range");
			}
			countArray[value] += 1;
		}
		
		for (int i = 1; i < countArray.length; i++) {
			countArray[i] += countArray[i - 1];
		}
		
		int[] temp = new int[nums.length];
		for (int i = nums.length - 1; i >= 0; i--) {
			int value = nums[i];
			int postion = countArray[value] - 1;
			temp[postion] = value;
			countArray[value] -= 1;
		}
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = temp[i];
		}
		
	}
	
}
