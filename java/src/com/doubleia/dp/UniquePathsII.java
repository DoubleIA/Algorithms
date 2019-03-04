package com.doubleia.dp;

/**
 * 
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * 
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 
 * The total number of unique paths is 2.
 * 
 * m and n will be at most 100.
 * 
 * @author wangyingbo
 *
 */
public class UniquePathsII {
	/**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		// write your code here
		int row = obstacleGrid.length;
		int column = obstacleGrid[0].length;
		int[][] grid = new int[row][column];
		
		for (int i = 0; i < row; i++) {
			if (obstacleGrid[i][0] == 0)
				grid[i][0] = 1;
			else
				break;
		}
		
		for (int i = 0; i < column; i++) {
			if (obstacleGrid[0][i] == 0)
				grid[0][i] = 1;
			else
				break;
		}
		
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				if (obstacleGrid[i][j] == 1) {
					grid[i][j] = 0;
					continue;
				}
				grid[i][j] = grid[i - 1][j] + grid[i][j -1];
			}
		}
		
		return grid[row - 1][column - 1];
	}
}
