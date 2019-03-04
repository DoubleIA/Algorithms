package com.doubleia.linear.array;

/**
 * 
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
 * 
 * Given A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.
 * Given A=[1,2,3] and B=[4,5], the median is 3.
 * 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * @author wangyingbo
 *
 */
public class MedianOfTwoSortedArrays {
	/**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
	public double findMedianSortedArrays(int[] A, int[] B) {
		// write your code here
		int a = A.length;
		int b = B.length;
		
		if (a == 0 && b != 0)
			if (b % 2 != 0)
				return B[b/2];
			else
				return (B[b/2] + B[b/2 - 1]) / 2.0;
		if (b == 0 && a != 0)
			if (a % 2 != 0)
				return A[a/2];
			else
				return (A[a/2] + A[a/2 - 1]) / 2.0;
		if (a == 0 && b == 0)
			return 0;
		
		
		if ((a + b) % 2 != 0)
			return findKth(A, 0, a - 1, B, 0, b - 1, (a + b) / 2);
		else
			return (findKth(A, 0, a - 1, B, 0, b - 1, (a + b) / 2) + findKth(A, 0, a, B, 0, b, (a + b) / 2 - 1)) / 2.0;
		
	}
	
	private double findKth(int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd, int k) {
		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;
		
		if (aLen == 0)
			return B[bStart + k];
		if (bLen == 0)
			return A[aStart + k];
		if (k == 0)
			return A[aStart] > B[bStart] ? B[bStart] : A[aStart];
		
		int aMid = aLen * k / (aLen + bLen);
		int bMid = k - aMid - 1;
		aMid += aStart;
		bMid += bStart;
		
		if (A[aMid] > B[bMid]) {
			k -= bMid - bStart + 1;
			aEnd = aMid;
			bStart = bMid + 1;
		} else {
			k -= aMid - aStart + 1;
			bEnd = bMid;
			aStart = aMid + 1;
		}
		
		return findKth(A, aStart, aEnd, B, bStart, bEnd, k);
	}



	public static void main(String[] args) {
		MedianOfTwoSortedArrays med = new MedianOfTwoSortedArrays();
		System.out.println(med.findMedianSortedArrays(new int[]{4}, new int[]{3}));
	}
}
