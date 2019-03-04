package com.doubleia.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
	
	public void bucketSort(int[] nums) throws Exception {
		
		int bucket_size = 0;

		for (int i = 0; i < nums.length; i++) {
			int temp = Integer.parseInt(String.valueOf(nums[i]).charAt(0)+"");
			if (temp > bucket_size) 
				bucket_size = temp;
		}
		
		List<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>(bucket_size);
		
		for (int i = 0; i < bucket_size; i++) {
			buckets.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < nums.length; i++) {
			int k = nums[i] / 100 - 1;
			buckets.get(k).add(nums[i]);
		}
		
		for (ArrayList<Integer> alist : buckets) {
			Collections.sort(alist);
		}
		
		for (ArrayList<Integer> alist : buckets) {
			System.out.println(alist);
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		int[] nums = {171,339,291,438,614,513,435,221,112,234};
		BucketSort sort = new BucketSort();
		sort.bucketSort(nums);
	}
	
}
