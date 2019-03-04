package com.doubleia.alg.string;

/**
 * 
 * Implement function atoi to convert a string to an integer.
 * If no valid conversion could be performed, a zero value is returned. 
 * If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 * "10" => 10
 * "-1" => -1
 * "123123123123123" => 2147483647
 * "1.0" => 1
 * 
 * @author wangyingbo
 *
 */
public class StringToInteger {
    /**
     * @param str: A string
     * @return An integer
     */
	public int atoi(String str) {
		// write your code here
		if (str == null || str.trim().length() == 0)
			return 0;
		
		str = str.trim();
		char flag = '+';
		int p = 0;
		
		if (str.charAt(p) == '-') {
			flag = '-';
			p++;
		} else if (str.charAt(p) == '+') {
			p++;
		}
		
		double result = 0;
		
		while (str.length() > p && str.charAt(p) >= '0' && str.charAt(p) <= '9') {
			result = result * 10 + str.charAt(p) - '0';
			p++;
		}
		
		if (flag == '-')
			result = -result;
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		return (int)result;
	}
	
	public static void main(String[] args) {
		StringToInteger sti = new StringToInteger();
		System.out.println(sti.atoi("-123123123123123"));
	}
}
