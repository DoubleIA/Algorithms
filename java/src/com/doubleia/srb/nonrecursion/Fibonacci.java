package com.doubleia.srb.nonrecursion;

/**
 * 
 * Find the Nth number in Fibonacci sequence.
 * 
 * A Fibonacci sequence is defined as follow:
 *
 ** The first two numbers are 0 and 1.
 ** The i th number is the sum of i-1 th number and i-2 th number.
 *
 * The first ten numbers in Fibonacci sequence is:
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
 * 
 * Given 1, return 0
 * Given 2, return 1
 * Given 10, return 34
 * 
 * The Nth fibonacci number won't exceed the max value of signed 32-bit integer in the test cases.
 * 
 * @author wangyingbo
 *
 */
public class Fibonacci {
	/**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
    	if (n <= 0)
    		return -1;
    	else if (n == 1)
    		return 0;
    	else if (n == 2 || n == 3)
    		return 1;
    	
    	
    	int left = 1;
    	int right = 1;
    	
    	for (int i = 3; i < n; i++) {
			int fi = left + right;
			left = right;
			right = fi;
		}
    	
    	return right;
    }
    
    public static void main(String[] args) {
		Fibonacci fi = new Fibonacci();
		System.out.println(fi.fibonacci(10));
	}
}
