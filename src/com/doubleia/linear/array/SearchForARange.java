package com.doubleia.linear.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Given a sorted array of n integers, find the starting and ending position of a given target value.
 * If the target is not found in the array, return [-1, -1].
 * 
 * Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * O(log n) time.
 * 
 * @author wangyingbo
 *
 */
public class SearchForARange {
	/** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
		// write your code here
		ArrayList<Integer> indices = new ArrayList<Integer>(2);
		indices.addAll(Arrays.asList(new Integer[] {-1, -1}));
		
		if (A.size() == 0 || A == null)
			return indices;
		
		int left = 0;
		int right = A.size() - 1;
		
		while (left <= right) {
			if (indices.get(0) == -1) {
				if (A.get(left) == target) {
					indices.remove(0);
					indices.add(0, left);
					continue;
				}
				left++;
			} else {
				if (A.get(right) == target) {
					indices.remove(1);
					indices.add(1, right);
					break;
				}
				right--;
			}
		}
		
		return indices;
	}
    
    public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		SearchForARange search = new SearchForARange();
		A.addAll(Arrays.asList(new Integer[] {5, 7, 7, 8, 8, 10}));
		System.out.println(search.searchRange(A, 8));
	}
}
