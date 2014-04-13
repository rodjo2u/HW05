package hr.fer.zemris.java.tecaj.hw5.sorter.comparators;

import java.io.File;
import java.util.Comparator;

public class NameLengthComparator implements Comparator<File> {

	private int flag;

	/**
	 * Compares length of file names. Files with smaller names are shown first.
	 * 
	 * @param reverseOrder
	 *            If <code>reverseOrder</code> is <code>true</code> comparator will reverse the order of
	 *            elements.
	 */
	public NameLengthComparator(boolean reverseOrder) {
		if (reverseOrder) {
			flag = -1;
		} else {
			flag = 1;
		}
	}

	@Override
	public int compare(File o1, File o2) {
		if (o1.getName().length() > o2.getName().length()) {
			return 1 * flag;
		} else if (o1.getName().length() < o2.getName().length()) {
			return -1 * flag;
		}
		return 0;
	}

}
