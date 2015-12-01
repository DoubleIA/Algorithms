package com.doubleia.tree.segment;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * The structure of Segment Tree is a binary tree which each node has two attributes start and end denote an segment / interval.
 * start and end are both integers, they should be assigned in following rules:
 * 
 * The root's start and end is given by build method.
 * The left child of node A has start=A.left, end=(A.left + A.right) / 2.
 * The right child of node A has start=(A.left + A.right) / 2 + 1, end=A.right.
 * if start equals to end, there will be no children for this node.
 * 
 * Implement a build method with a given array, so that we can create a corresponding segment tree 
 * with every node value represent the corresponding interval max value in the array, return the root of this segment tree.
 * 
 * Given [3,2,1,4]. The segment tree will be:
 * 
 *                        [0,  3] (max = 4)
 *                                  /                  \
 *         [0,  1] (max = 3)              [2, 3]  (max = 4)
 *                /            \                           /             \
 * [0, 0](max = 3)  [1, 1](max = 2)  [2, 2](max = 1) [3, 3] (max = 4)
 * 
 * @author wangyingbo
 * 
 */
public class SegmentTreeBuildII {
	/**
	 * @param A : a list of integer
	 * @return: The root of Segment Tree
	 */
	public SegmentTreeNode build(int[] A) {
		// write your code here
		if (A == null || A.length == 0)
			return null;
		SegmentTreeNode root = build(0, A.length - 1, A);
		maximum(root);
		return root;
	}
	
	private SegmentTreeNode build(int start, int end, int[] A) {
		if (start > end)
			return null;
		if (start == end)
			return new SegmentTreeNode(start, end, A[start]);
		SegmentTreeNode root = new SegmentTreeNode(start, end, Integer.MIN_VALUE);
		int mid = (start + end) / 2;
		root.left = build(start, mid, A);
		root.right = build(mid + 1, end, A);
		return root;
	}
	
	private int maximum(SegmentTreeNode root) {
		if (root == null)
			return Integer.MIN_VALUE;
		if (root.left != null && root.right != null) {
			root.max = Math.max(maximum(root.left), maximum(root.right));
			return root.max;
		} else if (root.left != null) {
			root.left.max = maximum(root.left);
			return root.left.max;
		} else if (root.right != null) {
			root.right.max = maximum(root.right);
			return root.right.max;
		} else {
			return root.max;
		}
	}
	
	public static void printSegmentTree(SegmentTreeNode root) {
		Queue<SegmentTreeNode> q1 = new LinkedList<SegmentTreeNode>();
		Queue<SegmentTreeNode> q2 = new LinkedList<SegmentTreeNode>();
		q1.add(root);
		while (!q1.isEmpty() || !q2.isEmpty()) {
			if (q1.isEmpty()) {
				while (!q2.isEmpty()) {
					SegmentTreeNode curr = q2.poll();
					if (curr.left != null) {
						q1.add(curr.left);
					} else if (curr.start != 1 || curr.end != -1){
						q1.add(new SegmentTreeNode(1, -1));
					}
					if (curr.right != null) {
						q1.add(curr.right);
					} else if (curr.start != 1 || curr.end != -1) {
						q1.add(new SegmentTreeNode(1, -1));
					}
					if (curr.start == 1 && curr.end == -1) {
						System.out.print("null ");
					} else {
						System.out.print("["+curr.start+", "+curr.end+"](max = "+curr.max+") ");
					}
				}
			} else {
				while (!q1.isEmpty()) {
					SegmentTreeNode curr = q1.poll();
					if (curr.left != null) {
						q2.add(curr.left);
					} else if (curr.start != 1 || curr.end != -1){
						q2.add(new SegmentTreeNode(1, -1));
					}
					if (curr.right != null) {
						q2.add(curr.right);
					} else if (curr.start != 1 || curr.end != -1) {
						q2.add(new SegmentTreeNode(1, -1));
					}
					if (curr.start == 1 && curr.end == -1) {
						System.out.print("null ");
					} else {
						System.out.print("["+curr.start+", "+curr.end+"](max = "+curr.max+") ");
					}
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		SegmentTreeBuildII builder = new SegmentTreeBuildII();
		SegmentTreeNode root = builder.build(new int[]{3,2,1,4});
		printSegmentTree(root);
	}
}
