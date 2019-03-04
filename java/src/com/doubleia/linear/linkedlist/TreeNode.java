package com.doubleia.linear.linkedlist;

import java.util.ArrayList;

public class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
	
	public static void inorderTraversal(TreeNode root) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		if (root == null) {
			System.out.println(arr);
			return;
		}
		
		TreeNode curr = root;
		TreeNode pre = null;
		while (curr != null) {
			if (curr.left == null) {
				arr.add(curr.val);
				curr = curr.right;
			} else {
				pre = curr.left;
				while (pre.right != null && pre.right != curr)
					pre = pre.right;
				if (pre.right == null) {
					pre.right = curr;
					curr = curr.left;
				} else {
					pre = null;
					arr.add(curr.val);
					curr = curr.right;
				}
			}
		}
		
		System.out.println(arr);
	}
}
