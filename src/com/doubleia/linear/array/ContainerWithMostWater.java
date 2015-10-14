package com.doubleia.linear.array;

/**
 * 
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * 
 * Given [1,3,2], the max area of the container is 2.
 * 
 * You may not slant the container.
 * 
 * @author wangyingbo
 *
 */
public class ContainerWithMostWater {
	/**
     * @param heights: an array of integers
     * @return: an integer
     */
	public int maxArea(int[] heights) {
		// write your code here
		int len = heights.length;
		if (len == 0)
			return 0;
		
		int left = 0;
		int right = len - 1;
		int maxArea = 0;
		while (left < right) {
			if (heights[left] >= heights[right]) {
				maxArea = Math.max((right - left) * heights[right], maxArea);
				right--;
			} else {
				maxArea = Math.max((right - left) * heights[left], maxArea);
				left++;
			}
		}
		
		return maxArea;
	}
	
	public static void main(String[] args) {
		ContainerWithMostWater con = new ContainerWithMostWater();
		System.out.println(con.maxArea(new int[]{1,3,2}));
	}
}
