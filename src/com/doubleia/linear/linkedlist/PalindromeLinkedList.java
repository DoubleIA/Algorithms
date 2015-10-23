package com.doubleia.linear.linkedlist;

/**
 * 
 * Implement a function to check if a linked list is a palindrome.
 * 
 * Given 1->2->1, return true
 * 
 * Could you do it in O(n) time and O(1) space?
 * 
 * @author wangyingbo
 *
 */
public class PalindromeLinkedList {
    /**
     * @param head a ListNode
     * @return a boolean
     */
	public boolean isPalindrome(ListNode head) {
		// Write your code here
		if (head == null || head.next == null)
			return true;
		int len = 0;
		ListNode pre = head;
		while (pre != null) {
			pre = pre.next;
			len++;
		}
		
		pre = head;
		ListNode post = head.next;
		int cnt = 1;
		while (cnt < len / 2) {
			ListNode tmp = post.next;
			post.next = pre;
			pre = post;
			post = tmp;
			cnt++;
		}
		
		head.next = null;
		if (len % 2 == 1)
			post = post.next;

		while (pre != null && post != null) {
			if (pre.val != post.val)
				return false;
			pre = pre.next;
			post = post.next;
		}
		return true;
	}
	
	public static void main(String[] args) {
		PalindromeLinkedList pal = new PalindromeLinkedList();
		System.out.println(pal.isPalindrome(ListNode.createListNode("1->2->3->4->5->4->3->2->1")));
	}
}
