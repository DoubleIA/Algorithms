package com.doubleia.linear.array;

/**
 * 
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * 
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * @author wangyingbo
 *
 */
public class RemoveDuplicatesFromSortedArrayII {
	/**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
    	if (nums.length == 0)
    		return 0;
    	
    	int j = 0;
    	boolean flag = false;
    	
    	for (int i = 1; i < nums.length - 1; i++) {
			if (!flag && nums[i] == nums[j]) {
				j++;
				flag = true;
			}
			if (nums[i] != nums[j]) {
				j++;
				exchange(nums, i, j);
				if (nums[i] == nums[i + 1])
					exchange(nums, i + 1, j);
				flag = false;
			}
		}
    	
    	return j + 1;
    }
    
    private void exchange(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArrayII remove = new RemoveDuplicatesFromSortedArrayII();
		int[] nums = new int[] {1,1,1,2,2,2,3,3,3,3,3,3,4,4,4,5,6,7};
		System.out.println(remove.removeDuplicates(nums));
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}
}
