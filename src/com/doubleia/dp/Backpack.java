package com.doubleia.dp;

/**
 * 
 * Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack? 
 * 
 * If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max 
 * size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.
 * 
 * You function should return the max size we can fill in the given backpack.
 * 
 * You can not divide any item into small pieces.
 * 
 * O(n x m) time and O(m) memory.
 * O(n x m) memory is also acceptable if you do not know how to optimize memory.
 * 
 * @author wangyingbo
 *
 */
public class Backpack {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
	public int backPack(int m, int[] A) {
		// write your code here
		if (A == null || A.length == 0 || m <= 0)
			return 0;
		
		boolean[] dp = new boolean[m + 1];
		dp[0] = true;
		
		int max = 0;
		for (int i = 1; i <= A.length; i++) {
			for (int j = m; j >=1; j--) {
				if (j - A[i - 1] >= 0)
					dp[j] |= dp[j - A[i - 1]]; 
				if (dp[j])
					max = Math.max(max, j);
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		Backpack back = new Backpack();
		System.out.println(back.backPack(11, new int[]{2, 3, 5, 7}));
	}
	
	/**
	 * 
	 // O(mn) Memory
	 public int backPack(int m, int[] A) {
		// write your code here
		if (A == null || A.length == 0 || m <= 0)
			return 0;
		
		boolean[][] dp = new boolean[A.length + 1][m + 1];
		
		for (int i = 0; i <= A.length; i++) {
			dp[i][0] = true;
		}
		
		int max = 0;
		for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j - A[i - 1] >= 0)
					dp[i][j] |= dp[i - 1][j - A[i - 1]]; 
				if (dp[i][j])
					max = Math.max(max, j);
			}
		}
		
		return max;
	}
	 * 
	 */
}
