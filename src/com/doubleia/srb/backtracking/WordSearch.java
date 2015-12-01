package com.doubleia.srb.backtracking;

/**
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * 
 * Given board =
 * 
 *  [
 *  "ABCE",
 *  "SFCS",
 *  "ADEE"
 *  ]
 *  
 *  word = "ABCCED", -> returns true,
 *  word = "SEE", -> returns true,
 *  word = "ABCB", -> returns false.
 * 
 * @author wangyingbo
 *
 */
public class WordSearch {
	/**
	 * @param board : A list of lists of character
	 * @param word : A string
	 * @return: A boolean
	 */
	public boolean exist(char[][] board, String word) {
		// write your code here
		if (word == null || word.length() == 0 || board == null || board.length == 0)
			return false;
		
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) 
			for (int j = 0; j < board[0].length; j++) 
				visited[i][j] = false;
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					visited[i][j] = true;
					if (word.length() == 1 || search(board, i, j, word.substring(1), visited))
						return true;
					visited[i][j] = false;
				}
			}
		}
		return false;
	}

	private boolean search(char[][] board, int i, int j, String word,
			boolean[][] visited) {
		if (word.length() == 0)
			return true;
		
		int[][] direction = {{-1,0}, {1,0}, {0,-1}, {0,1}};
		
		for (int k = 0; k < direction.length; k++) {
			int dx = i + direction[k][0];
			int dy = j + direction[k][1];
			if (dx >= 0 && dx < board.length && dy >= 0 && dy < board[i].length && board[dx][dy] == word.charAt(0) && !visited[dx][dy]) {
				visited[dx][dy] = true;
				if (word.length() == 1 || search(board, dx, dy, word.substring(1), visited))
					return true;
				visited[dx][dy] = false;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		WordSearch search = new WordSearch();
		char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(search.exist(board, "SEE"));
	}
}
