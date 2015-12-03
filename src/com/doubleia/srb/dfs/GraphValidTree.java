package com.doubleia.srb.dfs;

/**
 * 
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to check whether these edges make up a valid tree.
 * 
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 * 
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
 * [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * 
 * @author wangyingbo
 *
 */
public class GraphValidTree {
	/**
	 * @param n an integer
	 * @param edges a list of undirected edges
	 * @return true if it's a valid tree, or false
	 */
	private int count = 0;
  
	private int[] s = null;  
	
	public boolean validTree(int n, int[][] edges) {
		// Write your code here
		initUnionFind(n);
		
		for (int i = 0; i < edges.length; i++) {
			if (!union(edges[i][0], edges[i][1]))
				return false;
		}
		
		count = 0;
		for (int i = 0; i < n; i++) {
			if (s[i] < 0)
				count++;
		}
		
		return count == 1;
	}
	
	public void initUnionFind(int n) {
		s = new int[n];
		for (int i = 0; i < n; i++)
			s[i] = -1;
	}

	public int find(int p) {
		if (s[p] < 0)
			return p;
		else {
			s[p] = find(s[p]);
			return s[p];
		}
	}
	
	public boolean union(int p, int q) {
		int pRoot = find(p), qRoot = find(q);
		if (pRoot == qRoot)
			return false;
		if (s[pRoot] < s[qRoot]) {
			s[pRoot] = qRoot;
		} else {
			if (s[qRoot] == s[pRoot])
				s[pRoot]--;
			s[qRoot] = pRoot;
		}
		return true;
	}

}
