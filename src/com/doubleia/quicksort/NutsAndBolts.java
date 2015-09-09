package com.doubleia.quicksort;

/**
 * public class NBCompare { public int cmp(String a, String b); } You can use
 * compare.cmp(a, b) to compare nuts "a" and bolts "b", if "a" is bigger than
 * "b", it will return 1, else if they are equal, it will return 0, else if "a"
 * is smaller than "b", it will return -1. When "a" is not a nut or "b" is not a
 * bolt, it will return 2, which is not valid.
 */
public class NutsAndBolts {
	/**
	 * @param nuts
	 *            : an array of integers
	 * @param bolts
	 *            : an array of integers
	 * @param compare
	 *            : a instance of Comparator
	 * @return: nothing
	 */
	public void sortNutsAndBolts(String[] nuts, String[] bolts,
			NBComparator compare) {
		// write your code here
		if (nuts.length == bolts.length) {
			matchPairs(nuts, bolts, 0, nuts.length - 1, compare);
		}
	}

	private void matchPairs(String[] nuts, String[] bolts, int left, int right,
			NBComparator compare) {
		if (left < right) {
			int index = partition(nuts, left, right, bolts[right], compare);

			partition(bolts, left, right, nuts[index], compare);

			matchPairs(nuts, bolts, 0, index - 1, compare);
			matchPairs(nuts, bolts, index + 1, right, compare);
		}
	}

	private int partition(String[] strs, int left, int right, String factor,
			NBComparator compare) {
		if (strs == null) {
			try {
				throw new Exception("argument null exception");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		int p = left - 1;

		for (int i = left; i < right; i++) {
			if (compare.cmp(strs[i], factor) == -1) {
				p++;
				exchange(strs, i, p);
			} else if (compare.cmp(strs[i], factor) == 0) {
				exchange(strs, i, right);
				i--;
			}
		}
		exchange(strs, p + 1, right);

		return p + 1;
	}

	private void exchange(String[] strs, int i, int j) {
		String temp = strs[i];
		strs[i] = strs[j];
		strs[j] = temp;
	}

	private static void printArrays(String[] arrays) {
		for (String array : arrays) {
			System.out.print(array + " ");
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
//		String nuts[] = { "@", "#", "$", "%", "^", "&" };
//		String bolts[] = { "$", "%", "&", "^", "@", "#" };
		String nuts[] = { "gg","ab","bc","dd" };
		String bolts[] = { "BC","GG","AB","DD" };
		NutsAndBolts nab = new NutsAndBolts();
		nab.sortNutsAndBolts(nuts, bolts, new NBComparator());
		printArrays(nuts);
		printArrays(bolts);
	}
}
