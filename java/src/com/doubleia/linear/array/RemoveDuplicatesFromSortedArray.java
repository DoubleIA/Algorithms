package com.doubleia.linear.array;

/**
 * 
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * 
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 * 
 * @author wangyingbo
 *
 */
public class RemoveDuplicatesFromSortedArray {
	/**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
    	if (nums.length == 0)
    		return 0;
    	
    	int j = 0;
    	for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[j]) {
				j++;
				exchange(nums, i, j);
			}
		}
    	
    	return j + 1;
    }
    
    private void exchange(int[] array, int i, int j) {
    	int temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }
    
    public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray remove = new RemoveDuplicatesFromSortedArray();
		int[] nums = new int[] {1,1,1,2,2,2,3,3,3,3,3,3,4,4,4,5,6,7};
		System.out.println(remove.removeDuplicates(nums));
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}
}
