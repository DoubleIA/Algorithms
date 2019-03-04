package com.doubleia.alg.string;

/**
 * 
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * * Insert a character
 * * Delete a character
 * * Replace a character
 * 
 * Given word1 = "mart" and word2 = "karma", return 3.
 * 
 * @author wangyingbo
 *
 */
public class EditDistance {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
	public int minDistance(String word1, String word2) {
		// write your code here
		if (word1.length() == 0) return word2.length();
		if (word2.length() == 0) return word1.length();
		
		int[][] distance = new int[word1.length() + 1][word2.length() + 1];
		
		for (int i = 0; i <= word1.length(); i++)
			distance[i][0] = i;
		for (int i = 0; i <= word2.length(); i++)
			distance[0][i] = i;
		
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					distance[i][j] = distance[i - 1][j - 1];
				else
					distance[i][j] = min(distance[i - 1][j], distance[i][j - 1], distance[i - 1][j - 1]) + 1;
			}
		}
		
		return distance[word1.length()][word2.length()];
	}

	private int min(int i, int j, int k) {
		return Math.min(i, Math.min(j, k));
	}
	
	public static void main(String[] args) {
		EditDistance edit = new EditDistance();
		System.out.println(edit.minDistance("ac", "abcd"));
	}
}
