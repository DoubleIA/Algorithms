package com.doubleia.linear.stack;

import java.util.Stack;

/**
 * 
 * Implement a stack with min() function, which will return the smallest number in the stack.
 * 
 * It should support push, pop and min operation all in O(1) cost.
 * 
 * push(1)
 * pop()   // return 1
 * push(2)
 * push(3)
 * min()   // return 2
 * push(1)
 * min()   // return 1
 * 
 * min operation will never be called if there is no number in the stack.
 * 
 * @author wangyingbo
 *
 */
public class MinStack {
	private Stack<Integer> stack;
	
	private Stack<Integer> m_stack;
	
	public MinStack() {
		// do initialize if necessary
		stack = new Stack<Integer>();
		m_stack = new Stack<Integer>();
	}

	public void push(int number) {
		// write your code here
		if (m_stack.isEmpty() || number < m_stack.peek())
			m_stack.push(number);
		stack.push(number);
	}

	public int pop() {
		// write your code here
		if (m_stack.peek().equals(stack.peek()))
			m_stack.pop();
		return stack.pop();
	}

	public int min() {
		// write your code here
		return m_stack.peek();
	}
	
	public static void main(String[] args) {
		MinStack min = new MinStack();
		min.push(152);
		System.out.println(min.pop());
		min.push(163);
		System.out.println(min.min());
/*		min.push(1);
		System.out.println(min.min());*/
	}
}
