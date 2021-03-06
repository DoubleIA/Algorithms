package com.doubleia.sort;

/**
 * 
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 
 * to represent the color red, white, and blue respectively.
 * 
 * Given [1, 0, 1, 2], return [0, 1, 1, 2].
 * 
 * You are not suppose to use the library's sort function for this problem.
 * 
 * A rather straight forward solution is a two-pass algorithm using counting sort. 
 * First, iterate the array counting number of 0's, 1's, and 2's, 
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 * @author wangyingbo
 *
 */
public class SortColors {
	/**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
    	int i = -1;
    	int j = -1;
    	for (int k = 0; k < nums.length; k++) {
			int p = nums[k];
			nums[k] = 2;
			if (p == 0) {
				nums[++j] = 1;
				nums[++i] = 0;
			} else if (p == 1) {
				nums[++j] = 1;
			}
		}
    }
    
    private static void printColors(int[] nums) {
    	System.out.print("[");
    	for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			if (i < nums.length - 1)
				System.out.print(",");
		}
    	System.out.print("]");
    }
	
    public static void main(String[] args) {
		int[] nums = {2,0,0,1,2,0,2};
		SortColors sort = new SortColors();
		sort.sortColors(nums);
		printColors(nums);
	}
}
