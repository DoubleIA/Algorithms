package com.doubleia.tree.trie;

import java.util.HashSet;

/**
 * 
 * @Date 2015.12.1
 * @author wangyingbo
 *
 */
public class DictTrieNode {
	public DictTrieNode[] childNodes;
	
	public int freq;
	
	public char charactor;
	
	public HashSet<Integer> set = new HashSet<Integer>();
	
	public DictTrieNode() {
		childNodes = new DictTrieNode[26];
		freq = 0;
	}
}
