package com.doubleia.alg.string;

/**
 * 
 * Given a (decimal - e.g. 3.72) number that is passed in as a string, return the binary representation 
 * that is passed in as a string. If the fractional part of the number can not be represented accurately 
 * in binary with at most 32 characters, return ERROR.
 * 
 * For n = "3.72", return "ERROR".
 * For n = "3.5", return "11.1".
 * 
 * @author wangyingbo
 *
 */
public class BinaryRepresentation {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
	public String binaryRepresentation(String n) {
		// write your code here
		int intPart = Integer.parseInt(n.substring(0, n.indexOf(".")));
		double decPart = Double.parseDouble(n.substring(n.indexOf(".")));
		String intStr = "";
		String decStr = "";
		
		if (intPart == 0) intStr = "0";
		while (intPart > 0) {
			int c = intPart % 2;
			intStr = c + intStr;
			intPart = intPart / 2;
		}
		
		while (decPart > 0.0) {
			if (decStr.length() > 32) return "ERROR";
			double r = decPart * 2;
			if (r >= 1.0) {
				decStr += "1";
				decPart = r - 1.0;
			} else {
				decStr += "0";
				decPart = r;
			}
		}
		
		return decStr.length() > 0 ? intStr + "." + decStr : intStr;
	}
	
	public static void main(String[] args) {
		BinaryRepresentation bin = new BinaryRepresentation();
		System.out.println(bin.binaryRepresentation("3.5"));
	}
}
