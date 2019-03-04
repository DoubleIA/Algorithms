package com.doubleia.linear.hashtable;

public class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
	public static void printRandomList(RandomListNode head, String msg) {
		StringBuilder builder = new StringBuilder("");
		while (head != null) {
			builder.append("(").append(head.label).append(", ").append((head.next != null) ? head.next.label : "null").append(", ").append((head.random != null) ? head.random.label : "null").append(")");
			head = head.next;
			if (head != null)
				builder.append("->");
		}
		System.out.println(msg + ": " + builder.toString());
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
		
		printRandomList(node1, "List1");
	}
}
