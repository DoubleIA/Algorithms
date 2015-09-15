package com.doubleia.heap;

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
		if (size == 1)
			return lists.get(0);
		
		int[] heap = new int[size];
		for (int i = 0; i < size; i++) {
			heap[i] = lists.get(i).val;
		}
		
		buildHeap(heap);
		
		return root;
	}
	
	private void buildHeap(int[] array) {
		int half = array.length / 2;
		for (int i = half; i >= 0; i--) {
			minHeapify(array, array.length, i);
		}
	}
	
	private void minHeapify (int[] array, int heapSize, int index) {
		int left = index *2 + 1;
		int right = index * 2 + 2;
		
		int smallest = index;
		if (left < heapSize && array[left] < array[index])
			smallest = left;
		if (right < heapSize && array[right] < array[smallest])
			smallest = right;
		
		if (smallest != index) {
			exchange(array, smallest, index);
			minHeapify(array, array.length, smallest);
		}
	}
	
	private void exchange(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		ListNode list1 = ListNode.buildList(new int[] {2,4});
		ListNode list2 = ListNode.buildList(null);
		ListNode list3 = ListNode.buildList(new int[] {-1});
		ListNode.printList("list1", list1);
		ListNode.printList("list2", list2);
		ListNode.printList("list3", list3);
		MergekSortedLists merge = new MergekSortedLists();
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		ListNode result = merge.mergeKLists(lists);
		ListNode.printList("result", result);
	}
}
