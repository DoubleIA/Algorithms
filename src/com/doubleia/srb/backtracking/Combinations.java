package com.doubleia.srb.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
 * 
 * @author wangyingbo
 *
 */
public class Combinations {
	List<List<Integer>> com = new ArrayList<List<Integer>>();
	int k = 0;
	int n = 0;
	
	
	/**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
    	this.n = n;
    	this.k = k;
    	
    	if (n < k)
    		return com;
    	
    	List<Integer> li = new ArrayList<Integer>();
    	backTracking(li, 1);
    	
    	return com;
    }


	private void backTracking(List<Integer> list, int from) {
		if (list.size() == k) {
			List<Integer> li = new ArrayList<Integer>(list);
			com.add(li);
			return;
		}
		for (int i = from; i <= n; i++) {
			list.add(i);
			backTracking(list, i + 1);
			list.remove(new Integer(i));
		}
	}
	
	public static void main(String[] args) {
		Combinations com = new Combinations();
		List<List<Integer>> ans = com.combine(4, 2);
		System.out.println(ans);
	}
	
}
