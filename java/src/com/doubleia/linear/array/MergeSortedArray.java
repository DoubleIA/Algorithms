package com.doubleia.linear.array;

/**
 * 
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * A = [1, 2, 3, empty, empty], B = [4, 5]
 * After merge, A will be filled as [1, 2, 3, 4, 5]
 * 
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 * 
 * @author wangyingbo
 *
 */
public class MergeSortedArray {
	/**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
    	int i = m - 1;
    	int j = n - 1;
    	int k = m + n - 1;
    	
    	while (k >=0) {
    		if (j < 0 || (i >= 0 && A[i] > B[j]))
    			A[k--] = A[i--];
    		else
    			A[k--] = B[j--];
    	}
    	
    }
    
    public static void main(String[] args) {
		MergeSortedArray merge = new MergeSortedArray();
		int[] A = new int[5];
		A[0] = 1; A[1] = 2; A[2] = 3;
		int[] B = new int[] {4, 5};
		merge.mergeSortedArray(A, 3, B, 2);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]);
			if (i < A.length - 1)
				System.out.print(", ");
		}
	}
    
}
