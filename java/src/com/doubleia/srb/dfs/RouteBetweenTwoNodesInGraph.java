package com.doubleia.srb.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 * 
 * Given graph:
 * 
 * A----->B----->C
 *   \       |
 *    \      |
 *     \     |
 *     \  v
 *      ->D----->E
 * 
 * for s = B and t = E, return true
 * for s = D and t = C, return false
 * 
 * @author wangyingbo
 *
 */
public class RouteBetweenTwoNodesInGraph {
	/**
	 * @param graph : A list of Directed graph node
	 * @param s : the starting Directed graph node
	 * @param t : the terminal Directed graph node
	 * @return: a boolean value
	 */
	public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
		// write your code here
		if (s != null && s == t)
			return true;
		if (graph == null || graph.size() == 0 || s == null || s.neighbors == null || s.neighbors.size() == 0)
			return false;
		
		Queue<DirectedGraphNode> stack = new LinkedList<DirectedGraphNode>();
		stack.add(s);
		
		while (!stack.isEmpty()) {
			for (DirectedGraphNode node : stack.peek().neighbors) {
				if (node == t)
					return true;
				stack.add(node);
			}
			stack.poll();
		}
		
		return false;
	}
}
