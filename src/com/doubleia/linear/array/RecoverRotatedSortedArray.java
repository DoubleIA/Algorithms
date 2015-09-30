package com.doubleia.linear.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Given a rotated sorted array, recover it to sorted array in-place.
 * 
 * [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
 * 
 * In-place, O(1) extra space and O(n) time.
 * 
 * Clarification : What is rotated array?
 * 		
 * For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 * 
 * @author wangyingbo
 *
 */
public class RecoverRotatedSortedArray {
	/**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
    	if (nums.size() == 0)
    		return;
    	
    	for (int i = 1; i < nums.size(); i++) {
			if (nums.get(i) < nums.get(i - 1)) {
				reverse(nums, 0, i - 1);
				reverse(nums, i, nums.size() - 1);
				reverse(nums, 0, nums.size() - 1);
				return;
			}
		}
    }
    
    
    private void reverse(ArrayList<Integer> nums, int start, int end) {
    	for (int i = start, j = end; i < j; i++, j--) {
    		int temp = nums.get(i);
        	nums.set(i, nums.get(j));
        	nums.set(j, temp);
    	}
	}


	public static void main(String[] args) {
		RecoverRotatedSortedArray recover = new RecoverRotatedSortedArray();
		ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(new Integer[] {4, 5, 6, 7, 8, 1, 2, 3}));
		recover.recoverRotatedSortedArray(nums);
		System.out.println(nums);
	}
}
