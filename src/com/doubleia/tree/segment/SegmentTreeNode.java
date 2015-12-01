package com.doubleia.tree.segment;

public class SegmentTreeNode {
	public int start, end, max;
	public SegmentTreeNode left, right;
	public SegmentTreeNode(int start, int end) {
		this.start = start;
		this.end = end;
		this.max = 0;
		this.left = this.right = null;
	}
	public SegmentTreeNode(int start, int end, int max) {
		this.start = start;
		this.end = end;
		this.max = max;
		this.left = this.right = null;
	}
}
