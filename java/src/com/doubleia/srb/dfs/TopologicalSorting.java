package com.doubleia.srb.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * Given an directed graph, a topological order of the graph nodes is defined as follow:
 * 
 * For each directed edge A -> B in graph, A must before B in the order list.
 * The first node in the order can be any node in the graph with no nodes direct to it.
 * 
 * Find any topological order for the given graph.
 * 
 * You can assume that there is at least one topological order in the graph.
 * 
 * Can you do it in both BFS and DFS?
 * 
 * @author wangyingbo
 *
 */
public class TopologicalSorting {
	/**
	 * @param graph: A list of Directed graph node
	 * @return: Any topological order for the given graph.
	 */
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
		// write your code here
		ArrayList<DirectedGraphNode> arrs = new ArrayList<DirectedGraphNode>();
		if (graph == null || graph.size() == 0)
			return arrs;
		
		Stack<DirectedGraphNode> stack = new Stack<DirectedGraphNode>();
	
		Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
		
		for (int i = 0; i < graph.size(); i++) 
			if (!visited.contains(graph.get(i)))
				topologicalSortUtil(graph.get(i), visited, stack);
		
		while (!stack.isEmpty())
			arrs.add(stack.pop());
		
		return arrs;
	}

	private void topologicalSortUtil(DirectedGraphNode node, Set<DirectedGraphNode> visited, Stack<DirectedGraphNode> stack) {
		visited.add(node);
		
		for (DirectedGraphNode gn : node.neighbors) 
			if (!visited.contains(gn)) 
				topologicalSortUtil(gn, visited, stack);
		
		stack.push(node);

	}
	
	
}
