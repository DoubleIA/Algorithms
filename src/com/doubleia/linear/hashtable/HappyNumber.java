package com.doubleia.linear.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Write an algorithm to determine if a number is happy.
 * 
 * A happy number is a number defined by the following process: 
 * Starting with any positive integer, replace the number by the sum of the squares of its digits, 
 * and repeat the process until the number equals 1 (where it will stay), 
 * or it loops endlessly in a cycle which does not include 1. 
 * Those numbers for which this process ends in 1 are happy numbers.
 * 
 * 19 is a happy number
 * 
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * 
 * @author wangyingbo
 *
 */
public class HappyNumber {
	/**
	 * @param n an integer
	 * @return true if this is a happy number or false
	 */
	public boolean isHappy(int n) {
		// Write your code here
		if (n < 1)
			return false;
		if (n == 1)
			return true;
		
		Set<Integer> set = new HashSet<Integer>();
		set.add(n);
		
		while (true) {
			int s = 0;
			while (n > 0) {
				s += (n % 10) * (n % 10);
				n = n /10;
			}
			if (s == 1)
				return true;
			if (set.contains(s))
				return false;
			n = s;
			set.add(s);
		}
		
	}
}
