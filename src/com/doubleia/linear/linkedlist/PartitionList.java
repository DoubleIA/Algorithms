package com.doubleia.linear.linkedlist;

/**
 * 
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * Given 1->4->3->2->5->2->null and x = 3,
 * return 1->2->2->4->3->5->null.
 * 
 * @author wangyingbo
 *
 */
public class PartitionList {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
	public ListNode partition(ListNode head, int x) {
		// write your code here
		if (head == null || head.next == null)
			return head;
		
		ListNode post = new ListNode(-1);
		ListNode p = post;
		ListNode pre = new ListNode(-1);
		ListNode curr = head;
		pre.next = curr;
		while (curr != null) {
			if (curr.val >= x) {
				p.next = new ListNode(curr.val);
				curr = curr.next;
				p = p.next;
			} else {
				pre = pre.next;
				int tmp = pre.val;
				pre.val = curr.val;
				curr.val = tmp;
				curr = curr.next;
			}
		}
		
		curr = head;
		while (curr.next != null && curr.next.val < x) {
			curr = curr.next;
		}
		if (curr != head)
			curr.next = post.next;
		
		return head;
	}
	
	public static void main(String[] args) {
		PartitionList par = new PartitionList();
		System.out.println(par.partition(ListNode.createListNode("-29->-2->-43->-26->-12->58->-55->-44->-75->83->9->46->29->-6->-79->-73->-96->66->66->-100->20->-89->-14->-67->12->96->27->-36->29->-68->29->52->30->38->79->70->-3->-76->-73->-26->60->-12->-80->-11->82->94->16->86->12->-17->39->-68->-54->-75->-82->58->74->-3->74->-45->29->-45->59->-89->94->38->82->-57->15->-91->-31->-25->-3->-58->64->-69->-64->-20->69->0->15->8->32->61->-14->2->-29->-88->-100->97->-81->29->-47->30->-7->99->-31->-73->94->36->88->-37->-89->-63->5->null"), 1));
	}
}
