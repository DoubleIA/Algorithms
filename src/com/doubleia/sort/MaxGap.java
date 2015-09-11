package com.doubleia.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Return 0 if the array contains less than 2 elements.
 * 
 * Given [1, 9, 2, 5], the sorted form of it is [1, 2, 5, 9], the maximum gap is between 5 and 9 = 4.
 * 
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * 
 * Sort is easy but will cost O(nlogn) time. Try to solve it in linear time and space.
 * 
 * @author wangyingbo
 *
 */
public class MaxGap {
	
    /**
     * @param nums: an array of integers
     * @return: the maximum difference
     */
    public int maximumGap(int[] nums) {
        // write your code here
    	int length = nums.length;
    	
    	if (length <= 1) {
    		return -1;
    	}
    	
    	int max = -1;
    	int min = Integer.MAX_VALUE;
    	
    	for (int i = 0; i < length; i++) {
    		if (nums[i] > max)
    			max = nums[i];
    		if (nums[i] < min)
    			min = nums[i];
		}
    	
    	int gap = (max - min - 1) / (length - 1);
    	if (gap == 0) {
    		return 1;
    	}
    	int bucket_size = length / gap;
    	
    	
    	List<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>(bucket_size);
    	
    	for (int i = 0; i < bucket_size; i++) {
			buckets.add(new ArrayList<Integer>());
		}
    	
    	for (int i = 0; i < nums.length; i++) {
			int k = (nums[i] - min - 1) / gap;
			buckets.get(k).add(nums[i]);
		}
    	
    	int result = 0;
    	
    	for (int i = 1; i < bucket_size; i++) {
			max = Collections.max(buckets.get(i - 1));
			min = Collections.min(buckets.get(i));
			if (min - max > result) {
				result = min - max;
			}
		}
    	
    	return result;
    }
    
   public static void main(String[] args) {
		int[] nums = {1,2,3,4,6};
		MaxGap gap = new MaxGap();
		int result = gap.maximumGap(nums);
		System.out.println(result);
	}

}
