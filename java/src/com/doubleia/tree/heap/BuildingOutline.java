package com.doubleia.tree.heap;

import java.util.ArrayList;

/**
 * 
 * Given N buildings in a x-axis，each building is a rectangle and can be represented by a triple (start, end, height)，
 * where start is the start position on x-axis, end is the end position on x-axis and height is the height of the building.
 * Buildings may overlap if you see them from far away，find the outline of them。
 * 
 * An outline can be represented by a triple, (start, end, height), where start is the start position on x-axis of the outline, 
 * end is the end position on x-axis and height is the height of the outline.
 * 
 * Given 3 buildings：
 * 
 * * [
 * *   [1, 3, 3],
 * *   [2, 4, 4],
 * *   [5, 6, 1]
 * * ]
 * 
 * The outlines are：
 * 
 * * [
 * *   [1, 2, 3],
 * *   [2, 4, 4],
 * *   [5, 6, 1]
 * * ]
 * 
 * Please merge the adjacent outlines if they have the same height and make sure different outlines can't overlap on x-axis.
 * 
 * @author wangyingbo
 *
 */
public class BuildingOutline {
	
	/**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
    	ArrayList<ArrayList<Integer>> outlines = new ArrayList<ArrayList<Integer>>();
    	
    	
    	
    	return outlines;
    }
    
    

}
