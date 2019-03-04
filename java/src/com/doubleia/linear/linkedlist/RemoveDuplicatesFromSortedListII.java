package com.doubleia.linear.linkedlist;

/**
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. 
 * 
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 *  Given 1->1->1->2->3, return 2->3. 
 * 
 * @author wangyingbo
 *
 */
public class RemoveDuplicatesFromSortedListII {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
	public static ListNode deleteDuplicates(ListNode head) {
		// write your code here
		if (head == null || head.next == null)
			return head;
		
		ListNode curr = head.next;
		ListNode pre = head;
		
		while (curr != null) {
			if (pre == head && pre.val == curr.val) {
				while (curr != null && pre.val == curr.val) {
					curr = curr.next;
				}
				head = curr;
				pre = head;
				if (curr != null)
					curr = curr.next;
			} else if (curr.next != null && curr.next.val == pre.next.val){
				while (curr != null && pre.next.val == curr.next.val) {
					curr = curr.next;
					if (curr.next == null) {
						break;
					}
				}
				curr = curr == null ? curr : curr.next;
				pre.next = curr;
			} else {
				pre = pre.next;
				curr = curr.next;
			}
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		System.out.println(RemoveDuplicatesFromSortedListII.deleteDuplicates(ListNode.createListNode("1->1->1->-14->-13->-12->-12->-11->-10->-10->-10->-9->-9->-9->-8->-8->-7->-7->-6->-5->-5->-5->-5->-3->-3->-3->-3->-2->-1->-1->-1->-1->0->0->0->1->1->1->1->1->2->2->2->3->3->3->3->4->4->5->5->6->6->6->6->7->7->8->8->8->8->8->8->9->9->9->9->10->10->10->11->11->12->12->13->13->13->13->13->14->14->15->15->15->16->16->16->16->17->17->17->17->18->18->18->18->19->19->21->21->21->22->23->24->25->25->25->25->25->null")));
	}
}
