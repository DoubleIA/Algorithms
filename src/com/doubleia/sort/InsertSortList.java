package com.doubleia.sort;

/**
 * 
 * Sort a linked list using insertion sort.
 * 
 * @author wangyingbo
 *
 * Definition for ListNode. 
 * public class ListNode {
 * 	int val; 
 * 	ListNode next; 
 * 	ListNode(int val) { 
 * 		this.val = val;
 * 		this.next = null;
 * 		}
 * }
 */
public class InsertSortList {
	/**
	 * @param head : The first node of linked list.
	 * @return: The head of linked list.
	 */
	public ListNode insertionSortList(ListNode head) {
		// write your code here
		if (head == null || head.next == null)
			return head;
		
		ListNode index = head;
		while (head.next != null) {
			ListNode curr = head;
			int temp = curr.val;
			while(curr.val > index.next.val && index.next != null) {
				curr.val = index.next.val;
				index = index.next;
				curr = curr.next;
			}
			index.val = temp;
		}
		return null;
	}
}
