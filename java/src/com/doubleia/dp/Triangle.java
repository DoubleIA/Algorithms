package com.doubleia.dp;

/**
 * 
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * 
 * @author wangyingbo
 *
 */
public class Triangle {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
	public int minimumTotal(int[][] triangle) {
		// write your code here
		if (triangle == null || triangle.length == 0)
			return 0;
		
		int[] dp = new int[triangle[triangle.length - 1].length];
		dp[0] = triangle[0][0];
		
		for (int i = 1; i < triangle.length; i++) {
			for (int j = triangle[i].length - 1; j >= 0; j--) {
				if (j == 0)
					dp[j] = dp[j] + triangle[i][j];
				else if (j == triangle[i].length - 1)
					dp[j] = dp[j - 1] + triangle[i][j];
				else
					dp[j] = Math.min(dp[j - 1], dp[j]) + triangle[i][j];
			}
			
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < dp.length; i++) {
			min = Math.min(min, dp[i]);
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		Triangle handler = new Triangle();
		int[][] tri = new int[][]{{2},{3,4},{6,5,7},{4,1,8,3}};
		System.out.println(handler.minimumTotal(tri));
	}
}
