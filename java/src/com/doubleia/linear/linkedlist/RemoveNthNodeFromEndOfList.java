package com.doubleia.linear.linkedlist;

/**
 * 
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * Given linked list: 1->2->3->4->5->null, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5->null.
 * 
 * The minimum number of nodes in list is n.
 * 
 * O(n) time
 * 
 * @author wangyingbo
 *
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
	ListNode removeNthFromEnd(ListNode head, int n) {
		// write your code here
		if (head == null)
			return head;
		
		ListNode post = head;
		for (int i = 0; i < n; i++) {
			post = post.next;
		}
		
		if (post == null)
			return head.next;
		
		ListNode pre = head;
		while (post.next != null) {
			post = post.next;
			pre = pre.next;
		}
		
		ListNode tmp = pre.next;
		
		if (tmp != null) {
			tmp = tmp.next;
			pre.next.next = null;
			pre.next = tmp;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		RemoveNthNodeFromEndOfList rm = new RemoveNthNodeFromEndOfList();
		System.out.println(rm.removeNthFromEnd(ListNode.createListNode("1"), 0));
	}
}
