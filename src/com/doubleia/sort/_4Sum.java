package com.doubleia.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * 
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤
 * b ≤ c ≤ d) The solution set must not contain duplicate quadruplets.
 * 
 * @author wangyingbo
 *
 */
public class _4Sum {

	/**
	 * @param numbers : Give an array numbersbers of n integer
	 * @param target : you need to find four elements that's sum of target
	 * @return : Find all unique quadruplets in the array which gives the sum of zero.
	 */
	public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
		// write your code here
		ArrayList<ArrayList<Integer>> _4Sum = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(numbers);
		
		for (int i = 0; i < numbers.length - 3; i++) {
			if (i > 0 && numbers[i] == numbers[i - 1]) {
				continue;
			}
			
			int tar = target - numbers[i];
			ArrayList<ArrayList<Integer>> list = threeSum(numbers, i, tar);
			for(ArrayList<Integer> li : list) {
				li.add(numbers[i]);
			}
			_4Sum.addAll(list);
		}
		
		for (ArrayList<Integer> sum : _4Sum) {
			Collections.sort(sum);
		}
		
		return _4Sum;
	}
	
	public ArrayList<ArrayList<Integer>> threeSum(int[] numbers, int start, int target) {
		ArrayList<ArrayList<Integer>> _3Sum = new ArrayList<ArrayList<Integer>>();
		
		
		for (int i = start + 1; i < numbers.length - 2; i++) {
			if (i > start + 1 && numbers[i] == numbers[i - 1]) {
				continue;
			}
			
			int tar = target - numbers[i];
			ArrayList<ArrayList<Integer>> list = twoSum(numbers, i, tar);
			for(ArrayList<Integer> li : list) {
				li.add(numbers[i]);
			}
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
				indices.add(numbers[left]);
				indices.add(numbers[right]);

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
	
	private static void printTriplets(ArrayList<ArrayList<Integer>> quadruplets) {
		for (Iterator<ArrayList<Integer>> iterator = quadruplets.iterator(); iterator.hasNext();) {
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
		
		int[] nums = {1,0,-1,-1,-1,-1,0,1,1,1,2};
		
		_4Sum sum = new _4Sum();
		results = sum.fourSum(nums, 2);
		
		printTriplets(results);
	}

}
