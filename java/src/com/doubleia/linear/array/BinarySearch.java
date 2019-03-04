package com.doubleia.linear.array;

/**
 * 
 * For a given sorted array (ascending order) and a target number, 
 * find the first index of this number in O(log n) time complexity.
 * If the target number does not exist in the array, return -1.
 * 
 * If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
 * 
 * If the count of numbers is bigger than 2^32, can your code work properly?
 * 
 * @author wangyingbo
 *
 */
public class BinarySearch {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
    	int low = 0;
    	int high = nums.length - 1;
    	int location = -1;
    	while (low < high - 1) {
    		int mid = low + (high - low) / 2;
    		if (nums[mid] > target)
    			high = mid;
    		else if (nums[mid] < target)
    			low = mid;
    		else {
    			while (mid >= 0 && nums[mid] == target) {
    				location = mid--;
    			}
    			return location;
    		}
    	}
    	while (low >= 0 && nums[low] == target) {
    		location = low--;
    	}
    	if (location != -1 && nums[high] == target) {
    		location = high;
    	}
    	
    	return location;
    }
    
    public static void main(String[] args) {
		BinarySearch search = new BinarySearch();
		System.out.println(search.binarySearch(new int[] {1,4,4,5,7,7,8,9,9,10}, 1));
	}
}
