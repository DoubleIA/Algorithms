package com.doubleia.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * Given 4 points: (1,2), (3,6), (0,0), (1,3).
 * The maximum number is 3.
 * 
 * @author wangyingbo
 *
 */
public class MaxPointsOnALine {
	
	/**
	 * @param points an array of point
	 * @return an integer
	 */
	public int maxPoints(Point[] points) {
		// Write your code here
		if (points == null)
			return 0;
		if (points.length <= 2) {
			return points.length;
		}
		int maxC = 0;
		Map<Double, Integer> counts = new HashMap<Double, Integer>();
		for (int j = 0; j < points.length; j++) {
			Point basic = points[j];
			int verticalLine = 0;
			int basicCon = 0;
			for (int i = 0; i < points.length; i++) {
				if (points[i].x == basic.x) {
					verticalLine++;
					if (points[i].y == basic.y) 
						basicCon++;
				} else {
					Double scope = (double)(points[i].y - basic.y) / (double)(points[i].x - basic.x);
					
					if (counts.containsKey(scope)) {
						int c = counts.get(scope);
						counts.put(scope, c + 1);
					} else {
						counts.put(scope, 1);
					}
						
				}
			}
			
			for (double key : counts.keySet()) {
				maxC = Math.max(counts.get(key), maxC);
			}
			
			if (maxC  < verticalLine)
				maxC = verticalLine;
		}
		
		return maxC;
	}
	
	
	public static void main(String[] args) {
		Point points[] = {new Point(-4, -4),new Point(-8, -582),new Point(-9, -651),new Point(9, 591), new Point(-3, 3)};
		MaxPointsOnALine line = new MaxPointsOnALine();
		System.out.println(line.maxPoints(points));
		
	}

}
