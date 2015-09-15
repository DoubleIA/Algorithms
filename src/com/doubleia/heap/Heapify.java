package com.doubleia.heap;

/**
 * 
 * Given an integer array, heapify it into a min-heap array.
 * For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
 * 
 * Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.
 * 
 * O(n) time complexity
 * 
 * What is heap?
 * 
 * *    Heap is a data structure, which usually have three methods: 
 * *    push, pop and top. where "push" add a new element the heap, 
 * *    "pop" delete the minimum/maximum element in the heap, 
 * *    "top" return the minimum/maximum element.
 * 
 * What is heapify?
 * 
 * *    Convert an unordered integer array into a heap array. 
 * *    If it is min-heap, for each element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].
 * 
 * What if there is a lot of solutions?
 * 
 * *    Return any of them.
 * 
 * @author wangyingbo
 *
 */
public class Heapify {
	/**
	 * @param A : Given an integer array
	 * @return: void
	 */
	public void heapify(int[] A) {
		// write your code here
		if (A == null || A.length <= 1)
			return;
		int half = A.length / 2;
		for (int i = half; i >= 0; i--) {
			minHeapify(A, A.length, i);
		}
	}
	
	private void minHeapify(int[] array, int heapSize, int i) {
		int left = i * 2 + 1;
		int right = i * 2 + 2;
		
		int smallest = i;
		if (left < heapSize && array[left] < array[i])
			smallest = left;
		if (right < heapSize && array[right] < array[smallest])
			smallest = right;
		if (smallest != i) {
			exchange(array, smallest, i);
			minHeapify(array, array.length, smallest);
		}
	}
	
	private void exchange(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,2,1,4,7,9,6,8,5};
		HeapSort.printArray(nums);
		Heapify heapify = new Heapify();
		heapify.heapify(nums);
		HeapSort.printArray(nums);
	}
}
