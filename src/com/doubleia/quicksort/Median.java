package com.doubleia.quicksort;

/**
 * 
 * 给定一个未排序的整数数组，找到其中位数。
 * 中位数是排序后数组的中间值，如果数组的个数是偶数个，则返回排序后数组的第N/2个数。
 * 
 * O(N)、O(1)
 * 
 * @author wangyingbo
 *
 */
public class Median {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        if (nums == null) {
			try {
				throw new Exception("argument null exception");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		int midPos = nums.length % 2 == 0 ? nums.length / 2 - 1 : nums.length / 2;
		int index = -1;
		int left = 0;
		int right = nums.length - 1;
		
		while (midPos != index) {
		    index = partition(nums, left, right);
		    
		    if (index < midPos) {
		        left = index + 1;
		    } else if (index > midPos) {
		        right = index -1;
		    } else {
		        break;
		    }
		}
		
		return nums[midPos];
		
    }
    
    private int partition(int[] nums, int left, int right) {

		int index = right - left;
		int x = nums[left + index];
		int p = left - 1;
		
		for (int i = left; i < right; i++) {
			if (nums[i] <= x) {
				p++;
				exchange(nums, p, i);
			}
		}
		exchange(nums, p + 1, left + index);
		
		return p + 1;
		
	}
	
	private void exchange(int[] nums, int i, int j) {
		int temp;
		temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = {5, -4, 5, -4, 5, -4, 5, -4, 5, -4, -100};
		Median mid = new Median();
		int midNum = mid.median(nums);
		System.out.println(midNum);
	}
	
}
