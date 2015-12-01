package com.doubleia.tree.segment;

/**
 * 
 * For a Maximum Segment Tree, which each node has an extra value max to store the maximum value in this node's interval.
 * 
 * Implement a modify function with three parameter root, index and value to change the node's value with [start, end] = [index, index] to the new given value. 
 * Make sure after this change, every node in segment tree still has the max attribute with the correct value.
 * 
 * For segment tree:  
 * 
 *                       [1, 4, max=3]
 *                              /                 \
 *          [1, 2, max=2]             [3, 4, max=3]
 *                 /         \                       /         \
 *   [1, 1, max=2], [2, 2, max=1],[3, 3, max=0], [4, 4, max=3]
 *
 * if call modify(root, 2, 4), we can get:
 * 
 *                       [1, 4, max=4]
 *                              /                 \
 *          [1, 2, max=4]             [3, 4, max=3]
 *                 /         \                       /         \
 *   [1, 1, max=2], [2, 2, max=4],[3, 3, max=0], [4, 4, max=3]
 * 
 * or call modify(root, 4, 0), we can get:
 * 
 *                       [1, 4, max=2]
 *                              /                 \
 *          [1, 2, max=2]             [3, 4, max=0]
 *                 /         \                       /         \
 *   [1, 1, max=2], [2, 2, max=1],[3, 3, max=0], [4, 4, max=0]
 * 
 * We suggest you finish problem Segment Tree Build and Segment Tree Query first.
 * 
 * Do it in O(h) time, h is the height of the segment tree.
 * 
 * @author wangyingbo
 *
 */
public class SegmentTreeModify {
	/**
	 * @param root, index, value: The root of segment tree and @ change the
	 *            node's value with [index, index] to the new given value
	 * @return: void
	 */
	public void modify(SegmentTreeNode root, int index, int value) {
		// write your code here
		if (root == null || root.end < index || root.start > index)
			return;
		maximum(root, index, value);
	}

	private int maximum(SegmentTreeNode root, int index, int value) {
		if (root.start == root.end && root.start == index) {
			root.max = value;
			return value;
		}
		if ((root.start + root.end) / 2 >= index) {
			if (root.right != null)
				root.max = Math.max(maximum(root.left, index, value), root.right.max);
			else
				root.max = maximum(root.left, index, value);
		} else {
			if (root.left != null)
				root.max = Math.max(root.left.max, maximum(root.right, index, value));
			else
				root.max = maximum(root.right, index, value);
		}
		return root.max;
	}
	
	public static void main(String[] args) {
		SegmentTreeBuildII builder = new SegmentTreeBuildII();
		SegmentTreeNode root = builder.build(new int[]{3,2,1,4});
		SegmentTreeBuildII.printSegmentTree(root);
		SegmentTreeModify mod = new SegmentTreeModify();
		mod.modify(root, 2, 5);
		System.out.println("========================");
		SegmentTreeBuildII.printSegmentTree(root);
	}
	
}
