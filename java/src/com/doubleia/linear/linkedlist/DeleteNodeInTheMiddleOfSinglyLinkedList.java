package com.doubleia.linear.linkedlist;

/**
 * 
 * Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
 * 
 * Given 1->2->3->4, and node 3. return 1->2->4
 * 
 * @author wangyingbo
 *
 */
public class DeleteNodeInTheMiddleOfSinglyLinkedList {
    /**
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
	public void deleteNode(ListNode node) {
		// write your code here
		if (node == null)
			return;
		if (node.next == null)
			node = null;
		ListNode tmp = node.next.next;
		node.val = node.next.val;
		node.next.next = null;
		node.next = tmp;
	}
}
