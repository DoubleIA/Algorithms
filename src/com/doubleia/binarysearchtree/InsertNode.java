package com.doubleia.binarysearchtree;

/**
 * 
 * Given a binary search tree and a new tree node, insert the node into the tree. 
 * You should keep the tree still be a valid binary search tree.
 * 
 * Given binary search tree as follow, after Insert node 6, the tree should be:
 * 
 **     2             2
 **    / \           / \
 **   1   4   -->   1   4
 **  /             / \ 
 ** 3             3   6
 *
 * Can you do it without recursion?
 * 
 * @author wangyingbo
 *
 */
public class InsertNode {
	/**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public static TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
    	if (node == null)
    		return root;
    	if (root == null)
    		return node;
    	
    	TreeNode curr = root;
    	TreeNode parent = null;
    	int val = node.val;
    	
    	while (curr != null) {
    		parent = curr;
    		if (curr.val > val)
    			curr = curr.left;
    		else
    			curr = curr.right;
    	}
    	
    	if (parent == null) {
    		root = node;
    	} else if (parent.val > val) {
    		parent.left = node;
    	} else {
    		parent.right = node;
    	}
    	
    	
    	return root;
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(6);
		TreeNode c1 = new TreeNode(2);
		TreeNode c2 = new TreeNode(9);
		TreeNode c3 = new TreeNode(1);
		TreeNode c4 = new TreeNode(4);
		TreeNode c5 = new TreeNode(3);
//		TreeNode c6 = new TreeNode(3);
//		TreeNode c7 = new TreeNode(5);
		root.left = c1;
		root.right = c2;
		c1.left = c3;
		c1.right = c4;
//		c2.left = c5;
//		c4.left = c6;
//		c4.right = c7;
		
		BinarySearchTree.inorderMorrisTraversal(root);
		TreeNode res = InsertNode.insertNode(root, c5);
		BinarySearchTree.preorderMorrisTraversal(res);
		BinarySearchTree.inorderMorrisTraversal(res);
		
	}
}
