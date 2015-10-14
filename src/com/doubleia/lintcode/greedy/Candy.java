package com.doubleia.lintcode.greedy;

/**
 * 
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * * Each child must have at least one candy.
 * * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * 
 * Given ratings = [1, 2], return 3.
 * Given ratings = [1, 1, 1], return 3.
 * Given ratings = [1, 2, 2], return 4. ([1,2,1]).
 * 
 * @author wangyingbo
 *
 */
public class Candy {
	/**
     * @param ratings Children's ratings
     * @return the minimum candies you must give
     */
	public int candy(int[] ratings) {
		// Write your code here
		int length = ratings.length;
		if (length == 0)
			return 0;
		
		int[] candy = new int[length];
		
		for (int i = 0; i < length; i++) {
			candy[i] = 1;
		}
		
		for (int i = 1; i < length; i++) {
			if (ratings[i] > ratings[i - 1]) 
				candy[i] = candy[i - 1] + 1;
		}
		
		for (int i = length - 1; i > 0; i--) {
			if (ratings[i] < ratings[i - 1]) 
				candy[i - 1] = Math.max(candy[i - 1], candy[i] + 1);
		}
		
		int res = 0;
		for (int i = 0; i < length; i++) {
			res += candy[i];
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		Candy candy = new Candy();
		System.out.println(candy.candy(new int[]{4,2,3,4,1}));
	}
}
