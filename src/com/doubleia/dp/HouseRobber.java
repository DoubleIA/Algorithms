package com.doubleia.dp;

/**
 * 
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that 
 * adjacent houses have security system connected and it will automatically contact the police 
 * if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 * Given [3, 8, 4], return 8.
 * 
 * O(n) time and O(1) memory.
 * 
 * @author wangyingbo
 *
 */
public class HouseRobber {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
	public long houseRobber(int[] A) {
		// write your code here
		if (A == null || A.length == 0)
			return 0;
		if (A.length == 1)
			return A[0];
		
		long max = 0;
		long lM = A[0];
		long rM = Math.max(A[0], A[1]);
		
		for (int i = 2; i < A.length; i++) {
			long tmp = Math.max(rM, lM + A[i]);
			lM = rM;
			rM = tmp;
			max = Math.max(tmp, max);
		}
		
		return max;
	}

	public static void main(String[] args) {
		HouseRobber hou = new HouseRobber();
		System.out.println(hou.houseRobber(new int[]{828,125,740,724,983,321,773,678,841,842,875,377,674,144,340,467,625,916,463,922,255,662,692,123,778,766,254,559,480,483,904,60,305,966,872,935,626,691,832,998,508,657,215,162,858,179,869,674,452,158,520,138,847,452,764,995,600,568,92,496,533,404,186,345,304,420,181,73,547,281,374,376,454,438,553,929,140,298,451,674,91,531,685,862,446,262,477,573,627,624,814,103,294,388}));
	}
}
