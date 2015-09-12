package com.doubleia.sort;

/**
 * 
 * Given an array nums of integers and an int k, 
 * partition the array (i.e move the elements in "nums") such that:
 * 
 * * All elements < k are moved to the left
 * * All elements >= k are moved to the right
 * 
 * Return the partitioning index, i.e the first index i nums[i] >= k.
 * 
 * You should do really partition in array nums 
 * instead of just counting the numbers of integers smaller than k.
 * 
 * Can you partition the array in-place and in O(n)?
 * 
 * @author wangyingbo
 *
 */
public class PartitionArray {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
    	int p = -1;

    	for (int i = 0; i < nums.length; i++) {
			if (k > nums[i]) {
				p++;
				if (p != i)
					exchange(nums, p, i);
			}
		}
    	
    	return p + 1;
    }
    
    private void exchange(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}
    
    public static void main(String[] args) {
		int[] nums = {3,2,2,1};
		
		PartitionArray par = new PartitionArray();
		int result = par.partitionArray(nums, 2);
		System.out.println(result);
	}
}
