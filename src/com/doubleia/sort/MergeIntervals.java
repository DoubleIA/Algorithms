package com.doubleia.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * O(nlogn)、O(1)
 * 
 * @author wangyingbo
 *
 */
public class MergeIntervals {
	/**
	 * @param intervals
	 *            : Sorted interval list.
	 * @return: A new sorted interval list.
	 */
	public List<Interval> merge(List<Interval> intervals) {
		// write your code here
		if (intervals == null || intervals.isEmpty()) {
			return intervals;
		}

		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}

		});

		Interval pre = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (pre.end >= curr.start) {
				pre.end = Math.max(curr.end, pre.end);
				intervals.remove(i);
				i--;
			} else {
				pre = curr;
			}
		}

		return intervals;
	}

	private static void printIntervalList(List<Interval> intervals) {
		Iterator<Interval> iter = intervals.iterator();
		System.out.println("[");
		while (iter.hasNext()) {
			Interval in = iter.next();
			System.out.print("	[" + in.start + ", " + in.end + "]");
			if (iter.hasNext()) {
				System.out.print(",");
			}
			System.out.print("\n");
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		// [1,3],[2,6],[8,10],[15,18],
		Interval a = new Interval(1, 16);
		Interval c = new Interval(2, 6);
		Interval b = new Interval(5, 10);
		Interval d = new Interval(15, 18);
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(a);
		intervals.add(b);
		intervals.add(c);
		intervals.add(d);
		printIntervalList(intervals);
		MergeIntervals m = new MergeIntervals();
		m.merge(intervals);
		printIntervalList(intervals);
	}
}
