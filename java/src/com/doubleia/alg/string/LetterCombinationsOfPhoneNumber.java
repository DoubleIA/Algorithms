package com.doubleia.alg.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * 
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Given "23"
 * Return ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 * 
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 * 
 * @author wangyingbo
 *
 */
public class LetterCombinationsOfPhoneNumber {
	
	private Map<Character, Vector<Character>> dict = new HashMap<Character, Vector<Character>>();
	
	private ArrayList<String> res = new ArrayList<String>();	
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
	public ArrayList<String> letterCombinations(String digits) {
		// Write your code here
		if (digits == null || digits.length() == 0)
			return res;
		createDict();
		dfs(0, digits.length(), digits, "");
		
		return res;
	}
	
	private void createDict() {
		Vector<Character> vec2 = new Vector<Character>();
		vec2.add('a'); vec2.add('b'); vec2.add('c');
		dict.put('2', vec2);
		Vector<Character> vec3 = new Vector<Character>();
		vec3.add('d'); vec3.add('e'); vec3.add('f');
		dict.put('3', vec3);
		Vector<Character> vec4 = new Vector<Character>();
		vec4.add('g'); vec4.add('h'); vec4.add('i');
		dict.put('4', vec4);
		Vector<Character> vec5 = new Vector<Character>();
		vec5.add('j'); vec5.add('k'); vec5.add('l');
		dict.put('5', vec5);
		Vector<Character> vec6 = new Vector<Character>();
		vec6.add('m'); vec6.add('n'); vec6.add('o');
		dict.put('6', vec6);
		Vector<Character> vec7 = new Vector<Character>();
		vec7.add('p'); vec7.add('q'); vec7.add('r'); vec7.add('s');
		dict.put('7', vec7);
		Vector<Character> vec8 = new Vector<Character>();
		vec8.add('t'); vec8.add('u'); vec8.add('v');
		dict.put('8', vec8);
		Vector<Character> vec9 = new Vector<Character>();
		vec9.add('w'); vec9.add('x'); vec9.add('y'); vec9.add('z');
		dict.put('9', vec9);
	}
	
	private void dfs(int dep, int maxDep, String s, String ans) {
		if (dep == maxDep) {
			res.add(ans);
			return;
		}
		for (int i = 0; i < dict.get(s.charAt(dep)).size(); i++) {
			dfs(dep + 1, maxDep, s, ans + dict.get(s.charAt(dep)).get(i));
		}
	}
	
	public static void main(String[] args) {
		LetterCombinationsOfPhoneNumber let = new LetterCombinationsOfPhoneNumber();
		System.out.println(let.letterCombinations("23"));
	}
}
