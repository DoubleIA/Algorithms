package com.doubleia.tree.segment;

/**
 * 
 * Given an integer array in the construct method, implement two methods query(start, end) and modify(index, value):
 * 
 * For query(start, end), return the sum from index start to index end in the given array.
 * For modify(index, value), modify the number in the given index to value
 * 
 * Given array A = [1,2,7,8,5].
 * query(0, 2), return 10.
 * modify(0, 4), change A[0] from 1 to 4.
 * query(0, 1), return 6.
 * modify(2, 1), change A[2] from 7 to 1.
 * query(2, 4), return 14.
 * 
 * O(logN) time for query and modify.
 * 
 * @author wangyingbo
 *
 */
public class IntervalSumII {
	
	private SegmentTreeNode root = null;
	
	/**
	 * @param A : An integer array
	 */
	public IntervalSumII(int[] A) {
		// write your code here
		root = build(A);
	}

	/**
	 * @param start, end: Indices
	 * @return: The sum from start to end
	 */
	public long query(int start, int end) {
		// write your code here
		return query(root, start, end);
	}

	/**
	 * @param index, value: modify A[index] to value.
	 */
	public void modify(int index, int value) {
		// write your code here
		summary(root, index, value);
	}
	
	private long query(SegmentTreeNode root, int start, int end) {
		if (start > end || root == null)
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
	
	private long summary(SegmentTreeNode root, int index, int value) {
		if (root == null || index < root.start || index > root.end)
			return 0l;
		if (root.start == root.end && root.start == index) {
			root.sum = value;
			return (long)value;
		}
		int mid = (root.start + root.end) / 2;
		if (index <= mid) {
			if (root.right != null) 
				root.sum = root.right.sum + summary(root.left, index, value);
			else 
				root.sum = summary(root.left, index, value);
		} else {
			if (root.left != null)
				root.sum = root.left.sum + summary(root.right, index, value);
			else
				root.sum = summary(root.right, index, value);
		}
		return root.sum;
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
		if (root == null)
			return 0l;
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
	
	/*
	  * query(0, 2), return 10.
	  * modify(0, 4), change A[0] from 1 to 4.
	  * query(0, 1), return 6.
	  * modify(2, 1), change A[2] from 7 to 1.
	  * query(2, 4), return 14.
	 */
	public static void main(String[] args) {
		IntervalSumII inter = new IntervalSumII(new int[]{});
		System.out.println(inter.query(0, 2));
		inter.modify(0, 4);
		System.out.println(inter.query(0, 1));
		inter.modify(2, 1);
		System.out.println(inter.query(2, 4));
	}
}
