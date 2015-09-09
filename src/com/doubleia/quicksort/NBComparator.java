package com.doubleia.quicksort;

public class NBComparator {
	public int cmp(String a, String b) {
		int factor = a.compareToIgnoreCase(b);
		if (factor > 0)
			return 1;
		else if (factor < 0)
			return -1;
		else
			return 0; 
	}
	
	public static void main(String[] args) {
		NBComparator comp = new NBComparator();
		System.out.println(comp.cmp("abssss", "absdgs"));
	}
}
