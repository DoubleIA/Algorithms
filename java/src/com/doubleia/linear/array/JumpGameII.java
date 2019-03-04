package com.doubleia.linear.array;

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
		int pre = 0;
		int cur = len - 1;
		int count = 0;
		
		while (true) {
			if (pre == cur) {
				return 0;
			}
			count++;
			pre = cur;
			for (int i = cur; i >= 0; i--) {
				if (i + A[i] >= pre) {
					if (cur > i)
						cur = i;
				}
			}
			if (cur == 0)
				break;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {2,3,1,1,4};
		JumpGameII jg = new JumpGameII();
		System.out.println(jg.jump(A));
	}
}
