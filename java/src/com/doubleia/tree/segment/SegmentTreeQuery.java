package com.doubleia.tree.segment;

/**
 * 
 * For an integer array (index from 0 to n-1, where n is the size of this array), in the corresponding SegmentTree, 
 * each node stores an extra attribute max to denote the maximum number in the interval of the array (index from start to end).
 * 
 * Design a query method with three parameters root, start and end, find the maximum number in the interval [start, end] by the given root of segment tree.
 * 
 * Given [1,4,2,3]. The segment tree will be:
 * 
 *                        [0,  3] (max = 4)
 *                                  /                  \
 *         [0,  1] (max = 4)              [2, 3]  (max = 3)
 *                /            \                           /             \
 * [0, 0](max = 1)  [1, 1](max = 4)  [2, 2](max = 2) [3, 3] (max = 3)
 * 
 * query(root, 1, 1), return 4
 * query(root, 1, 2), return 4
 * query(root, 2, 3), return 3
 * query(root, 0, 2), return 4
 * 
 * It is much easier to understand this problem if you finished Segment Tree Build first. 
 * 
 * @author wangyingbo
 *
 */
public class SegmentTreeQuery {
	/**
	 * @param root, start, end: The root of segment tree and an segment / interval
	 * @return: The maximum number in the interval [start, end]
	 */
	public int query(SegmentTreeNode root, int start, int end) {
		// write your code here
		if (start > end)
			return Integer.MIN_VALUE;
		if (start < root.start)
			start = root.start;
		if (end > root.end)
			end = root.end;
		
		if (start == root.start && end == root.end)
			return root.max;
		
		int mid = (root.start + root.end) / 2;
		if (start > mid)
			return query(root.right, start, end);
		else if (end <= mid)
			return query(root.left, start, end);
		else
			return Math.max(query(root.left, start, mid), query(root.right, mid + 1, end));
	}
	
	public static void main(String[] args) {
		SegmentTreeBuildII builder = new SegmentTreeBuildII();
		SegmentTreeNode root = builder.build(new int[]{1,4,2,3});
		SegmentTreeBuildII.printSegmentTree(root);
		SegmentTreeQuery query = new SegmentTreeQuery();
		System.out.println(query.query(root, 0, 3));
	}
}
