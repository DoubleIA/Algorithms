package com.doubleia.linear.queue;

/**
 * 
 * Ugly number is a number that only have factors 3, 5 and 7. 
 * 
 * Design an algorithm to find the Kth ugly number. The first 5 ugly numbers are 3, 5, 7, 9, 15 ...
 * 
 * If K=4, return 9.
 * 
 * O(K log K) or O(K) time.
 * 
 * @author wangyingbo
 *
 */
public class UglyNumber {
	/**
	 * @param k : The number k.
	 * @return: The kth prime number as description.
	 */
	public long kthPrimeNumber(int k) {
		// write your code here
		int idx3 = 0, idx5 = 0, idx7 = 0;
		
		long[] ugly = new long[k + 1];
		ugly[0] = 1;
		
		for (int i = 1; i <= k; i++) {
			long min = min(ugly[idx3] * 3, ugly[idx5] * 5, ugly[idx7] * 7);
			if (min == ugly[idx3] * 3)
				idx3++;
			if (min == ugly[idx5] * 5)
				idx5++;
			if (min == ugly[idx7] * 7)
				idx7++;
			ugly[i] = min;
		}
		
		return ugly[k];
	}
	
	private long min(long i, long j, long k) {
		long min = Math.min(i, j);
		return Math.min(min, k);
	}
	
	public static void main(String[] args) {
		UglyNumber ugly = new UglyNumber();
		System.out.println(ugly.kthPrimeNumber(4));
	}
}
