package com.doubleia.tree.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word)
 * bool search(word)
 * 
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * 
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 
 * You may assume that all words are consist of lowercase letters a-z.
 * 
 * @author wangyingbo
 *
 */
public class AddAndSearchWord {
	private TrieNode root = new TrieNode();
	
	// Adds a word into the data structure.
	public void addWord(String word) {
		// Write your code here
		Map<Character, TrieNode> children = root.children;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode trie;
			if (children.containsKey(c)) {
				trie = children.get(c);
			} else {
				trie = new TrieNode(c);
				children.put(c, trie);
			}
			children = trie.children;
			if (word.length() - 1 == i)
				trie.leaf = true;
		}
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		// Write your code here
		return searchNode(word, root);
	}
	
	
	
	private boolean searchNode(String word, TrieNode trie) {
		if (trie == null)
			return false;
		if (word.length() == 0)
			return trie.leaf;
		
		Map<Character, TrieNode> children = trie.children;
		TrieNode tr = null;
		char c = word.charAt(0);
		if (c=='.') {
			for (char key : children.keySet()) {
				if (searchNode(word.substring(1), children.get(key)))
					return true;
			}
			return false;
		} else if (!children.containsKey(c)){
			return false;
		} else {
			tr = children.get(c);
			return searchNode(word.substring(1), tr);
		}
	}



	class TrieNode {
		char c;
		boolean leaf;
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		public TrieNode(char	c) {
			this.c = c;
			leaf = false;
		}
		public TrieNode(){leaf = false;};
	}
	
	public static void main(String[] args) {
		AddAndSearchWord aas = new AddAndSearchWord();
		aas.addWord("bad");
		aas.addWord("dad");
		aas.addWord("mad");
		System.out.println(aas.search("..d"));
	}
}

//Your WordDictionary object will be instantiated and called as such:
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("word");
//wordDictionary.search("pattern");
