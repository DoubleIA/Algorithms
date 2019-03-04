package com.doubleia.linear.array;

/**
 * 
 * There is an integer array which has the following features:
 * 
 * * The numbers in adjacent positions are different.
 * * A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
 * 
 * We define a position P is a peek if:
 * * A[P] > A[P-1] && A[P] > A[P+1]
 * 
 * Find a peak element in this array. Return the index of the peak.
 * 
 * Given [1, 2, 1, 3, 4, 5, 7, 6]
 * Return index 1 (which is number 2) or 6 (which is number 7)
 * 
 * The array may contains multiple peeks, find any of them.
 * 
 * Time complexity O(logN)
 * 
 * @author wangyingbo
 *
 */
public class FindPeakElement {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
	public int findPeak(int[] A) {
		// write your code here
		int mid = -1;
		if (A.length < 3)
			return mid;
		
		int left = 0;
		int right = A.length - 1;

		while (left < right) {
			mid = (right + left) / 2;
			if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1] || mid < 1 || mid > A.length - 2)
				break;
			else if (A[mid] < A[mid + 1])
				left = mid;
			else if (A[mid] < A[mid - 1])
				right = mid;
		}
		
		return mid;
	}
	
	public static void main(String[] args) {
		FindPeakElement find = new FindPeakElement();
		System.out.println(find.findPeak(new int[]{1,2,1,3,4,5,7,6}));
	}
}
