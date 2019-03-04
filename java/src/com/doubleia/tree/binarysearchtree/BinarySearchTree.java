package com.doubleia.tree.binarysearchtree;

import java.util.Stack;
import java.util.Vector;

public class BinarySearchTree {
	
	public static Vector<Integer> preorderTraversal(TreeNode root) {
		Vector<Integer> vector = new Vector<Integer>();
		
		if (root == null)
			return vector;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			vector.add(temp.val);
			if (temp.right != null)
				stack.push(temp.right);
			if (temp.left != null)
				stack.push(temp.left);
		}
		
		return vector;
	}
	
	
	public static Vector<Integer> inorderTraversal(TreeNode root) {
		Vector<Integer> vector = new Vector<Integer>();
		
		if (root == null)
			return vector;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp = root;
		
		while (temp != null) {
			stack.push(temp);
			temp = temp.left;
		}
		
		while (!stack.isEmpty()) {
			temp = stack.pop();
			vector.add(temp.val);
			if (temp.right != null) {
				temp = temp.right;
				stack.push(temp);
				while (temp.left != null) {
					temp = temp.left;
					stack.push(temp);
				}
			}
		}
		
		return vector;
	}
	
	
	public static Vector<Integer> postorderTraversal(TreeNode root) {
		Vector<Integer> vector = new Vector<Integer>();
		
		if (root == null)
			return vector;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Integer> sign = new Stack<Integer>();
		TreeNode temp = root;

		while (temp != null) {
			stack.push(temp);
			sign.push(0);
			temp = temp.left;
		}
		
		int right;
		while (!stack.isEmpty()) {
			temp = stack.peek();
			right = sign.peek();
			if (temp.right != null && right == 0) {
				sign.pop();
				sign.push(1);
				temp = temp.right;
				while (temp != null) {
					stack.push(temp);
					sign.push(0);
					temp = temp.left;
				}
			} else {
				sign.pop();
				stack.pop();
				vector.add(temp.val);
			}
		}
		
		return vector;
	}
	
	
	// O(1) Space: Morris Traversal(use threaded binary tree)
	
	/**
	 * 
	 * 1、如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。
	 * 2、如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
	 **   a、如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。输出当前节点。当前节点更新为当前节点的左孩子。
	 **   b、如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。当前节点更新为当前节点的右孩子。
	 * 3. 重复以上1、2直到当前节点为空。
	 * 
	 * @param root
	 */
	public static void preorderMorrisTraversal(TreeNode root) {
		TreeNode curr = root;
		TreeNode pre = null;
		StringBuilder builder = new StringBuilder("pre: [");
		
		while (curr != null) {
			if (curr.left == null) {
				builder.append(curr.val).append(", ");
				curr = curr.right;
			} else {
				pre = curr.left;
				while (pre.right != null && pre.right != curr)
					pre = pre.right;
				if (pre.right == null) {
					pre.right = curr;
					builder.append(curr.val).append(", ");
					curr = curr.left;
				} else {
					pre.right = null;
					curr = curr.right;
				}
			}
		}
		
		if (builder.length() > 6)
			builder.setLength(builder.length() - 2);
		builder.append("]");
		System.out.println(builder.toString());
	}
	
	
	/**
	 * 
	 * 1、如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。
	 * 2、如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
	 **   a、如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
	 **   b、如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。输出当前节点。当前节点更新为当前节点的右孩子。
	 * 3. 重复以上1、2直到当前节点为空。
	 * 
	 * @param root
	 */
	public static void inorderMorrisTraversal(TreeNode root) {
		TreeNode curr = root;
		TreeNode pre = null;
		StringBuilder builder = new StringBuilder("in: [");
		
		while (curr != null) {
			if (curr.left == null) {
				builder.append(curr.val).append(", ");
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
					builder.append(curr.val).append(", ");
					curr = curr.right;
				}
			}
		}
		
		if (builder.length() > 5)
			builder.setLength(builder.length() - 2);
		builder.append("]");
		System.out.println(builder.toString());
	}
	
	
	/**
	 * 
	 * 后续遍历比较复杂，需要建立一个临时节点dump，令其左孩子是root。
	 * 并且还需要一个子过程，倒序输出某两个节点之间路径上的各个节点。
	 * 
	 * 1、如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。
	 * 2、如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
	 **   a、如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
	 **   b、如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。
	 **	c、倒序输出从当前节点的左孩子到该前驱节点这条路径上的所有节点。当前节点更新为当前节点的右孩子。
	 * 3. 重复以上1、2直到当前节点为空。
	 * 
	 * @param root
	 */
	public static void postorderMorrisTraversal(TreeNode root) {
		TreeNode dump = new TreeNode(0);
		dump.left = root;
		TreeNode curr = dump;
		TreeNode pre = null;
		
		StringBuilder builder = new StringBuilder("post: [");
		
		while (curr != null) {
			if (curr.left == null) {
				curr = curr.right;
			} else {
				pre = curr.left;
				while (pre.right != null && pre.right != curr)
					pre = pre.right;
				if (pre.right == null) {
					pre.right = curr;
					curr = curr.left;
				} else {
					builder.append(reverseToString(curr.left, pre));
					pre.right = null;
					curr = curr.right;
				}
			}
		}
		
		if (builder.length() > 7)
			builder.setLength(builder.length() - 2);
		builder.append("]");
		System.out.println(builder.toString());
	}
	
	/**
	 * 
	 * 单链表反转
	 * 
	 * @param from
	 * @param to
	 */
	private static void reverse(TreeNode from, TreeNode to) {
		
		if (from == to)
			return;
		
		TreeNode curr = from;
		TreeNode post = curr.right;
		TreeNode temp;
		
		while (curr != to) {
			temp = post.right;
			post.right = curr;
			curr = post;
			post = temp;
		}
		
	}
	
	/**
	 * 
	 * 返回后序字符串
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	private static String reverseToString(TreeNode from, TreeNode to) {
		StringBuilder builder = new StringBuilder();
		reverse(from, to);
		
		TreeNode index = to;
		while (true) {
			builder.append(index.val).append(", ");
			if (index == from)
				break;
			index = index.right;
		}
		
		reverse(to, from);
		return builder.toString();
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
		Vector<Integer> vector = new Vector<Integer>();
		vector = BinarySearchTree.preorderTraversal(root);
		System.out.println("pre: " + vector);
		vector = BinarySearchTree.inorderTraversal(root);
		System.out.println("in: " + vector);
		vector = BinarySearchTree.postorderTraversal(root);
		System.out.println("post: " + vector);
		
		// O(1) Space: Morris Traversal(use threaded binary tree)
		BinarySearchTree.preorderMorrisTraversal(root);
		BinarySearchTree.inorderMorrisTraversal(root);
		BinarySearchTree.postorderMorrisTraversal(root);
	}
	
}
