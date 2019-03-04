package com.doubleia.linear.linkedlist;

/**
 * 
 * Merge two sorted (ascending) linked lists and return it as a new sorted list. 
 * The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.
 * 
 * Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.
 * 
 * @author wangyingbo
 *
 */
public class MergeTwoSortedLists {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// write your code here
		ListNode res = new ListNode(-1);
		ListNode curr = res;
		
		while (l1 != null || l2 != null) {
			if (l1 == null) {
				curr.next = l2;
				break;
			}else if (l2 == null) {
				curr.next = l1;
				break;
			} else {
				if (l1.val <= l2.val) {
					curr.next = l1;
					curr = curr.next;
					l1 = l1.next;
				} else {
					curr.next = l2;
					curr = curr.next;
					l2 = l2.next;
				}
			}
		}
		
		return res.next;
	}
	
	public static void main(String[] args) {
		MergeTwoSortedLists merge = new MergeTwoSortedLists();
		System.out.println(merge.mergeTwoLists(ListNode.createListNode("1->3->8->11->15->null"), ListNode.createListNode("2->null")));
	}
}
