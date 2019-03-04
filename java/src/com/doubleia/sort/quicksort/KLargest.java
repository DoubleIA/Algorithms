package com.doubleia.sort.quicksort;

import java.util.ArrayList;

/**
 * 
 * 在数组中找到第k大的元素
 * 
 * O(N)、O(1)
 * 
 * @author wangyingbo
 *
 */
public class KLargest {

	// param k : description of k
	// param numbers : array of numbers
	// return: description of return
	public int kthLargestElement(int k, ArrayList<Integer> numbers) {
		// write your code here
		// write your code here
		if (numbers == null || k <= 0) {
			try {
				throw new Exception("argument exception");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		int size = numbers.size();
		int index = -1;
		int klarNum = size - k;
		int left = 0;
		int right = size - 1;

		while (klarNum != index) {
			index = partition(numbers, left, right);

			if (index < klarNum) {
				left = index + 1;
			} else if (index > klarNum) {
				right = index - 1;
			} else {
				break;
			}
		}

		return numbers.get(index);
	}
	
	private int partition(ArrayList<Integer> nums, int left, int right) {

		int index = right - left;
		int x = nums.get(left + index);
		int p = left - 1;

		for (int i = left; i < right; i++) {
			if (nums.get(i) <= x) {
				p++;
				exchange(nums, p, i);
			}
		}
		exchange(nums, p + 1, left + index);

		return p + 1;

	}

	private void exchange(ArrayList<Integer> nums, int i, int j) {
		int temp;
		temp = nums.get(j);
		nums.set(j, nums.get(i));
		nums.set(i, temp);
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(7);
		list.add(2);
		list.add(100);
		KLargest klar = new KLargest();
		int kl = klar.kthLargestElement(5, list);
		System.out.println(kl);
	}

}
