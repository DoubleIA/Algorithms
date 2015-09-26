package com.doubleia.linear.array;

/**
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * 
 * For [4, 5, 1, 2, 3] and target=1, return 2.
 * For [4, 5, 1, 2, 3] and target=0, return -1.
 * 
 * O(logN) time
 * 
 * @author wangyingbo
 *
 */
public class SearchInRotatedSortedArray {
	/** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
    	if (A == null || A.length == 0)
    		return -1;
    	
    	int left = 0;
    	int right = A.length - 1;
    	int mid;
    	
    	while (left <= right) {
    		mid = (left + right) / 2;
    		if (A[mid] == target)
    			return mid;
    		if (A[mid] < A[right]) {
    			if (target > A[mid] && target <= A[right])
    				left = mid + 1;
    			else
    				right = mid;
    		} else {
    			if (target >= A[left] && target < A[mid])
    				right = mid - 1;
    			else
    				left = mid + 1;
    		}
    	}
    	
    	return -1;
    }
	
	public static void main(String[] args) {
		int[] A = new int[] {4, 5, 1, 2, 3};
		SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
		System.out.println(search.search(A, 4));
	}
}
