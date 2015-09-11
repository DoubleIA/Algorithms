package com.doubleia.sort;

import java.util.Arrays;


/**
 * 
 * Given n distinct positive integers, integer k (k <= n) and a number target.
 * Find k numbers where sum is target. Calculate how many solutions there are?
 * 
 * @author wangyingbo
 *
 */
public class KSum {

	/**
	 * @param A
	 *            : an integer array.
	 * @param k
	 *            : a positive integer (k <= length(A))
	 * @param target
	 *            : a integer
	 * @return an integer
	 */
	public int kSum(int A[], int k, int target) {
		// write your code here
		if (k <= 0 || k > A.length) {
			return 0;
		}

		Arrays.sort(A);
		int solutions = rSum(A, k, 0, target);

		return solutions;
	}

	private int rSum(int A[], int k, int start, int target) {
		int count = 0;

		if (k == 1) {
			for (int i = 0; i < A.length; i++) {
				if (A[i] == target) {
					count++;
				}
			}
			return count;
		}

		if (k == 2) {
			int left = start;
			int right = A.length - 1;
			while (left < right) {
				int sum = A[left] + A[right];
				if (sum == target) {
					count++;
					left++;
					right--;
				} else if (sum < target) {
					left++;
				} else {
					right--;
				}
			}
			return count;
		}

		for (int i = start; i < A.length - k + 1; i++) {
			int tar = target - A[i];
			int temp = rSum(A, k - 1, i + 1, tar);
			count += temp;
		}

		return count;
	}
	
/*	public int kSum(int A[], int k, int target) {
		if (A.length < k || k == 0)
			return 0;

		if (k == 1) {
			for (int i = 0; i < A.length; i++)
				if (A[i] == target)
					return 1;
			return 0;
		} else {
			int[] B = new int[A.length - 1];
			if (A.length > 1)
				System.arraycopy(A, 1, B, 0, A.length - 1);
			return kSum(B, k - 1, target - A[0]) + kSum(B, k, target);
		}
	}*/

	public static void main(String[] args) {
		int A[] = {1,3,4,5,7,10,11,13,14,17,18,19,21,22,24,25,28,31,32,33,36,39,41,44,47,50,51,52,54,57,59,62,65,67,68,69,70};
		KSum sum = new KSum();
		int result = sum.kSum(A, 27, 1000);
		System.out.println(result);
	}

}