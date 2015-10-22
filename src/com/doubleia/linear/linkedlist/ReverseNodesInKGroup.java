package com.doubleia.linear.linkedlist;

/**
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed. Only constant memory is allowed.
 * 
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * @author wangyingbo
 *
 */
public class ReverseNodesInKGroup {
    /**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     */
	public ListNode reverseKGroup(ListNode head, int k) {
		// Write your code here
		if (head == null || head.next == null)
			return head;
		
		int checkN = 0;
		ListNode checkH = head;
		
		while (checkH != null && checkN != k) {
			checkN++;
			checkH = checkH.next;
		}
		
		if (checkN != k)
			return head;
		
		ListNode post = head.next;
		ListNode res = head;
		int cnt = 1;
		while (post != null && cnt < k) {
			ListNode temp = post.next;
			post.next = res;
			res = post;
			post = temp;
			cnt++;
		}
		
		ListNode p = reverseKGroup(post, k);
		head.next = p;
		
		return res;
	}
	
	public static void main(String[] args) {
		ReverseNodesInKGroup reverse = new ReverseNodesInKGroup();
		System.out.println(reverse.reverseKGroup(ListNode.createListNode("1->2->3->4->5"), 2));
	}
}
