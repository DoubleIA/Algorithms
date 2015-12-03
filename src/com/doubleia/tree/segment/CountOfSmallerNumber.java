package com.doubleia.tree.segment;

import java.util.ArrayList;

/**
 * 
 * Give you an integer array (index from 0 to n-1, where n is the size of this array, value from 0 to 10000) and an query list. 
 * For each query, give you an integer, return the number of element in the array that are smaller than the given integer.
 * 
 * For array [1,2,7,8,5], and queries [1,8,5], return [0,4,2]
 * 
 * Could you use three ways to do it.
 * 
 * 1. Just loop
 * 2. Sort and binary search
 * 3. Build Segment Tree and Search.
 * 
 * @author wangyingbo
 *
 */
public class CountOfSmallerNumber {
	/**
	 * @param A: An integer array
	 * @return: The number of element in the array that are smaller that the
	 *          given integer
	 */
	class SegmentTreeNode {
		public int start, end;
		public int count;
		public SegmentTreeNode left, right;

		public SegmentTreeNode(int start, int end, int count) {
			this.start = start;
			this.end = end;
			this.count = count;
			this.left = this.right = null;
		}
	}

	SegmentTreeNode root;

	public SegmentTreeNode build(int start, int end) {
		// write your code here
		if (start > end) { // check core case
			return null;
		}

		SegmentTreeNode root = new SegmentTreeNode(start, end, 0);

		if (start != end) {
			int mid = (start + end) / 2;
			root.left = build(start, mid);
			root.right = build(mid + 1, end);
		} else {
			root.count = 0;
		}
		return root;
	}

	public int querySegmentTree(SegmentTreeNode root, int start, int end) {
		// write your code here
		if (start == root.start && root.end == end) { 
			return root.count;
		}

		int mid = (root.start + root.end) / 2;
		int leftcount = 0, rightcount = 0;
		
		if (start <= mid) {
			if (mid < end) { 
				leftcount = querySegmentTree(root.left, start, mid);
			} else { 
				leftcount = querySegmentTree(root.left, start, end);
			}
		}
		
		if (mid < end) { 
			if (start <= mid) {
				rightcount = querySegmentTree(root.right, mid + 1, end);
			} else { 
				rightcount = querySegmentTree(root.right, start, end);
			}
		}
		
		return leftcount + rightcount;
	}

	public void modifySegmentTree(SegmentTreeNode root, int index, int value) {
		// write your code here
		if (root.start == index && root.end == index) { 
			root.count += value;
			return;
		}

		int mid = (root.start + root.end) / 2;
		if (root.start <= index && index <= mid) {
			modifySegmentTree(root.left, index, value);
		}

		if (mid < index && index <= root.end) {
			modifySegmentTree(root.right, index, value);
		}
		root.count = root.left.count + root.right.count;
	}

	public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
		// write your code here
		root = build(0, 10000);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int res;
		for (int i = 0; i < A.length; i++) {
			modifySegmentTree(root, A[i], 1);
		}
		for (int i = 0; i < queries.length; i++) {
			res = 0;
			if (queries[i] > 0)
				res = querySegmentTree(root, 0, queries[i] - 1);
			ans.add(res);
		}
		return ans;
	}

	public static void main(String[] args) {
		CountOfSmallerNumber count = new CountOfSmallerNumber();
		System.out.println(count.countOfSmallerNumber(new int[]{1,2,7,8,5}, new int[]{1,8,5}));
	}
	
	/**
	 * 
	 * Just Loop
	 * 
	 public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
		// write your code here
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (A == null || queries == null || queries.length == 0)
			return res;
		if (A.length == 0) {
			for (int i = 0; i < queries.length; i++) {
				res.add(0);
			}
			return res;
		}
			
		Arrays.sort(A);
		
		for (int q : queries) {
			int cnt = 0;
			for (int i = 0; i < A.length; i++) {
				if (q > A[i])
					cnt++;
				else
					break;
			}
			res.add(cnt);
		}
		
		return res;
	}
	 * 
	 */
	
	/**
	 * 
	 * Sort and Binary Search
	 * 
	public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
		// write your code here
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (A == null || queries == null || queries.length == 0)
			return res;
		if (A.length == 0) {
			for (int i = 0; i < queries.length; i++) {
				res.add(0);
			}
			return res;
		}
			
		Arrays.sort(A);
		
		for (int q : queries) {
			int left = 0;
			int right = A.length - 1;
			int count = 0;
			while (left < right) {
				int mid = (left + right) / 2;
				if (A[mid] > q) {
					count = mid;
					right = mid;
				} else if (A[mid] < q) {
					left = mid + 1;
					count = left;
				} else {
					count = mid;
					break;
				}
			}
			for (int i = count - 1; i >= 0; i--) {
				if (A[count] == A[i])
					count--;
				else
					break;
			}
			res.add(count);
		}
		
		return res;
	}
	 * 
	 */
}