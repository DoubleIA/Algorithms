package com.doubleia.tree.heap;

public class HeapSort {
	
	public static void heapSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		buildMaxHeap(array);

		for (int i = array.length - 1; i >= 1; i--) {
			exchange(array, 0, i);
			maxHeapify(array, i, 0);
		}
	}

	private static void buildMaxHeap(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		int half = array.length / 2;
		for (int i = half; i >= 0; i--) {
			maxHeapify(array, array.length, i);
		}
	}

	private static void maxHeapify(int[] array, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;

		int largest = index;
		if (left < heapSize && array[left] > array[index]) {
			largest = left;
		}

		if (right < heapSize && array[right] > array[largest]) {
			largest = right;
		}

		if (index != largest) {
			exchange(array, index, largest);
			maxHeapify(array, heapSize, largest);
		}
	}
	
	private static void exchange(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void printArray(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1)
				System.out.print(", ");
		}
		System.out.print("]");
	}
	
	public static void main(String[] args) {
		int[] heap = {3,2,1,4,6,3,-1,3,-8,9,39,-23,5,7,2,-1,0,33,12,-4,21};
		HeapSort.heapSort(heap);
		printArray(heap);
	}
}
