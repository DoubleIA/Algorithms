package com.doubleia.dp;

/**
 * 
 * Given n, how many structurally unique BSTs (binary search trees) that store values 1...n?
 * 
 * Given n = 3, there are a total of 5 unique BST's.
 * 
 *  1           3    3       2      1
 *   \         /    /       / \      \
 *    3      2     1       1   3       2
 *   /      /       \                   \
 *  2      1         2                   3
 * 
 * @author wangyingbo
 *
 */
public class UniqueBinarySearchTrees {
    /**
     * @paramn n: An integer
     * @return: An integer
     */
	public int numTrees(int n) {
		// write your code here
		if (n < 0)
			return 0;
		if (n == 0)
		    return 1;
		if (n == 1)
		    return 1;
		
		int[] record = new int[n + 1];
		record[0] = 1;
		record[1] = 1;
		record[2] = 2;
		
		for (int i = 3; i <= n; i++) {
			int tmp = 0;
			for (int j = 0; j < i; j++) {
				tmp += record[j] * record[i - j - 1];
			}
			record[i] = tmp;
		}
		
		return record[n];
	}
	
	public static void main(String[] args) {
		UniqueBinarySearchTrees uni = new UniqueBinarySearchTrees();
		System.out.println(uni.numTrees(3));
	}
}
