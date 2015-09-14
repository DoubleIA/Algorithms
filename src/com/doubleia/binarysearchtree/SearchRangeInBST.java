package com.doubleia.binarysearchtree;

import java.util.ArrayList;

/**
 * 
 * Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. 
 * Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 
 * and x is a key of given BST. Return all the keys in ascending order.
 * 
 * If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].
 * 
 **     20
 **    /  \
 **   8   22
 **  / \
 ** 4   12
 * 
 * @author wangyingbo
 *
 */
public class SearchRangeInBST {

	/**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	TreeNode curr = root;
    	TreeNode pre = null;
    	
    	while (curr != null) {
    		if (curr.left == null) {
    			if (curr.val >= k1 && curr.val <= k2)
    				result.add(curr.val);
    			else if (curr.val > k2)
    				return result;
    			curr = curr.right;
    		} else {
    			pre = curr.left;
    			while (pre.right != null && pre.right != curr)
    				pre = pre.right;
    			if (pre.right == null) {
    				pre.right = curr;
    				curr = curr.left;
    			} else {
    				pre.right = null;
    				if (curr.val <= k2 && curr.val >= k1)
    					result.add(curr.val);
    				else if (curr.val > k2)
    					return result;
    				curr = curr.right;
    			}
    		}
    	}
    	
    	return result;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		TreeNode c1 = new TreeNode(2);
		TreeNode c2 = new TreeNode(9);
		TreeNode c3 = new TreeNode(1);
		TreeNode c4 = new TreeNode(4);
		TreeNode c5 = new TreeNode(8);
		TreeNode c6 = new TreeNode(3);
		TreeNode c7 = new TreeNode(5);
		root.left = c1;
		root.right = c2;
		c1.left = c3;
		c1.right = c4;
		c2.left = c5;
		c4.left = c6;
		c4.right = c7;
		BinarySearchTree.inorderMorrisTraversal(root);
		SearchRangeInBST ser = new SearchRangeInBST();
		ArrayList<Integer> al = ser.searchRange(root, -1, 10);
		System.out.println(al);
	}
}
