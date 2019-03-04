package com.doubleia.linear.linkedlist;

/**
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. 
 * You may not modify the values in the list, only nodes itself can be changed.
 * 
 * @author wangyingbo
 *
 */
public class SwapNodesInPairs {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
    	if (head == null || head.next == null)
    		return head;
    	ListNode pre = head;
    	ListNode curr = head.next;
    	ListNode h = new ListNode(0);
    	head = h;
    	
    	while (curr != null) {
    		ListNode tmp = curr.next;
    		curr.next = pre;
    		h.next = curr;
    		h = pre;
    		pre.next = tmp;
    		pre = tmp;
    		if (tmp != null)
    			curr = tmp.next;
    		else
    			break;
    	}
    	
    	return head.next;
    }
    
    public static void main(String[] args) {
		SwapNodesInPairs swap = new SwapNodesInPairs();
		System.out.println(swap.swapPairs(ListNode.createListNode("1->2->3->4")));
	}
}
