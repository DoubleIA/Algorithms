package com.doubleia.linear.linkedlist;

/**
 * 
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Given 1->2->3->3->4->5->3, val = 3, you should return the list as 1->2->4->5
 * 
 * @author wangyingbo
 *
 */
public class RemoveLinkedListElements {
    /**
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     */
	public ListNode removeElements(ListNode head, int val) {
		// Write your code here
		while (head != null) {
			if (head.val == val)
				head = head.next;
			else
				break;
		}
		ListNode temp = head;
		ListNode pre = new ListNode(0);
		pre.next = head;
		while (temp != null) {
			if (temp.val == val) {
				ListNode tmp = temp.next;
				pre.next = tmp;
				temp = tmp;
			} else {
				temp = temp.next;
				pre = pre.next;
			}
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		RemoveLinkedListElements rm = new RemoveLinkedListElements();
		System.out.println(rm.removeElements(ListNode.createListNode("1->1"), 1));
	}
}
