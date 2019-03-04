package com.doubleia.alg.string;

/**
 * 
 * Validate if a given string is numeric.
 * 
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * 
 * 有限状态机： M = (Q, Σ, δ, q0, F)
 * 
 * @author wangyingbo
 *
 */
public class ValidNumber {
    /**
     * @param s the string that represents a number
     * @return whether the string is a valid number
     */
	public boolean isNumber(String s) {
		// Write your code here
		if (s.length() == 0) return false;
		
		int state = 0;
		
		int transitionTable[][] = {
			// INVALID SPACE SIGN DIGIT DOT EXPOENT
				{-1,    0,    3,   1,    2,  -1},     // state 0 可接受空格 符号 点号 数字 E
				{-1,    8,   -1,   1,    4,   5},     // state 1 可接受空格（终止状态） "."号和"E"
				{-1,   -1,   -1,   4,   -1,  -1},     // state 2 上一个输入为"."号 只接受数字
				{-1,   -1,   -1,   1,    2,  -1},     // state 3 上一个输入为"+"号或"-"号 可接受数字和点号
				{-1,    8,   -1,   4,   -1,   5},     // state 4 可接受空格（终止状态）数字或"E"
				{-1,   -1,    6,   7,   -1,  -1},     // state 5 上一个输入为E/e 可接受符号 数字 点号
				{-1,   -1,   -1,   7,   -1,  -1},     // state 6 
				{-1,    8,   -1,   7,   -1,  -1},     // state 7
				{-1,    8,   -1,  -1,   -1,  -1}      // state 8
		};
		
		for (int i = 0; i < s.length(); i++) {
			InputType type = InputType.INVALID;
			if (s.charAt(i) == ' ')
				type = InputType.SPACE;
			else if (s.charAt(i) == '+' || s.charAt(i) == '-')
				type = InputType.SIGN;
			else if (Character.isDigit(s.charAt(i)))
				type = InputType.DIGIT;
			else if (s.charAt(i) == '.')
				type = InputType.DOT;
			else if (s.charAt(i) == 'e' || s.charAt(i) == 'E')
				type = InputType.EXPONENT;
			
			state = transitionTable[state][type.getType()];
			
			if (state == -1) return false;
		}
		
		
		return state == 1 || state == 4 || state == 7 || state == 8;
	}
	
	enum InputType {
		INVALID(0),
		
		SPACE(1),
		
		SIGN(2),
		
		DIGIT(3),
		
		DOT(4),
		
		EXPONENT(5);
		
		private int type;
		
		private InputType(int type) {
			this.type = type;
		}
		
		private int getType() {
			return type;
		}
	}
	
	public static void main(String[] args) {
		ValidNumber val = new ValidNumber();
		System.out.println(val.isNumber("2e10"));
	}
}
