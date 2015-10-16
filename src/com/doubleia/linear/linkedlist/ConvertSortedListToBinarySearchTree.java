package com.doubleia.linear.linkedlist;

/**
 * 
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 *                   2
 *  1->2->3  =>   / \
 *                 1  3
 * 
 * @author wangyingbo
 *
 */
public class ConvertSortedListToBinarySearchTree {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
	public TreeNode sortedListToBST(ListNode head) {
		// write your code here
		TreeNode res = null;
		if (head == null)
			return res;
		return createTree(res, head);
	}
	
	private TreeNode createTree(TreeNode tree, ListNode head) {
		ListNode pre = midListNode(head);
		if (pre == null) 
			return null;
		if (pre.next == null)
			return new TreeNode(pre.val);
		ListNode mid = pre.next;
		tree = new TreeNode(mid.val);
		ListNode post = mid.next;
		pre.next = null;
		TreeNode left = createTree(tree, head);
		TreeNode right = createTree(tree, post);
		tree.left = left;
		tree.right = right;
		return tree;
	}
	
	private ListNode midListNode(ListNode head) {
		if (head == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		ListNode mid = head;
		
		while (fast != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			mid = slow;
			slow = slow.next;
		}
		
		return mid;
	}
	
	public static void main(String[] args) {
		ConvertSortedListToBinarySearchTree convert = new ConvertSortedListToBinarySearchTree();
		ListNode head = ListNode.createListNode("1->2->3->4->6->8->19");
		System.out.println(head);
		TreeNode.inorderTraversal(convert.sortedListToBST(head));
	}
}
