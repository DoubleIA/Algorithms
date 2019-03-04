package com.doubleia.dp;

/**
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * You can only move either down or right at any point in time.
 * 
 * @author wangyingbo
 *
 */
public class MinimumPathSum {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
	public int minPathSum(int[][] grid) {
		// write your code here
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		
		int[][] dp = new int[grid.length][grid[0].length];
		
		dp[0][0] = grid[0][0];
		for (int i = 1; i < grid.length; i++) 
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		for (int i = 1; i < grid[0].length; i++) 
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}
		
		return dp[grid.length - 1][grid[0].length - 1];
	}
	
	public static void main(String[] args) {
		MinimumPathSum min = new MinimumPathSum();
		int[][] grid = new int[][]{{1,2,3},{0,1,1}};
		System.out.println(min.minPathSum(grid));
	}
}
