package com.doubleia.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.
 * 
 * Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4]
 * 
 * O(nlogn) time
 * 
 * @author wangyingbo
 *
 */
public class SubarraySumClosest {
	//O(n^2) time
	/*public ArrayList<Integer> subarraySumClosest(int[] nums) {
        // write your code here
		ArrayList<Integer> indexs = new ArrayList<>(2);
		
		if (nums.length == 1) {
			indexs.add(0);
			indexs.add(0);
			return indexs;
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int m = nums[i];
			ArrayList<Integer> indices = new ArrayList<>(2);
			indices.add(i);
			indices.add(i);
			for (int start = i + 1; start < nums.length; start++) {
				if (min > Math.abs(m)) {
					min = Math.abs(m);
					indexs.removeAll(indexs);
					indexs.add(indices.get(0));
					indexs.add(indices.get(1));
				}
				m = m + nums[start];
				indices.remove(1);
				indices.add(start);
			}
		}
		
		return indexs;
    }*/
	
	/**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        // write your code here
    	ArrayList<Integer> indexs = new ArrayList<>(2);
		
    	if (nums.length == 0 || nums == null)
    		return null;
    	else if(nums.length == 1) {
    		indexs.add(0);
			indexs.add(0);
			return indexs;
    	}
    	
    	Element[] sums = new Element[nums.length + 1];
    	sums[0] = new Element(0, -1);
    	int sum = 0;
    	for (int i = 0; i < nums.length; i++) {
    		sum += nums[i];
			sums[i + 1] = new Element(sum, i);
		}
    	
    	Arrays.sort(sums, new Comparator<Element>() {

			@Override
			public int compare(Element e1, Element e2) {
				return e1.val - e2.val;
			}
    		
		});
    	
    	int left = 0;
    	int right = 0;
    	sum = Integer.MAX_VALUE;
    	for (int i = 0; i < sums.length - 1; i++) {
			if (sum > Math.abs(sums[i].val - sums[i + 1].val)) {
				sum = Math.abs(sums[i].val -sums[i + 1].val);
				left = Math.min(sums[i].index, sums[i + 1].index) + 1;
				right = Math.max(sums[i].index, sums[i + 1].index);
			}
		}
    	indexs.add(left);
		indexs.add(right);
		return indexs;
    }
	
    private class Element {
    	private int val;
    	private int index;
    	
    	Element(int val, int index) {
    		this.val = val;
    		this.index = index;
    	}
    	
    }
    
	public static void main(String[] args) {
		int[] nums = {101,33,44,55,67,78,-101,33,-44,55,-67,78,-100,200,-1000,22,100,200,1000,22};
		SubarraySumClosest sum = new SubarraySumClosest();
		ArrayList<Integer> result = sum.subarraySumClosest(nums);
		System.out.println("[" + result.get(0) + ", " + result.get(1) + "]");
	}

}
