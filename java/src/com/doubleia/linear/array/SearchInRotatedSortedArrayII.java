package com.doubleia.linear.array;

/**
 * 
 * Follow up for "Search in Rotated Sorted Array":
 * 
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 * 
 * @author wangyingbo
 *
 */
public class SearchInRotatedSortedArrayII {
	/** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        // write your code here
    	if (A == null || A.length == 0)
    		return false;
    	int left = 0;
    	int right = A.length - 1;
    	
    	while (left <= right) {
    		int mid = (left + right) / 2;
    		if (A[mid] == target)
    			return true;
    		if (A[left] == A[mid] && A[right] == A[mid]) {
    			left++;
    			right--;
    		} else if (A[mid] < A[right]) {
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
    	
    	return false;
    }
    
    public static void main(String[] args) {
		SearchInRotatedSortedArrayII search = new SearchInRotatedSortedArrayII();
		System.out.println(search.search(new int[] {7,9,1,1,2,3,4,4,4,5,6,7}, 0));
	}
}
