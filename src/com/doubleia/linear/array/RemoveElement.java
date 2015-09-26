package com.doubleia.linear.array;

/**
 * 
 * Given an array and a value, remove all occurrences of that value in place and return the new length.
 * The order of elements can be changed, and the elements after the new length don't matter.
 * 
 * Given an array [0,4,4,0,0,2,4,4], value=4
 * return 4 and front four elements of the array is [0,0,0,2]
 * 
 * @author wangyingbo
 *
 */
public class RemoveElement {
	/** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
    	if (A.length == 0)
    		return 0;
    	
    	int j = -1;
    	for (int i = 0; i < A.length; i++) {
			if (A[i] != elem) {
				j++;
				exchange(A, i, j);
			}
		}
    	
    	return j + 1;
    }
    
    private void exchange(int[] array, int i, int j) {
    	int temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }
    
    public static void main(String[] args) {
		RemoveElement remove = new RemoveElement();
		int[] A = new int[] {0,0,0,0,0,0,0,0};
    	System.out.println(remove.removeElement(A, 0));
    	for (int i : A) {
			System.out.print(i + " ");
		}
    }
    
}
