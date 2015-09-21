package com.doubleia.dp;

/**
 * 
 * Given n distinct positive integers, integer k (k <= n) and a number target.
 * Find k numbers where sum is target. Calculate how many solutions there are?
 * 
 * Given [1,2,3,4], k = 2, target = 5.
 * There are 2 solutions: [1,4] and [2,3].
 * Return 2.
 * 
 * @author wangyingbo
 *
 */
public class KSum {

	/**
	 * 
	 * d[i][j] means the number of methods for numbers is i and target is j
	 * d[i][j] += d[i - 1][j - A[i - 1]]
	 * 
	 * @param A : an integer array.
	 * @param k : a positive integer (k <= length(A))
	 * @param target : a integer
	 * @return an integer
	 */
	public int kSum(int A[], int k, int target) {
		// write your code here
		int len = A.length;
		if (k <= 0 || k > len) {
			return 0;
		}
		
		int[][] d = new int[k + 1][target + 1];
		
		d[0][0] = 1;
		
		for (int i = 1; i < d.length; i++) {
			d[i][0] = 0;
		}
		
		for (int i = 1; i <= len; i++) {
			//The reason why the iterator tar if from target to zero is
			//to guarantee the d[p - 1][tar - A[i - 1]] are from the last pass,
			//only by this way, d[p][tar] can get the correct result 
			for (int tar = target; tar > 0; tar--) {
				for (int p = 1; p <= k; p++) {
					if (tar - A[i - 1] >= 0)
						d[p][tar] += d[p - 1][tar - A[i - 1]];
				}
			}
		}
		
		return d[k][target];
	}
        
	public static void main(String[] args) {
		//result : 1104718
		int A[] = {1,3,4,5,7,10,11,13,14,17,18,19,21,22,24,25,28,31,32,33,36,39,41,44,47,50,51,52,54,57,59,62,65,67,68,69,70};
		KSum sum = new KSum();
		long start = System.currentTimeMillis();
		int result = sum.kSum(A, 27, 1000);
		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start) + ", result :" + result);
	}
	
	/**
	 * 
	 * Time Limited Exceeded
	 * 
	 * 	public int kSum(int A[], int k, int target) {
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
	 * 
	 */

}