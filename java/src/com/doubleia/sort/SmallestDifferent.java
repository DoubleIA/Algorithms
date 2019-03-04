package com.doubleia.sort;

import java.util.Arrays;

/**
 * 
 * Given two array of integers(the first array is array A, the second array is array B), 
 * now we are going to find a element in array A which is A[i], 
 * and another element in array B which is B[j], 
 * so that the difference between A[i] and B[j] (|A[i] - B[j]|) is as small as possible,
 * return their smallest difference.
 * 
 * For example, given array A = [3,6,7,4], B = [2,8,9,3], return 0
 * 
 * O(n log n) time
 * 
 * @author wangyingbo
 *
 */
public class SmallestDifferent {
	/**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
    	Arrays.sort(A);
    	Arrays.sort(B);
    	
    	int min = Integer.MAX_VALUE;
    	int aLeft = 0;
    	int bLeft = 0;
    	while (aLeft < A.length && bLeft < B.length) {
    		int dis = A[aLeft] - B[bLeft];
	    	if (dis >= 0) {
	    		if (min > dis)
	    			min = dis;
	    		bLeft++;
	    	} else {
	    		if (min > -dis)
	    			min = -dis;
	    		aLeft++;
	    	}
    	}
    	
    	return min;
    }
    
    public static void main(String[] args) {
		int A[] = {1};
		int B[] = {6,8,9,3};
		SmallestDifferent dif = new SmallestDifferent();
		int result = dif.smallestDifference(A, B);
		System.out.println(result);
	}
}
