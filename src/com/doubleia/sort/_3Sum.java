package com.doubleia.sort;

import java.util.ArrayList;
import java.util.Arrays;
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
		ArrayList<ArrayList<Integer>> _3Sum = new ArrayList<ArrayList<Integer>>();
		
		Arrays.sort(numbers);
		
		for (int i = 0; i < numbers.length - 2; i++) {
			if (i > 0 && numbers[i] == numbers[i - 1]) {
				continue;
			}
			
			int target = -numbers[i];
			ArrayList<ArrayList<Integer>> list = twoSum(numbers, i, target);
			_3Sum.addAll(list);
		}
		
		return _3Sum;
	}

	public ArrayList<ArrayList<Integer>> twoSum(int[] numbers, int start, int target) {

		ArrayList<ArrayList<Integer>> _2Sum = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> indices = null;
		
		int left = start + 1;
		int right = numbers.length - 1;
		while (left < right) {
			indices = new ArrayList<Integer>();
			int sum = numbers[left] + numbers[right];
			if (sum == target) {
				if (-target <= numbers[left]) {
					indices.add(-target);
					indices.add(numbers[left]);
					indices.add(numbers[right]);
				} else if (-target >= numbers[right]) {
					indices.add(numbers[left]);
					indices.add(numbers[right]);
					indices.add(-target);
				} else {
					indices.add(numbers[left]);
					indices.add(-target);
					indices.add(numbers[right]);
				}

				if (!_2Sum.contains(indices)) {
					_2Sum.add(indices);
				}
				
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
		
		int[] nums = {1,0,-1,-1,-1,-1,0,1,1,1};
		
		_3Sum sum = new _3Sum();
		results = sum.threeSum(nums);
		
		printTriplets(results);
	}
	
}
