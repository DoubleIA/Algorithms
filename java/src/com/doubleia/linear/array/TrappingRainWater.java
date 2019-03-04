package com.doubleia.linear.array;

/**
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * rainwatertrap.png
 * 
 * O(n) time and O(1) memory
 * O(n) time and O(n) memory is also acceptable.
 * 
 * @author wangyingbo
 *
 */
public class TrappingRainWater {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
	public int trapRainWater(int[] heights) {
		// write your code here
		if (heights == null || heights.length == 0)
			return 0;
		
		int left = 0;
		int right = heights.length - 1;
		int trap = 0;
		int h = 0;
		
		while (left < right) {
			if (heights[left] < heights[right]) {
				h = Math.max(h, heights[left]);
				trap += h - heights[left];
				left++;
			} else {
				h = Math.max(h, heights[right]);
				trap += h - heights[right];
				right--;
			}
		}
		
		return trap;
	}
	
	public static void main(String[] args) {
		TrappingRainWater trap = new TrappingRainWater();
		System.out.println(trap.trapRainWater(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
	}
	
}
