package com.doubleia.tree.segment;

import java.util.ArrayList;

/**
 * 
 * Give you an integer array (index from 0 to n-1, where n is the size of this array, value from 0 to 10000) . 
 * For each element Ai in the array, count the number of element before this element Ai is smaller than it 
 * and return count number array.
 * 
 * For array [1,2,7,8,5], return [0,1,2,3,2]
 * 
 * @author wangyingbo
 *
 */
public class CountOfSmallerNumberBeforeItself {
	/**
	 * @param A : An integer array
	 * @return: Count the number of element before this element 'ai' is smaller
	 *          than it and return count number array
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
	
	public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
		// write your code here
		root = build(0, 10000);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int res;
		for (int i = 0; i < A.length; i++) {
			modifySegmentTree(root, A[i], 1);
			res = 0;
			if (A[i] > 0)
				res = querySegmentTree(root, 0, A[i] - 1);
			ans.add(res);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		CountOfSmallerNumberBeforeItself count = new CountOfSmallerNumberBeforeItself();
		System.out.println(count.countOfSmallerNumberII(new int[]{1,2,7,8,5}));
	}

}
