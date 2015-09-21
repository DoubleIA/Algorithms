package com.doubleia.tree.heap;

public class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
	public static ListNode buildList(int [] array) {
		ListNode root = null;
		if (array == null) 
			return root;
		if (array.length >= 1)
			root = new ListNode(array[0]);
		ListNode curr = root;
		for (int i = 1; i < array.length; i++) {
			curr.next = new ListNode(array[i]);
			curr = curr.next;
		}
		return root;
	}
	public static void printList(ListNode root) {
		if (root == null) {
			System.out.println("null");
			return;
		}
		while (root != null) {
			System.out.print(root.val + "->");
			root = root.next;
		}
		System.out.println("null");
	}
	public static void printList(String msg, ListNode root) {
		if (root == null) {
			System.out.println(msg + ": null");
			return;
		}
		System.out.print(msg + ": ");
		while (root != null) {
			System.out.print(root.val + "->");
			root = root.next;
		}
		System.out.println("null");
	}
}
