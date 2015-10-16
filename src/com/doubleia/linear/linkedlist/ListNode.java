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
	
	/**
	 * 
	 * Input format : 1->2->3->4->null
	 * 
	 * @param list
	 * @return
	 */
	public static ListNode createListNode(String list) {
		ListNode head = null;
		
		String[] li = list.split("->");
		
		int len = li.length;
		if (len > 0 && li[len - 1].equals("null")) {
			len = len - 1;
		}
		if (len == 0)
			return head;
		
		head = new ListNode(Integer.parseInt(li[0]));
		ListNode curr = head;
		try {
			for (int i = 1; i < len; i++) {
				curr.next = new ListNode(Integer.parseInt(li[i]));
				curr = curr.next;
			}
		} catch (NumberFormatException e) {
			System.err.println("Invalid input string. Expecting format : 1->2->3->4->null");
			return null;
		}
		
		return head;
	}
	
	public ListNode end() {
		ListNode end = this;
		while (end.next != null) {
			end = end.next;
		}
		return end;
	}
	
	public ListNode concat(ListNode next) {
		this.end().next = next;
		return this;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder("");
		ListNode root = this;
		while (root != null) {
			builder.append(String.valueOf(root.val)).append("->");
			root = root.next;
		}
		builder.append("null");
		return builder.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(ListNode.createListNode("1->2->3->4->null"));
	}
}
