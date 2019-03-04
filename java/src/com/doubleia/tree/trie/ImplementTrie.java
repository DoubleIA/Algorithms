package com.doubleia.tree.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * @author wangyingbo
 *
 */
/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
public class ImplementTrie {
	private TrieNode root;

	public ImplementTrie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		Map<Character, TrieNode> children = root.children;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode t;
			if (children.containsKey(c)) {
				t = children.get(c);
			} else {
				t = new TrieNode(c);
				children.put(c, t);
			}
			children = t.children;
			if (word.length() - 1 == i)
				t.leaf = true;
		}
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode t = searchNode(word);
		return t != null && t.leaf;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		return searchNode(prefix) != null;
	}
	
	private TrieNode searchNode(String word) {
		Map<Character, TrieNode> children = root.children;
		TrieNode t = null;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!children.containsKey(c))
				return null;
			t = children.get(c);
			children = t.children;
		}
		return t;
	}
}

class TrieNode {
	// Initialize your data structure here.
	char c;
	
	boolean leaf;
	
	HashMap<Character, TrieNode> children;
	
	public TrieNode(char c) {
		this.c = c;
		leaf = false;
		children = new HashMap<Character, TrieNode>(); 
	}
	
	public TrieNode() {
		leaf = false;
		children = new HashMap<Character, TrieNode>(); 
	}
}

