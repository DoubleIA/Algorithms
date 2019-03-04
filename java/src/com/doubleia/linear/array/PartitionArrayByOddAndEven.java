package com.doubleia.linear.array;


/**
 * 
 * Partition an integers array into odd number first and even number second.
 * 
 * Given [1, 2, 3, 4], return [1, 3, 2, 4]
 * 
 * Do it in-place.
 * 
 * @author wangyingbo
 *
 */
public class PartitionArrayByOddAndEven {
	/**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
    	int i = -1;
    	for (int j = 0; j < nums.length; j++) {
			if (nums[j] % 2 == 1) {
				i++;
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
			}
		}
    }
    
    public static void main(String[] args) {
		PartitionArrayByOddAndEven part = new PartitionArrayByOddAndEven();
		int[] nums = new int[]{};
		part.partitionArray(nums);
		System.out.print("[");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			if (i != nums.length - 1)
				System.out.print(", ");
		}
		System.out.println("]");
	}
}
