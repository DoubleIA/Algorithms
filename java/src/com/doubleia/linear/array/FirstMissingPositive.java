package com.doubleia.linear.array;

/**
 * 
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * @author wangyingbo
 *
 */
public class FirstMissingPositive {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
	public int firstMissingPositive(int[] A) {
		// write your code here
		int i = 0;
		while (i < A.length)
			if (A[i] <= 0 || A[i] == i + 1 || A[i] > A.length || A[i] == A[A[i] - 1])
				i++;
			else
				swap(A, i, A[i] - 1);
		
		int j = 0;
		for (; j < A.length; j++) {
			if (A[j] != j + 1)
				break;
		}
		
		return j + 1;
	}
	

	private void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}


	public static void main(String[] args) {
		FirstMissingPositive fir = new FirstMissingPositive();
		System.out.println(fir.firstMissingPositive(new int[]{2,2,4,0,1,3,3,3,4,3}));
	}
}
