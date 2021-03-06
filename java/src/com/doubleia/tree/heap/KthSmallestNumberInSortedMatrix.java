package com.doubleia.tree.heap;

/**
 * 
 * Find the kth smallest number in at row and column sorted matrix.
 * 
 * Given k = 4 and a matrix:
 * 
 * [
 *   [1 ,5 ,7],
 *   [3 ,7 ,8],
 *   [4 ,8 ,9],
 * ]
 * 
 * return 5
 * 
 * O(k log n), n is the maximal number in width and height.
 * 
 * @author wangyingbo
 *
 */
public class KthSmallestNumberInSortedMatrix {
	/**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
    	if (matrix.length == 0 || matrix == null)
    		return Integer.MAX_VALUE;
    	int row = matrix.length;
    	int column = matrix[0].length;
    	if (k <= 0 || k > row * column)
    		return Integer.MAX_VALUE;

    	HeapNode[] heap = new HeapNode[column];
    	
    	for (int i = 0; i < column; i++) {
    		HeapNode node = new HeapNode();
    		node.value = matrix[0][i];
    		node.row = 0;
    		node.column = i;
    		heap[i] = node;
    	}
    	
    	buildMinHeap(heap);
    	
    	int result = Integer.MAX_VALUE;
    	
    	for (int i = 0; i < k; i++) {
    		HeapNode curr = heap[0];
    		result = curr.value;
			int nextVal = curr.row < row - 1 ? matrix[curr.row + 1][curr.column] : Integer.MAX_VALUE;
			heap[0].value = nextVal;
			heap[0].row = (heap[0].row + 1);
			heap[0].column = curr.column;
			minHeapify(heap, column, 0);
		}
    	return result;
    }
    
    class HeapNode {
    	int value;
    	int row;
    	int column;
    }
    
    private void buildMinHeap(HeapNode[] array) {
    	if (array == null || array.length <= 1)
    		return;
    	int half = (array.length - 1) / 2;
    	for (int i = half; i >= 0; i--) 
    		minHeapify(array, array.length, i);
    }
    
    private void minHeapify(HeapNode[] array, int heapSize, int index) {
    	int left = index * 2 + 1;
    	int right = index * 2 + 2;
    	int smallest = index;
    	if (left < heapSize && array[left].value < array[index].value)
    		smallest = left;
    	if (right < heapSize && array[right].value < array[smallest].value)
    		smallest = right;
    	
    	if (smallest != index) {
    		exchange(array, index, smallest);
    		minHeapify(array, heapSize, smallest);
    	}
    }
    
    private void exchange(HeapNode[] array, int i, int j) {
		HeapNode temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
    
   
    /**
     * 
     * { {10, 20, 30, 40},
          {15, 25, 35, 45},
          {25, 29, 37, 48},
          {32, 33, 39, 50},
		};
		{{1,5,7},
		{3,7,8},
		{4,8,9}};
     * 
     */
    public static void main(String[] args) {
		int[][] matrix = { {10, 20, 30, 40},
		          				 {15, 25, 35, 45},
		          				 {25, 29, 37, 48},
		          				 {32, 33, 39, 50},
								};
		KthSmallestNumberInSortedMatrix kth = new KthSmallestNumberInSortedMatrix();
		System.out.println(kth.kthSmallest(matrix, 11));
	}
    
}
