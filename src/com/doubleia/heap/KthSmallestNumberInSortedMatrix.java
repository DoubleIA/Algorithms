package com.doubleia.heap;

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
    		heap[i].value = matrix[0][i];
    		heap[i].row = 0;
    		heap[i].column = i;
    	}
    	buildMinHeap(heap);
    	
    	HeapNode curr = null;
    	
    	for (int i = 0; i < k; i++) {
			curr = heap[0];
			int nextVal = (curr.row < row - 1) ? matrix[curr.row + 1][curr.column] : Integer.MAX_VALUE;
			heap[0].value = nextVal;
			heap[0].row = heap[0].row + 1;
			heap[0].column = column;
			minHeap(heap, column, 0);
		}
    	return 0;
    }
    
    private class HeapNode {
    	int value;
    	int row;
    	int column;
    }
    
    private void buildMinHeap(HeapNode[] array) {
    	if (array == null || array.length <= 1)
    		return;
    	int half = array.length / 2;
    	for (int i = half; i >= 0; i--) 
    		minHeap(array, array.length, i);
    }
    
    private void minHeap(HeapNode[] array, int heapSize, int index) {
    	int left = index << 1 + 1;
    	int right = index << 1 + 2;
    	int smallest = left;
    	if (left < heapSize && array[left].value < array[index].value)
    		smallest = left;
    	if (right < heapSize && array[right].value < array[index].value)
    		smallest = right;
    	
    	if (smallest != index) {
    		exchange(array, index, smallest);
    		minHeap(array, heapSize, smallest);
    	}
    }
    
    private void exchange(HeapNode[] array, int i, int j) {
		HeapNode temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
    
    public static void main(String[] args) {
		int[][] matrix = {{1,5,7},{3,7,8},{4,8,9}};
		KthSmallestNumberInSortedMatrix kth = new KthSmallestNumberInSortedMatrix();
		System.out.println(kth.kthSmallest(matrix, 4));
	}
    
    
    
    /**
     * 
     * 
     * // kth largest element in a 2d array sorted row-wise and column-wise
#include<iostream>
#include<climits>
using namespace std;
 
// A structure to store an entry of heap.  The entry contains
// a value from 2D array, row and column numbers of the value
struct HeapNode {
    int val;  // value to be stored
    int r;    // Row number of value in 2D array
    int c;    // Column number of value in 2D array
};
 
// A utility function to swap two HeapNode items.
void swap(HeapNode *x, HeapNode *y) {
    HeapNode z = *x;
    *x = *y;
    *y = z;
}
 
// A utility function to minheapify the node harr[i] of a heap
// stored in harr[]
void minHeapify(HeapNode harr[], int i, int heap_size)
{
    int l = i*2 + 1;
    int r = i*2 + 2;
    int smallest = i;
    if (l < heap_size && harr[l].val < harr[i].val)
        smallest = l;
    if (r < heap_size && harr[r].val < harr[smallest].val)
        smallest = r;
    if (smallest != i)
    {
        swap(&harr[i], &harr[smallest]);
        minHeapify(harr, smallest, heap_size);
    }
}
 
// A utility function to convert harr[] to a max heap
void buildHeap(HeapNode harr[], int n)
{
    int i = (n - 1)/2;
    while (i >= 0)
    {
        minHeapify(harr, i, n);
        i--;
    }
}
 
// This function returns kth smallest element in a 2D array mat[][]
int kthSmallest(int mat[4][4], int n, int k)
{
    // k must be greater than 0 and smaller than n*n
    if (k <= 0 || k > n*n)
       return INT_MAX;
 
    // Create a min heap of elements from first row of 2D array
    HeapNode harr[n];
    for (int i = 0; i < n; i++)
        harr[i] =  {mat[0][i], 0, i};
    buildHeap(harr, n);
 
    HeapNode hr;
    for (int i = 0; i < k; i++)
    {
       // Get current heap root
       hr = harr[0];
 
       // Get next value from column of root's value. If the
       // value stored at root was last value in its column,
       // then assign INFINITE as next value
       int nextval = (hr.r < (n-1))? mat[hr.r + 1][hr.c]: INT_MAX;
 
       // Update heap root with next value
       harr[0] =  {nextval, (hr.r) + 1, hr.c};
 
       // Heapify root
       minHeapify(harr, 0, n);
    }
 
    // Return the value at last extracted root
    return hr.val;
}
 
// driver program to test above function
int main()
{
  int mat[4][4] = { {10, 20, 30, 40},
                    {15, 25, 35, 45},
                    {25, 29, 37, 48},
                    {32, 33, 39, 50},
                  };
  cout << "7th smallest element is " << kthSmallest(mat, 4, 7);
  return 0;
}
     * 
     * 
     */
}
