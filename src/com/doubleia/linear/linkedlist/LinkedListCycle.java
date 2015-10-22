package com.doubleia.linear.linkedlist;

/**
 * 
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Given -21->10->4->5, tail connects to node index 1, return true
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * @author wangyingbo
 *
 */
public class LinkedListCycle {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
	public boolean hasCycle(ListNode head) {
		// write your code here
		boolean res = false;
		if (head == null || head.next == null)
			return res;
		
		ListNode fast = head.next;
		
		while (fast != null && fast.next != null) {
			if (fast == head)
				return true;
			head = head.next;
			fast = fast.next.next;
		}
		
		return res;
	}
}
