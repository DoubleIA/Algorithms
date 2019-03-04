package com.doubleia.linear.linkedlist;

/**
 * 
 * You have two numbers represented by a linked list, where each node contains a single digit. 
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list. 
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * 
 * Given 7->1->6 + 5->9->2. That is, 617 + 295.
 * Return 2->1->9. That is 912.
 * Given 3->1->5 and 5->9->2, return 8->0->8.
 * 
 * @author wangyingbo
 *
 */
public class AddTwoNumbers {
	/**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
	public ListNode addLists(ListNode l1, ListNode l2) {
		// write your code here
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		
		int cnt = 0;
		ListNode res = null;
		
		if (l1.val + l2.val >= 10) {
			res = new ListNode((l1.val + l2.val) % 10);
			cnt = 1;
		} else {
			res = new ListNode(l1.val + l2.val);
		}
		l1 = l1.next;
		l2 = l2.next;
		
		ListNode curr = res;
		while (l1 != null || l2 != null) {
			if (l1 == null) {
				if (l2.val + cnt >= 10) {
					curr.next = new ListNode((l2.val + cnt) % 10);
					cnt = 1;
				} else {
					curr.next = new ListNode(l2.val + cnt);
					cnt = 0;
				}
				curr = curr.next;
				l2 = l2.next;
			} else if (l2 == null) {
				while (l1 != null) {
					if (l1.val + cnt >= 10) {
						curr.next = new ListNode((l1.val + cnt) % 10);
						cnt = 1;
					} else {
						curr.next = new ListNode(l1.val + cnt);
						cnt = 0;
					}
					curr = curr.next;
					l1 = l1.next;
				}
			} else {
				if (l1.val + l2.val + cnt >= 10) {
					curr.next = new ListNode((l1.val + l2.val + cnt) % 10);
					cnt = 1;
				} else {
					curr.next = new ListNode(l1.val + l2.val + cnt);
					cnt = 0;
				}
				curr = curr.next;
				l1 = l1.next;
				l2 = l2.next;
			}
		}
		
		if (cnt == 1)
			curr.next = new ListNode(cnt);
		
		return res;
	}
	
	public static void main(String[] args) {
		ListNode l1 = ListNode.createListNode(new int[]{3, 1, 7, 9});
		ListNode l2 = ListNode.createListNode(new int[]{5, 9, 2, 4});
		AddTwoNumbers add = new AddTwoNumbers();
		add.addLists(l1, l2);
		System.out.println(add.addLists(l1, l2));
	}
}
