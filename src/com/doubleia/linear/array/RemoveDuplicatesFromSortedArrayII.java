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
    	int count = 0;
    	
    	for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1] && count < 2) {
				j++;
				nums[j] = nums[i];
				count++;
			} else if (count == 2 && nums[i] != nums[i - 1]) {
				nums[j] = nums[i];
				count = 0;
			} else if (nums[i] != nums[i - 1]) {
				j++;
				nums[j] = nums[i];
				count = 0;
			}
		}
    	
    	if (count != 2)
    		return j + 1;
    	else
    		return j;
    }

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArrayII remove = new RemoveDuplicatesFromSortedArrayII();
		int[] nums = new int[] {-15,-14,-14,-13,-12,-11,-11,-9,-6,-5,-5,-4,-3,-3,-2,-1,0,0,1,2,3,4,4,4,4,5,5,6,6,7,8,8,9,9,10,11,11,12,12,13,13,14,14,15,16,17,18,19,19,20,21,22,23,23,23,24,24,24,25,25,26,26,26,27,28,28,29,29,30,30,31,32,32,33,33,34,34,35,36,37,38,38,38,39,39,39,40,41,42,42,43,44,45,45,46,47,48,48,49,49,50,50,51,51,52,52,53,54,55,55,55,56,56,57,57,57,58,59,59,60,61,61,61,62,63,64,64,65,65,65,66,66,66,67,67,68,68,69,69,70,70,71,72,72,73,73,74,74,75,75,75,76,77,78,79,79,80,81,81,82,82,83,84,84,85,86,86,86,86,87,87,88,89,89,90,91,91,92,93,93,94,95,95,96,97,97,98,99,99,99,100,100,101,102,105,106,108,110,114,114};
		System.out.println(remove.removeDuplicates(nums));
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
