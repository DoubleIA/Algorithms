package com.doubleia.linear.linkedlist;

/**
 * 
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * Given 1->2->3->4->5 and k = 2, return 4->5->1->2->3.
 * 
 * @author wangyingbo
 *
 */
public class RotateList {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
	public ListNode rotateRight(ListNode head, int k) {
		// write your code here
		if (head == null || head.next == null || k <= 0)
			return head;
		ListNode res = head;
		int cnt = 1;
		while (res.next != null) {
			res = res.next;
			cnt++;
		}
		
		res.next = head;
		k = k % cnt;
		while (--cnt > k) {
			head = head.next;
		}
		res = head.next;
		head.next = null;
		
		return res;
	}
	
	public static void main(String[] args) {
		RotateList rlist = new RotateList();
		System.out.println(rlist.rotateRight(ListNode.createListNode(new int[]{17,75,80,87,44,45,75,86,74,20}), 19));
	}
}
