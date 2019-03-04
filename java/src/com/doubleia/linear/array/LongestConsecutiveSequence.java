package com.doubleia.linear.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * @author wangyingbo
 *
 */
public class LongestConsecutiveSequence {
	/**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
    	Set<Integer> set = new HashSet<Integer>();
    	
    	for (int n : num) 
    		set.add(n);
    	
    	int max = 1;
    	for (int n : num) {
    		int cnt = 1;
    		int left = n - 1;
    		int right = n + 1;
    		
    		while (set.contains(left)) {
    			cnt++;
    			set.remove(left);
    			left--;
    		}
    		
    		while (set.contains(right)) {
    			cnt++;
    			set.remove(right);
    			right++;
    		}
    		
    		max = Math.max(max, cnt);
    	}
    	
    	return max;
    }
    
    public static void main(String[] args) {
		LongestConsecutiveSequence lon = new LongestConsecutiveSequence();
		System.out.println(lon.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
	}
}
