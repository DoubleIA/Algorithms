package com.doubleia.linear.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



/**
 * 
 * Given an interval list which are flying and landing time of the flight. How many airplanes are on the sky at most?
 * For interval list [[1,10],[2,3],[5,8],[4,7]], return 3
 * 
 * If landing and flying happens at the same time, we consider landing should happen at first.
 * 
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 * @author wangyingbo
 *
 */
public class NumberofAirplanesInTheSky {
	/**
	 * @param intervals : An interval array
	 * @return: Count of airplanes are in the sky.
	 */
	public int countOfAirplanes(List<Interval> airplanes) {
		// write your code here
		List<Pair> pairs = new ArrayList<Pair>();
		
		for (Interval iter : airplanes) {
			pairs.add(new Pair(iter.start, true));
			pairs.add(new Pair(iter.end, false));
		}
		
		Collections.sort(pairs, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.key == o2.key)
					return o1.value ? 1 : -1;
				return o1.key - o2.key;
			}

		});
		
		int count = 0;
		int max = 0;
		for (Pair p : pairs) {
//			System.out.println(p.key + " " + p.value);
			if (p.value)
				count++;
			else 
				count--;
			max = Math.max(max, count);
		}
		
		return max;
	}
	
	class Pair {
		int key;
		boolean value;
		Pair(int key, boolean value) {
			this.key = key;
			this.value = value;
		}
	}
	
	
	public static void main(String[] args) {
		Interval a = new Interval(1, 2);
		Interval c = new Interval(2, 6);
		Interval b = new Interval(5, 15);
		Interval d = new Interval(15, 18);
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(d);
		intervals.add(b);
		intervals.add(c);
		intervals.add(a);
		NumberofAirplanesInTheSky num = new NumberofAirplanesInTheSky();
		System.out.println(num.countOfAirplanes(intervals));
	}
}
