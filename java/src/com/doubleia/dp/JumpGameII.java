package com.doubleia.dp;

/**
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array. 
 * Each element in the array represents your maximum jump length at that position. 
 * Your goal is to reach the last index in the minimum number of jumps. 
 * 
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.) 
 * 
 * @author wangyingbo
 *
 */
public class JumpGameII {
	/**
     * @param A: A list of lists of integers
     * @return: An integer
     */
	public int jump(int[] A) {
		// write your code here
		int len = A.length;
		if (A == null || len == 0)
			return Integer.MAX_VALUE;
		
		int[] d = new int[len];
		d[0] = 0;
		
		for (int i = 1; i < d.length; i++) {
			d[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (j + A[j] >= i) {
					int temp = d[j] + 1;
					if (temp < d[i]) {
						d[i] = temp;
						break;
					}
				}
			}
		}
		
		return d[len - 1];
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {2,3,1,1,4};
		JumpGameII jg = new JumpGameII();
		System.out.println(jg.jump(A));
	}
}
