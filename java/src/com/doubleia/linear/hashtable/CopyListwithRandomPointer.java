package com.doubleia.linear.hashtable;

/**
 * 
 * A linked list is given such that each node contains an additional random pointer which
 *  could point to any node in the list or null.Return a deep copy of the list.
 * 
 * Could you solve it with O(1) space?
 * 
 * @author wangyingbo
 *
 */
public class CopyListwithRandomPointer {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
	public RandomListNode copyRandomList(RandomListNode head) {
		// write your code here
		RandomListNode node = null;
		if (head == null)
			return null;
		RandomListNode curr = head;
		while (curr != null) {
			RandomListNode newNode = new RandomListNode(curr.label);
			RandomListNode temp = curr.next;
			newNode.next = curr.next;
			curr.next = newNode;
			curr = temp;
		}
		curr = head;
		node = curr.next;
		RandomListNode newCurr = node;
		while (curr != null && newCurr != null) {
			RandomListNode temp = curr.next.next;
			newCurr.random = curr.random;
			if (temp != null) {
				newCurr.next = temp.next;
				newCurr = temp.next;
				curr.next = temp;
				curr = temp;
			} else {
				curr.next = temp;
				curr = temp;
			}
		}
		
		return node;
	}
	
	public static void main(String[] args) {
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		
		node1.next = node2;
		node1.random = node3;
		node2.next = node3;
		node2.random = null;
		node3.next = node4;
		node3.random = null;
		node4.next = null;
		node4.random = node2;
		
		RandomListNode.printRandomList(node1, "Before copy list");
		
		CopyListwithRandomPointer pointer = new CopyListwithRandomPointer();
		RandomListNode node = pointer.copyRandomList(node1);
		
		RandomListNode.printRandomList(node1, "After copy list");
		RandomListNode.printRandomList(node, "Copy result");
	}
}
