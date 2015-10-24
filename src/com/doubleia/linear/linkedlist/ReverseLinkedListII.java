package com.doubleia.linear.linkedlist;

/**
 * 
 * Reverse a linked list from position m to n.
 * 
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
 * 
 * Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Reverse it in-place and in one-pass
 * 
 * @author wangyingbo
 *
 */
public class ReverseLinkedListII {
	/**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
    	if (head == null || head.next == null)
    		return head;
    	
    	int cnt = 1;
    	ListNode pre = new ListNode(-1);
    	ListNode curr = head;
    	pre.next = head;
    	head = pre;
    	ListNode start = null;
    	ListNode end = null;
    	while (curr != null) {
    		if (cnt == m) {
    			start = pre;
    			end = curr;
    			pre = pre.next;
    			curr = curr.next;
    		} else if (cnt == n) {
    			ListNode tmp = curr.next;
    			curr.next = pre;
    			pre = curr;
    			curr = tmp;
    			start.next = pre;
    			end.next = curr;
    		} else if (cnt > m && cnt < n) {
    			ListNode tmp = curr.next;
    			curr.next = pre;
    			pre = curr;
    			curr = tmp;
    		} else {
    			pre = pre.next;
    			curr = curr.next;
    		}
    		cnt++;
    	}
    	
    	return head.next;
    }
    
    public static void main(String[] args) {
		ReverseLinkedListII reverse = new ReverseLinkedListII();
		System.out.println(reverse.reverseBetween(ListNode.createListNode("1->2->3->4->NULL"), 3, 4));
	}
}
