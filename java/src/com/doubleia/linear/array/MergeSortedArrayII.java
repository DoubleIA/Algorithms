package com.doubleia.linear.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Merge two given sorted integer array A and B into a new sorted integer array.
 * 
 * A=[1,2,3,4]
 * B=[2,4,5,6]
 * 
 * return [1,2,2,3,4,4,5,6]
 * 
 * How can you optimize your algorithm if one array is very large and the other is very small?
 * 
 * @author wangyingbo
 *
 */
public class MergeSortedArrayII {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        // write your code here
    	if (A.size() == 0)
    		return B;
    	else if(B.size() == 0)
    		return A;
    	
    	ArrayList<Integer> result = new ArrayList<Integer>(A.size() + B.size());
    	
    	int i = 1;
    	int j = 1;
    	int aMin = A.get(0);
		int bMin = B.get(0);
    	while (true) {
    		if (aMin <= bMin) {
    			result.add(aMin);
    			if (i < A.size()) {
    				aMin = A.get(i);
    				i++;
    			} else {
    				result.addAll(B.subList(j - 1, B.size()));
    				break;
    			}
    		} else {
    			result.add(bMin);
    			if (j < B.size()) {
    				bMin = B.get(j);
    				j++;
    			} else {
					result.addAll(A.subList(i - 1, A.size()));
					break;
    			}
    		}
    	}
    	
    	return result;
    }
    
    public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		A.addAll(Arrays.asList(new Integer[] {1}));
		B.addAll(Arrays.asList(new Integer[] {1}));
		
		MergeSortedArrayII merge = new MergeSortedArrayII();
		
		System.out.println(merge.mergeSortedArray(A, B));
	}
}
