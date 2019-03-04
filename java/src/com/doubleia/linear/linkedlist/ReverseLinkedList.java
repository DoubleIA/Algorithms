package com.doubleia.linear.linkedlist;

/**
 * 
 * Reverse a linked list.
 * 
 * For linked list 1->2->3, the reversed linked list is 3->2->1
 * 
 * Reverse it in-place and in one-pass
 * 
 * @author wangyingbo
 *
 */
public class ReverseLinkedList {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
	public ListNode reverse(ListNode head) {
		// write your code here
		if (head == null || head.next == null)
			return head;
		
		ListNode curr = head.next;
		ListNode pre = head;
		while (curr != null) {
			ListNode tmp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = tmp;
		}
		head.next = null;
		return pre;
	}
	
	public static void main(String[] args) {
		ReverseLinkedList rev = new ReverseLinkedList();
		System.out.println(rev.reverse(ListNode.createListNode("1->2->3->4->null")));
	}
}
