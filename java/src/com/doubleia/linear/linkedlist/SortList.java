package com.doubleia.linear.linkedlist;

/**
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Given 1-3->2->null, sort it to 1->2->3->null.
 * 
 * @author wangyingbo
 *
 */
public class SortList {
	/**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
	public ListNode sortList(ListNode head) {
		// write your code here
		if (head == null || head.next == null)
			return head;
		
		ListNode fast = head;
		ListNode slow = head;
		
		while (fast != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = slow.next;
		slow.next = null;
		
		head  = sortList(head);
		fast = sortList(fast);
		
		return merge(head, fast);
	}
	
	private ListNode merge(ListNode h1, ListNode h2) {
		ListNode res = null;
		ListNode curr = null;
		
		if (h1.val <= h2.val) {
			res = h1;
			h1 = h1.next;
		} else {
			res = h2;
			h2 = h2.next;
		}
		
		curr = res;
		while (h1 != null || h2 != null) {
			if (h1 == null) {
				curr.next = h2;
				break;
			} else if (h2 == null) {
				curr.next = h1;
				break;
			}
			if (h1.val <= h2.val) {
				curr.next = h1;
				h1 = h1.next;
			} else {
				curr.next = h2;
				h2 = h2.next;
			}
			curr = curr.next;
		}
		
		return res;
	}

	public static void main(String[] args) {
		SortList sort = new SortList();
		System.out.println(sort.sortList(ListNode.createListNode(new int[]{1,3,2,8,5,7,6})));
	}
}
