package com.doubleia.linear.linkedlist;

/**
 * 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Given -21->10->4->5, tail connects to node index 1，return 10
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * 
 * @author wangyingbo
 *
 */
public class LinkedListCycleII {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
	public ListNode detectCycle(ListNode head) {
		// write your code here
		if (head == null || head.next == null)
			return null;
		if (head.next == head)
			return head;
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast != null && fast.next != null) {
			if (slow == fast && slow != head) {
				while (slow != head) {
	    			slow = slow.next;
	    			head = head.next;
			    }
				return head;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return null;
	}
	
	
	public static void main(String[] args) {
		LinkedListCycleII cycle = new LinkedListCycleII();
		ListNode pre = ListNode.createListNode("-21->10->17->8->4->26->5->35->33->-7->-16->27->-12->6->29->-12->5->9->20->14->14->2->13->-24");
		ListNode post = ListNode.createListNode("21->23->-21->5");
		post.end().next = pre.end();
		pre.end().next = post;
		ListNode res = cycle.detectCycle(pre);
		System.out.println(res.val);
	}
}
