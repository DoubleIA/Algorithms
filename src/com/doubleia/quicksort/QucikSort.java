package com.doubleia.quicksort;

public class QucikSort {
	
	private int[] quicksort(int[] nums, int left, int right) {
		
		if (left < right) {
			int mid = partition(nums, left, right);
			quicksort(nums, left, mid - 1);
			quicksort(nums, mid + 1, right);
		}
		
/*		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
		System.out.println();*/

		return nums;
		
	}

	private int partition(int[] nums, int left, int right) {
		if (nums == null) {
			try {
				throw new Exception("argument null exception");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		int x = nums[right];
		int p = left - 1;
		
		for (int i = left; i < right; i++) {
			if (nums[i] <= x) {
				p++;
				exchange(nums, p, i);
			}
		}
		exchange(nums, p + 1, right);
		
		return p + 1;
	}
	
	private void exchange(int[] nums, int i, int j) {
		int temp;
		temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = {5, -4, 5, -4, 5, -4, 5, -4, 5, -4, -100, 1, 2, 3, 0, 0};
		QucikSort sort = new QucikSort();
		nums = sort.quicksort(nums, 0, nums.length - 1);
		for (int j = 0; j < nums.length; j++) {
			System.out.print(nums[j]);
		}
	}
}
