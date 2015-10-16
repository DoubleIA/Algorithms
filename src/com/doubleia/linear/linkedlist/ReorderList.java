package com.doubleia.linear.linkedlist;

/**
 * 
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example,
 * Given 1->2->3->4->null, reorder it to 1->4->2->3->null.
 * 
 * @author wangyingbo
 *
 */
public class ReorderList {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
	public void reorderList(ListNode head) {
		// write your code here
		ListNode fast = head;
		ListNode slow = head;
		ListNode end = null;
		
		while (fast != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if (fast.next == null) {
			end = fast;
		} else {
			end = fast.next;
		}
		
		fast = slow.next;
		slow.next = null;
		reverse(fast, end);
		slow = head;
		while (slow != null || end != null) {
			if (slow == null)
				slow = end;
			else if (end == null)
				end = slow;
			else {
				fast = end.next;
				ListNode tmp = slow.next;
				slow.next = end;
				end.next = tmp;
				slow = tmp;
				end = fast;
			}
		}
		
	}
	
	private void reverse(ListNode from, ListNode to) {
		if (from == to)
			return;
		
		ListNode pre = from;
		ListNode curr = from.next;
		
		while(pre != to) {
			ListNode tmp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = tmp;
		}
		
		from.next = null;
		
	}

	public static void main(String[] args) {
		ReorderList re = new ReorderList();
		ListNode head = ListNode.createListNode("1->2->3->4->null");
		re.reorderList(head);
		System.out.println(head);
	}
}
