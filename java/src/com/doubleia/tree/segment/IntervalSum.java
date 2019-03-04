package com.doubleia.tree.segment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Given an integer array (index from 0 to n-1, where n is the size of this array), and an query list. 
 * Each query has two integers [start, end]. For each query, calculate the sum number 
 * between index start and end in the given array, return the result list.
 * 
 * For array [1,2,7,8,5], and queries [(0,4),(1,2),(2,4)], return [23,9,20]
 * 
 * O(logN) time for each query
 * 
 * @author wangyingbo
 *
 */
public class IntervalSum {
	/**
	 * @param A, queries: Given an integer array and an query list
	 * @return: The result list
	 */
	public ArrayList<Long> intervalSum(int[] A, ArrayList<Interval> queries) {
		// write your code here
		ArrayList<Long> res = new ArrayList<Long>();
		if (A == null || A.length == 0 || queries == null || queries.size() == 0)
			return res;
		
		SegmentTreeNode root = build(A);
		for (Interval inter : queries) {
			res.add(query(root, inter.start, inter.end));
		}
		
		return res;
	}
	
	private Long query(SegmentTreeNode root, int start, int end) {
		if (start > end)
			return 0l;
		if (start < root.start)
			start = root.start;
		if (end > root.end)
			end = root.end;
		
		if (start == root.start && end == root.end)
			return root.sum;
		
		int mid = (root.start + root.end) / 2;
		if (start > mid)
			return query(root.right, start, end);
		else if (end <= mid)
			return query(root.left, start, end);
		else
			return query(root.left, start, mid) + query(root.right, mid + 1, end);
	}
	
	private SegmentTreeNode build(int[] A) {
		SegmentTreeNode root = build(A, 0, A.length - 1);
		sum(root);
		return root;
	}
	
	private SegmentTreeNode build(int[] A, int start, int end) {
		if (start > end)
			return null;
		SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
		if (start == end) {
			root.sum = A[start];
			return root;
		}
		int mid = (start + end) / 2;
		root.left = build(A, start, mid);
		root.right = build(A, mid + 1, end);
		return root;
	}
	
	private long sum(SegmentTreeNode root) {
		if (root.left != null && root.right != null) {
			root.sum = sum(root.left) + sum(root.right);
			return root.sum;
		} else if (root.left != null) {
			root.left.sum = sum(root.left);
			return root.left.sum;
		} else if (root.right != null) {
			root.right.sum = sum(root.right);
			return root.right.sum;
		} else {
			return root.sum;
		}
	}
	
	class SegmentTreeNode {
		int start, end;
		long sum;
		SegmentTreeNode left, right;
		public SegmentTreeNode(int start, int end, long sum) {
			this.start = start;
			this.end = end;
			this.sum = sum;
			this.left = this.right = null;
		}
	}
	
	public static void main(String[] args) {
		IntervalSum min = new IntervalSum();
		ArrayList<Interval> queries = new ArrayList<Interval>();
		//(1,2),(0,4),(2,4)
		queries.addAll(Arrays.asList(new Interval[]{new Interval(1, 2), new Interval(0, 4), new Interval(2, 4)}));
		System.out.println(min.intervalSum(new int[]{1,2,7,8,5}, queries));
	}
}
