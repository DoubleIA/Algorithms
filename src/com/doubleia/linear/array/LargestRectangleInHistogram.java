package com.doubleia.linear.array;

import java.util.Stack;

/**
 * 
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 * 
 * Given height = [2,1,5,6,2,3],
 * return 10.
 * 
 * @author wangyingbo
 *
 */
public class LargestRectangleInHistogram {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
    	int len = height.length;
    	if (len == 0)
    		return 0;
    	
    	int max = 0;
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(height[0]);
    	
    	int i = 1;
    	int cnt = 0;
    	int res = 0;
    	while (i < len) {
    		if (stack.isEmpty() || height[i] >= stack.peek()) {
    			for (int k = 0; k < cnt; k++) {
					stack.push(height[i]);
				}
    			cnt = 0;
    			stack.push(height[i++]);
    		} else {
    			cnt++;
    			res = stack.pop();
    			max = Math.max(max, cnt * res);
    		}
    	}
    	
    	for (int j = 0; j < height.length; j++) {
			max = Math.max(max, stack.pop() * (j + 1));
		}
    	
    	return max;
    }
    
    public static void main(String[] args) {
		LargestRectangleInHistogram lar = new LargestRectangleInHistogram();
		System.out.println(lar.largestRectangleArea(new int[]{2,1,5,6,2,3}));
	}
}
