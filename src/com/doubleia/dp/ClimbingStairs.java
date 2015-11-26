package com.doubleia.dp;

/**
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Given an example n=3 , 1+1+1=2+1=1+2=3
 * return 3
 * 
 * @author wangyingbo
 *
 */
public class ClimbingStairs {
    /**
     * @param n: An integer
     * @return: An integer
     */
	public int climbStairs(int n) {
		// write your code here
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		ClimbingStairs cli = new ClimbingStairs();
		System.out.println(cli.climbStairs(4));
	}
}
