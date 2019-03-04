package com.doubleia.linear.linkedlist;

/**
 * 
 * Find the nth to last element of a singly linked list. 
 * 
 * The minimum number of nodes in list is n.
 * 
 * Given a List  3->2->1->5->null and n = 2, return node  whose value is 1.
 * 
 * @author wangyingbo
 *
 */
public class NthToLastNodeInList {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
	ListNode nthToLast(ListNode head, int n) {
		// write your code here
		int len = 0;
		ListNode res = head;
		
		while (res != null) {
			res = res.next;
			len++;
		}
		
		if (n > len || n <= 0)
			return null;
		
		res = head;
		while (len > n) {
			res = res.next;
			len--;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		NthToLastNodeInList nth = new NthToLastNodeInList();
		ListNode res = nth.nthToLast(ListNode.createListNode("-14->-13->-11->-6->-2->22->23->24->null"), 3);
		System.out.println(res == null ? null : res.val);
	}
}
