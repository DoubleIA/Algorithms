package com.doubleia.linear.linkedlist;

/**
 * 
 *  Given a sorted linked list, delete all duplicates such that each element appear only once. 
 *  
 *  Given 1->1->2, return 1->2.
 *  Given 1->1->2->3->3, return 1->2->3. 
 * 
 * @author wangyingbo
 *
 */
public class RemoveDuplicatesFromSortedList {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
	public static ListNode deleteDuplicates(ListNode head) {
		// write your code here
		if (head == null || head.next == null)
			return head;
		ListNode curr = head;
		ListNode pre = head;
		
		while (curr != null) {
			while (curr != null && pre.val == curr.val) {
				curr = curr.next;
			}
			pre.next = curr;
			pre = curr;
			if (curr != null)
				curr = curr.next;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		System.out.println(RemoveDuplicatesFromSortedList.deleteDuplicates(ListNode.createListNode("1->1->1")));
	}
}
