package com.doubleia.tree.binarysearchtree;

/**
 * 
 * Given a root of Binary Search Tree with unique value for each node.  
 * Remove the node with given value. If there is no such a node 
 * with given value in the binary search tree, do nothing. 
 * You should keep the tree still a binary search tree after removal.
 * 
 * Given binary search tree:
 * 
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 * 
 * Remove 3, you can either return:
 * 
 *       5           5  
 *      / \         / \
 *     2   6  or   4   6
 *      \         /
 *       4       2
 * 
 * @author wangyingbo
 *
 */
public class RemodeNode {
	 /**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public static TreeNode removeNode(TreeNode root, int value) {
        // write your code here
    	TreeNode curr = root;
    	TreeNode pre = null;
    	
    	while (curr != null) {
    		if (curr.val == value) {
    			TreeNode temp = curr.right;
    			if (pre != null) {
    				if (temp == null) {
    					if (pre.val > curr.val) {
    						pre.left = curr.left;
    					} else {
    						pre.right = curr.left;
    					}
    					return root;
    				} else {
    					if (pre.val > curr.val) {
	    					pre.left = curr.right;
    					} else {
    						pre.right = curr.right;
    					}
    					while (true) {
    						if (temp.left != null)
    							temp = temp.left;
    						else {
    							temp.left = curr.left;
    							return root;
    						}
    					}
    				}
    			} else {
    				if (temp == null)
    					return curr.left;
    				else
    					while (true) {
	    					if (temp.left != null)
	    						temp = temp.left;
	    					else {
	    						temp.left = curr.left;
	    						return curr.right;
	    					}
    					}
    			}
    		} else if(curr.val > value) {
    			pre = curr;
    			curr = curr.left;
    		} else {
    			pre = curr;
    			curr = curr.right;
    		}
    			
    	}
    	
    	return root;
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
		TreeNode res = RemodeNode.removeNode(root, 9);
		BinarySearchTree.preorderMorrisTraversal(res);
		BinarySearchTree.inorderMorrisTraversal(res);
	}
    
}
