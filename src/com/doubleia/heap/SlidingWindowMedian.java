package com.doubleia.heap;

import java.util.ArrayList;

/**
 * 
 * Given an array of n integer, and a moving window(size k), 
 * move the window at each iteration from the start of the array, 
 * find the median of the element inside the window at each moving. 
 * (If there are even numbers in the array, return the N/2-th number 
 * after sorting the element in the window. )
 * 
 * For array [1,2,7,8,5], moving window size k = 3. return [2,7,7]
 * At first the window is at the start of the array like this
 * [ | 1,2,7 | ,8,5] , return the median 2;
 * then the window move one step forward.
 * [1, | 2,7,8 | ,5], return the median 7;
 * then the window move one step forward again.
 * [1,2, | 7,8,5 | ], return the median 7;
 * 
 * O(nlog(n)) time
 * 
 * @author wangyingbo
 *
 */
public class SlidingWindowMedian {
	/**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
    	ArrayList<Integer> median = new ArrayList<Integer>();
    	
    	
    	
    	return median;
    }
    
    public static void main(String[] args) {
    	SlidingWindowMedian slide = new SlidingWindowMedian();
		ArrayList<Integer> result = slide.medianSlidingWindow(new int[] {1,2,7,8,5}, 3);
		System.out.println(result);
	}
}
