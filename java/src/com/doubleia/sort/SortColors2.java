package com.doubleia.sort;

/**
 * 
 * Given an array of n objects with k different colors (numbered from 1 to k), 
 * sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.
 * 
 * You are not suppose to use the library's sort function for this problem.
 * 
 * Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].
 * 
 * A rather straight forward solution is a two-pass algorithm using counting sort. 
 * That will cost O(k) extra memory. Can you do it without using extra memory?
 * 
 * @author wangyingbo
 *
 */
public class SortColors2 {
	/**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
    	int lenght = colors.length;
    	if (lenght == 0) 
    		return;
    	
    	for (int i = 0; i < colors.length; i++) {
			while (colors[i] > 0) {
				int color = colors[i];
				if (colors[color - 1] > 0) {
					int temp = colors[color - 1];
					colors[color - 1] = -1;
					if (colors[i] > 0)
						colors[i] = temp;
				} else {
					colors[color - 1]--;
					colors[i] = 0;
				}
			}
		}
    	
    	int index = lenght - 1;
    	for (int i = k - 1; i >= 0; i--) {
			int count = -colors[i];
			while (count > 0) {
				colors[index--] = i + 1;
				count--;
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
		int[] nums = {2,1,1,2,2};
		SortColors2 sort = new SortColors2();
		sort.sortColors2(nums, 2);
		printColors(nums);
	}
}
