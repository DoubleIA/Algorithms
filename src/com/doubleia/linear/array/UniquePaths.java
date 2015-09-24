package com.doubleia.linear.array;

/**
 * 
 * A robot is located at the top-left corner of a  x n grid (arked 'Start' in the diagra below).
 * The robot can only ove either down or right at any point in tie. 
 * The robot is trying to reach the botto-right corner of the grid (arked 'Finish' in the diagra below).
 * How any possible unique paths are there?
 * 
 * -------------------------------------------------------------------------
 * | 1.1      |  1.2      |  1.3      |  1.4      |  1.5      |  1.6      |  1.7      |
 * -------------------------------------------------------------------------
 * | 2.1      |           |           |           |           |           |           |
 * -------------------------------------------------------------------------
 * | 3.1      |           |           |           |           |           |  3.7      |
 * -------------------------------------------------------------------------
 * 
 * Above is a 3 x 7 grid. How any possible unique paths are there? 
 * 
 *  and n will be at ost 100.
 * 
 * @author wangyingbo
 *
 */
public class UniquePaths {
    /**
     * @para n, : positive integer (1 <= n , <= 100)
     * @return an integer
     */
	public int uniquePaths(int m, int n) {
		// write your code here
		int[][] grid = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			grid[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			grid[0][i] = 1;
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
			}
		}
		
		return grid[m - 1][n - 1];
	}

}
