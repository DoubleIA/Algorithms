package com.doubleia.dp;

/**
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
 * 
 * For example, given the following matrix: 
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * Return 4. 
 * 
 * @author wangyingbo
 *
 */
public class MaximalSquare {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
	public int maxSquare(int[][] matrix) {
		// write your code here
		int max = 0;
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return max;
		
		int[][] dp = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			dp[i][0] = matrix[i][0];
			max = Math.max(max, dp[i][0]);
		}
		for (int i = 0; i < matrix[0].length; i++) {
			dp[0][i] = matrix[0][i];
			max = Math.max(max, dp[0][i]);
		}
		
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) 
					dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1;
				else
					dp[i][j] = 0;
				max = Math.max(max, dp[i][j]);
			}
		}
		
		return max * max;
	}

	private int min(int i, int j, int k) {
		return Math.min(Math.min(i, j), k);
	}
	
	public static void main(String[] args) {
		MaximalSquare max = new MaximalSquare();
		int[][] matrix = new int[][]{{1, 1, 1, 0, 0},{1, 1, 1, 1, 1},{1, 1, 1, 1, 1},{1, 0, 0, 1, 0}};
		System.out.println(max.maxSquare(matrix));
	}
}
