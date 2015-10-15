package com.doubleia.linear.linkedlist;

public class ListNode {
	int val;
	ListNode next;
	public ListNode(int val) {
		this.val = val;
		this.next = null;
	}
	
	public static ListNode createListNode(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		ListNode head = new ListNode(nums[0]);
		ListNode h = head;
		for (int i = 1; i < nums.length; i++) {
			ListNode node = new ListNode(nums[i]);
			h.next = node;
			h = node;
		}
		return head;
	}
}
