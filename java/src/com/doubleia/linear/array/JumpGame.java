package com.doubleia.linear.array;

/**
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * 
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * 
 * This problem have two method which is Greedy and Dynamic Programming.
 * The time complexity of Greedy method is O(n).
 * The time complexity of Dynamic Programming method is O(n^2).
 * 
 * We manually set the small data set to allow you pass the test in both ways. 
 * This is just to let you learn how to use this problem in dynamic programming ways. 
 * If you finish it in dynamic programming ways, you can try greedy method to make it accept again.
 * 
 * @author wangyingbo
 *
 */
public class JumpGame {
	/**
     * @param A: A list of integers
     * @return: The boolean answer
     */
	public boolean canJump(int[] A) {
		// wirte your code here
		int len = A.length;
		if (A == null || len == 0)
			return true;

		int pre = 0;
		int cur = 0;
		int i = 0;

		while (pre < len - 1) {
			if (i + A[i] > pre)
				pre = i + A[i];
			if (i >= cur) {
				if (pre <= cur)
					return false;
				cur = pre;
			}
			i++;
		}

		return true;
	}

	public static void main(String[] args) {
		int[] A = new int[] {2,3,1,1,4};
		JumpGame jg = new JumpGame();
		System.out.println(jg.canJump(A));
	}
}
