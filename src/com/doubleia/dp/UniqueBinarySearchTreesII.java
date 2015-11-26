package com.doubleia.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * 
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 
 *   1         3     3      2      1
 *    \       /     /      / \      \
 *     3     2     1      1   3      2
 *    /     /       \                 \
 *   2     1         2                 3
 * 
 * @author wangyingbo
 *
 */
public class UniqueBinarySearchTreesII {
    /**
     * @paramn n: An integer
     * @return: A list of root
     */
	public List<TreeNode> generateTrees(int n) {
		// write your code here
		return generate(0, n - 1);
	}
	
	private List<TreeNode> generate(int beg, int end) {
		List<TreeNode> trees = new ArrayList<TreeNode>();
		
		if (beg > end) {
			trees.add(null);
			return trees;
		}
		
		for (int i = beg; i <= end; i++) {
			List<TreeNode> leftTree = generate(beg, i - 1);
			List<TreeNode> rightTree = generate(i + 1, end);
			
			for (int j = 0; j < leftTree.size(); j++) {
				for (int k = 0; k < rightTree.size(); k++) {
					TreeNode node = new TreeNode(i + 1);
					node.left = leftTree.get(j);
					node.right = rightTree.get(k);
					trees.add(node);
				}
			}
			
		}
		
		return trees;
	}

	private static void printTrees(List<TreeNode> trees) {
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		
		for (TreeNode tree : trees) {
			q1.add(tree);
			TreeNode curr = null;
			while (q1.peek() != null || q2.peek() != null) {
				while (q1.peek() != null) {
					curr = q1.poll();
					
					if (curr.val != -1)
						System.out.print(curr.val + " ");
					else
						System.out.print("* ");
					
					if (curr.left != null)
						q2.add(curr.left);
					else if (curr.right != null)
						q2.add(new TreeNode(-1));
					
					if (curr.right != null)
						q2.add(curr.right);
					else if (curr.left != null)
						q2.add(new TreeNode(-1));
				}
				while (q2.peek() != null) {
					curr = q2.poll();
					
					if (curr.val != -1)
						System.out.print(curr.val + " ");
					else
						System.out.print("* ");
					
					if (curr.left != null)
						q1.add(curr.left);
					else if (curr.right != null)
						q1.add(new TreeNode(-1));
					
					if (curr.right != null)
						q1.add(curr.right);
					else if (curr.left != null)
						q1.add(new TreeNode(-1));
				}
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		UniqueBinarySearchTreesII uni = new UniqueBinarySearchTreesII();
		printTrees(uni.generateTrees(3));
	}
	
	/* For Test printTrees()
	TreeNode tree1 = new TreeNode(1);
	tree1.right = new TreeNode(3);
	tree1.right.left = new TreeNode(2);
	
	TreeNode tree2 = new TreeNode(3);
	tree2.left = new TreeNode(1);
	tree2.left.right = new TreeNode(2);
	
	trees.add(tree1);
	trees.add(tree2);*/
}
