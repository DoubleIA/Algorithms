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
 * Implement a build method with two parameters start and end, so that we can create a corresponding segment tree 
 * with every node has the correct start and end value, return the root of this segment tree.
 * 
 * Given start=0, end=3. The segment tree will be:
 * 
 *                 [0,  3]
 *                /       \
 *         [0,  1]         [2, 3]
 *         /     \         /     \
 *     [0, 0]  [1, 1]   [2, 2]  [3, 3]
 *
 * Given start=1, end=6. The segment tree will be:
 * 
 *                [1,  6]
 *               /       \
 *        [1,  3]         [4,  6]
 *        /     \         /     \
 *    [1, 2]  [3,3]   [4, 5]   [6,6]
 *    /    \          /     \
 * [1,1]   [2,2]   [4,4]   [5,5]
 * 
 * Clarification : 
 * 
 * Segment Tree (a.k.a Interval Tree) is an advanced data structure which can support queries like:
 * 
 * which of these intervals contain a given point
 * which of these points are in a given interval
 * 
 * @author wangyingbo
 *
 */
public class SegmentTreeBuild {
	/**
	 * @param start
	 *            , end: Denote an segment / interval
	 * @return: The root of Segment Tree
	 */
	public SegmentTreeNode build(int start, int end) {
		// write your code here
		if (start > end)
			return null;
		if (start == end)
			return new SegmentTreeNode(start, end);
		SegmentTreeNode root = new SegmentTreeNode(start, end);
		int mid = (start + end) / 2;
		root.left = build(start, mid);
		root.right = build(mid + 1, end);
		return root;
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
						System.out.print("["+curr.start+", "+curr.end+"] ");
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
						System.out.print("["+curr.start+", "+curr.end+"] ");
					}
				}
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		SegmentTreeBuild builder = new SegmentTreeBuild();
		SegmentTreeNode root = builder.build(1, 6);
		printSegmentTree(root);
	}
}
