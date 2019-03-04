package com.doubleia.dp;

/**
 * 
 * Give you an integer matrix (with row size n, column size m)，find the longest increasing continuous subsequence in this matrix.
 * (The definition of the longest increasing continuous subsequence here can start at any row or column and go up/down/right/left any direction).
 * 
 * Given a matrix:
 * 
 * [
 *   [1 ,2 ,3 ,4 ,5],
 *   [16,17,24,23,6],
 *   [15,18,25,22,7],
 *   [14,19,20,21,8],
 *   [13,12,11,10,9]
 * ]
 *
 * return 25
 * 
 * O(nm) time and memory.
 * 
 * @author wangyingbo
 *
 */
public class LongestIncreasingContinuousSubsequenceII {
    /**
     * @param A an integer matrix
     * @return  an integer
     */
	public int longestIncreasingContinuousSubsequenceII(int[][] A) {
		// Write your code here
		int max = 0;
		if (A == null || A.length == 0 || A[0].length == 0)
			return max;
		
		int row = A.length;
		int column = A[0].length;
		int[][] dp = new int[row][column];
		for (int i = 0; i < row; i++) 
			for (int j = 0; j < column; j++) 
				dp[i][j] = 0;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				max = Math.max(max, dfs(i, j, row, column, A, dp));
			}
		}
		
		return max;
	}
	


	private int dfs(int i, int j, int row, int column, int[][] a, int[][] dp) {
		if (dp[i][j] != 0)
			return dp[i][j];
		
		final int[] dx = {0, 1, 0, -1};
		final int[] dy = {-1, 0, 1, 0};
		
		for (int d = 0; d < 4; d++) {
			int x = i + dx[d];
			int y = j + dy[d];
			if (x >= 0 && x < row && y >= 0 && y < column && a[i][j] < a[x][y]) {
				dp[i][j] = Math.max(dp[i][j], dfs(x, y, row, column, a, dp));
			}
		}
		
		return ++dp[i][j];
	}



	public static void main(String[] args) {
		LongestIncreasingContinuousSubsequenceII lon = new LongestIncreasingContinuousSubsequenceII();
		int[][] matrix = new int[][]{{1, 2, 3, 4, 5},
											   {16, 17, 24, 23, 6},
											   {15, 18, 25, 22, 7},
											   {14, 19, 20, 21, 8},
											   {13, 12, 11, 10, 9}};
		System.out.println(lon.longestIncreasingContinuousSubsequenceII(matrix));
	}
}
