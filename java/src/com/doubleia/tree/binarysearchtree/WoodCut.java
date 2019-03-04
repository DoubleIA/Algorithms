package com.doubleia.tree.binarysearchtree;

/**
 * 
 * Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee 
 * you could have equal or more than k pieces with the same length. What is the longest length 
 * you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.
 * 
 * For L=[232, 124, 456], k=7, return 114.
 * 
 * You couldn't cut wood into float length.
 * 
 * O(n log Len), where Len is the longest length of the wood.
 * 
 * @author wangyingbo
 *
 */
public class WoodCut {
	/**
	 * @param L : Given n pieces of wood with length L[i]
	 * @param k : An integer return: The maximum length of the small pieces.
	 */
	public int woodCut(int[] L, int k) {
		// write your code here
		int len = L.length;
		if (len == 0)
			return 0;
		
		int max = 0;
		for (int i = 0; i < L.length; i++) 
			max = Math.max(max, L[i]);

		int left = 1;
		int right = max;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (count(L, mid) >= k) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if (count(L, left) >= k)
			return left;
		if (count(L, right) >= k)
			return right;
		
		return 0;
	}
	
	private int count(int[] L, int lenght) {
		int sum = 0;
		for (int i = 0; i < L.length; i++) {
			sum += L[i] / lenght;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		WoodCut woodCut = new WoodCut();
		System.out.println(woodCut.woodCut(new int[]{232, 124, 456}, 7));
	}
}
