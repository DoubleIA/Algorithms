package com.doubleia.linear.linkedlist;

/**
 * 
 * Sort a linked list using insertion sort.
 * 
 * @author wangyingbo
 *
 *         Definition for ListNode. public class ListNode { int val; ListNode
 *         next; ListNode(int val) { this.val = val; this.next = null; } }
 */
public class InsertSortList {
	/**
	 * @param head
	 *            : The first node of linked list.
	 * @return: The head of linked list.
	 */
	public ListNode insertionSortList(ListNode head) {
		// write your code here
		if (head == null || head.next == null) {
			return head;
		}

		ListNode curr = head;
		ListNode index = head.next;
		while (index != null) {
			if (curr.val <= index.val) {
				curr = index;
				index = index.next;
			} else {
				ListNode h = head;
				if (head.val >= index.val) {
					ListNode indexNext = index.next;
					curr.next = indexNext;
					index.next = head;
					head = index;
					index = indexNext;
				} else {
					while (h.val <= index.val && h.next.val <= index.val) {
						h = h.next;
					}
					if (h.val <= index.val && h.next.val >= index.val) {
						ListNode indexNext = index.next;
						curr.next = indexNext;
						index.next = h.next;
						h.next = index;
						index = indexNext;
					}
				}
			}
			printListNode(head, "=============================while");
		}
		return head;
	}

	private static void printListNode(ListNode head, String msg) {
		System.out.println(msg);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] nums = {4, 19, 14, 5, -3, 1, 8, 5, 11, 15};
		InsertSortList sort = new InsertSortList();
		ListNode head = ListNode.createListNode(nums);
		printListNode(head, "=============================Initial");
		
		ListNode result = sort.insertionSortList(head);
		printListNode(result, "=============================Result");
	}

}
