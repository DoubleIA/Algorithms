package com.doubleia.linear.linkedlist;

/**
 * 
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * The following two linked lists:
 * 
 *  A:           a1 → a2
 *                              ↘
 *                        c1 → c2 → c3
 *                              ↗            
 *  B:      b1 → b2 → b3
 * 
 * begin to intersect at node c1.
 * 
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * 
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * 
 * @author wangyingbo
 *
 */
public class IntersectionOfTwoLinkedLists {
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		// Write your code here
		if (headA == null || headB == null)
			return null;
		int len = 0;

		ListNode res = headA;
		while (res != null) {
			len++;
			res = res.next;
		}
		
		res = headB;
		while (res != null) {
			len--;
			res = res.next;
		}
		
		ListNode tmp = null;
		if (len > 0) {
			res = headA;
			tmp = headB;
			while (len != 0) {
				len--;
				res = res.next;
			}
		} else {
			res = headB;
			tmp = headA;
			while (len != 0) {
				len++;
				res = res.next;
			}
		}
		
		while (tmp != null && res != null) {
			if (tmp == res)
				return res;
			tmp = tmp.next;
			res = res.next;
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		IntersectionOfTwoLinkedLists in = new IntersectionOfTwoLinkedLists();
		ListNode A = ListNode.createListNode("-1->0->1->2->3->4");
		ListNode B = ListNode.createListNode("1->2->3->4");
		ListNode C = ListNode.createListNode("5->6->7");
		A.end().next = C;
		B.end().next = C;
		System.out.println(in.getIntersectionNode(A, B));
	}
}
