package com.doubleia.tree.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 * 
 * Given lists:
 * 
 * * [
 * *   2->4->null,
 * *   null,
 * *   -1->null
 * * ],
 * 
 * return -1->2->4->null.
 * 
 * @author wangyingbo
 *
 */
public class MergekSortedLists {

	/**
	 * @param lists : a list of ListNode
	 * @return: The head of one sorted list.
	 */
	public ListNode mergeKLists(List<ListNode> lists) {
		// write your code here
		ListNode root = null;
		if (lists == null)
			return root;
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i) == null)
				lists.remove(i);
		}
		
		int size = lists.size();
		if (size == 0)
			return root;
		if (size == 1)
			return lists.get(0);
		
		ListNode[] heap = new ListNode[size];
		for (int i = 0; i < size; i++) {
			heap[i] = lists.get(i);
		}
		
		buildHeap(heap);
		root = new ListNode(Integer.MIN_VALUE);
		ListNode curr = root;
		while (heap[0] != null) {
			curr.next = new ListNode(heap[0].val);
			curr = curr.next;
			if (heap[0].next != null) {
				heap[0] = heap[0].next;
				minHeapify(heap, size, 0);
			} else {
				deleteHeapNode(heap, size, 0);
				size--;
				System.out.println("size after" + size);
			}
		}
		
		return root.next;
	}
	
	private void buildHeap(ListNode[] heap) {
    	if (heap == null || heap.length <= 1)
    		return;
		int half = heap.length / 2;
		for (int i = half; i >= 0; i--) {
			minHeapify(heap, heap.length, i);
		}
	}
	
	private void deleteHeapNode(ListNode[] heap, int heapSize, int index) {
		if (index >= heapSize)
			return;
		heap[index] = heap[heapSize - 1];
		heap[heapSize - 1] = null;
		minHeapify(heap, heapSize - 1, index);
	}
	
	private void minHeapify (ListNode[] heap, int heapSize, int index) {
		int left = index *2 + 1;
		int right = index * 2 + 2;
		
		int smallest = index;
		if (left < heapSize && heap[left].val < heap[index].val)
			smallest = left;
		if (right < heapSize && heap[right].val < heap[smallest].val)
			smallest = right;
		
		if (smallest != index) {
			exchange(heap, smallest, index);
			minHeapify(heap, heapSize, smallest);
		}
	}
	
	private void exchange(ListNode[] heap, int i, int j) {
		ListNode temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	public static void main(String[] args) {
		ListNode list1 = ListNode.buildList(new int[] {-10,-9,-9,-3,-1,-1,0});
		ListNode list2 = ListNode.buildList(new int[] {-5});
		ListNode list3 = ListNode.buildList(new int[] {4});
		ListNode list4 = ListNode.buildList(new int[] {-8});
		ListNode list5 = ListNode.buildList(null);
		ListNode list6 = ListNode.buildList(new int[] {-9,-6,-5,-4,-2,2,3});
		ListNode list7 = ListNode.buildList(new int[] {-3,-3,-2,-1,0});
		ListNode.printList("list1", list1);
		ListNode.printList("list2", list2);
		ListNode.printList("list3", list3);
		ListNode.printList("list4", list4);
		ListNode.printList("list5", list5);
		ListNode.printList("list6", list6);
		ListNode.printList("list7", list7);
		MergekSortedLists merge = new MergekSortedLists();
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		lists.add(list4);
		lists.add(list5);
		lists.add(list6);
		lists.add(list7);
		ListNode result = merge.mergeKLists(lists);
		ListNode.printList("result", result);
	}
}
