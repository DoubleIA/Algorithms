package com.doubleia.linear.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * @author wangyingbo
 *
 */
public class ValidParentheses {
	/**
	 * @param s A string
	 * @return whether the string is a valid parentheses
	 */
	public boolean isValidParentheses(String s) {
		// Write your code here
		Stack<Character> stack = new Stack<Character>();
		
		Map<Character, Character> par = new HashMap<Character, Character>();
		par.put('(', ')');
		par.put('{', '}');
		par.put('[', ']');
		
		for (int i = 0; i < s.length(); i++) {
			if (par.containsKey(s.charAt(i)))
				stack.push(s.charAt(i));
			else if (!stack.isEmpty() && par.values().contains(s.charAt(i))) {
				if (!par.get(stack.pop()).equals(s.charAt(i)))
					return false;
			} else
				return false;
		}
		
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		ValidParentheses valid = new ValidParentheses();
		System.out.println(valid.isValidParentheses("[]*"));
	}
}
