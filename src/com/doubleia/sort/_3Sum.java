package com.doubleia.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * @author wangyingbo
 *
 */
public class _3Sum {
	
	/**
	 * @param numbers : Give an array numbers of n integer
	 * @return : Find all unique triplets in the array which gives the sum of zero.
	 */
	public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
		// write your code here
		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> _3Sum = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < numbers.length; i++) {
			nums.add(numbers[i]);
		}
		
		for (int i = 0; i < numbers.length; i++) {
			int target = -numbers[i];
			
			nums.remove((Integer)numbers[i]);
			ArrayList<ArrayList<Integer>> list = twoSum(nums, target);
			nums.add(numbers[i]);
			
			_3Sum.addAll(list);
		}
		
		
		return _3Sum;
	}

	public ArrayList<ArrayList<Integer>> twoSum(ArrayList<Integer> numbers, int target) {

		Collections.sort(numbers);

		ArrayList<ArrayList<Integer>> _2Sum = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> indices = new ArrayList<Integer>();;
				
		int left = 0;
		int right = numbers.size() - 1;
		while (left < right) {
			int sum = numbers.get(left) + numbers.get(right);
			if (sum == target) {
				if (-target <= numbers.get(left)) {
					indices.add(-target);
					indices.add(numbers.get(left));
					indices.add(numbers.get(right));
				} else if (-target >= numbers.get(right)) {
					indices.add(numbers.get(left));
					indices.add(numbers.get(right));
					indices.add(-target);
				} else {
					indices.add(numbers.get(left));
					indices.add(-target);
					indices.add(numbers.get(right));
				}

			
				_2Sum.add(indices);
				
				left++;
				right--;
			} else if (sum < target)   {
				left++;
			} else {
				right--;
			}
 		}
		return _2Sum;
	}
	
	private static void printTriplets(ArrayList<ArrayList<Integer>> triplets) {
		for (Iterator<ArrayList<Integer>> iterator = triplets.iterator(); iterator.hasNext();) {
			ArrayList<Integer> ints = iterator.next();
			System.out.print("(");
			for (Iterator<Integer> iter = ints.iterator(); iter.hasNext();) {
				System.out.print(iter.next());
				if (iter.hasNext()) {
					System.out.print(", ");
				}
			}
			System.out.print(")\n");
		}
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		
/*		ArrayList<Integer> li1 = new ArrayList<Integer>();
		li1.add(1);
		li1.add(2);
		li1.add(3);
		ArrayList<Integer> li2 = new ArrayList<Integer>();
		li2.add(4);
		li2.add(5);
		li2.add(6);
		
		results.add(li1);
		results.add(li2);*/
		
		int[] nums = { 5, 3, 7, 1, 0, -8, 9 };
		
		_3Sum sum = new _3Sum();
		results = sum.threeSum(nums);
		
		printTriplets(results);
	}
	
}
