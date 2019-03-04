package com.doubleia.srb.backtracking;

import java.util.ArrayList;

/**
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * Given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * @author wangyingbo
 *
 */
public class GenerateParentheses {
	/**
	 * @param n n pairs
	 * @return All combinations of well-formed parentheses
	 */
	public ArrayList<String> generateParenthesis(int n) {
		// Write your code here
		ArrayList<String>	res = new ArrayList<String>();
		if (n < 1)
		    return res;
		
		dfs("", n, n, res);
		
		return res;
	}

	private void dfs(String par, int left, int right, ArrayList<String> res) {
		if (left == right && left == 0) {
			res.add(par);
			return;
		}
		if (left == 0) {
			while (right > 0) {
				par += ")";
				right--;
			}
			dfs(par, 0, 0, res);
		} else {
			dfs(par + "(", left - 1, right, res);
			if (left < right) {
				dfs(par + ")", left, right - 1, res);
			}
		}
	}
	
	public static void main(String[] args) {
		GenerateParentheses gen = new GenerateParentheses();
		System.out.println(gen.generateParenthesis(5));
	}
}
