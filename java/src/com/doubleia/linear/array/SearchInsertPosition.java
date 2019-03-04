package com.doubleia.linear.array;

/**
 * 
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * 
 * You may assume NO duplicates in the array.
 * 
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 
 * O(log(n)) time
 * 
 * @author wangyingbo
 *
 */
public class SearchInsertPosition {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
    	if (A == null)
    		return -1;
    	if (A.length == 0)
    		return 0;
    	
    	int left = 0;
    	int right = A.length - 1;
    	int index = -1;
    	
    	while (left <= right) {
    		int mid = (left + right) / 2;
    		if (A[mid] == target || left == right) {
    			index = mid;
    			break;
    		}
    		if (A[mid] < target) {
    			left = mid + 1;
    		} else {
    			right = mid;
    		}
    	}
    	
    	if (A[index] >= target)
    		return index;
    	else
    		return index + 1;
    }
    
    public static void main(String[] args) {
		SearchInsertPosition search = new SearchInsertPosition();
		System.out.println(search.searchInsert(new int[] {1,3,5,6}, 7));
	}
}
