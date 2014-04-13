package hr.fer.zemris.java.tecaj.hw5.sorter.comparators;

import java.io.File;
import java.util.Comparator;

public class TypeComparator implements Comparator<File>{

	private int flag;
	
	/**
	 * Compares types of Files lexicographically. Directories are shown first, files second.
	 * 
	 * @param reverseOrder
	 *            If <code>reverseOrder</code> is <code>true</code> comparator will reverse the order of
	 *            elements.
	 */
	public TypeComparator(boolean reverseOrder) {
		if (reverseOrder) {
			flag = -1;
		} else {
			flag = 1;
		}
	}
	
	@Override
	public int compare(File o1, File o2) {
		if (o1.isDirectory() && o2.isFile()) {
			return -1*flag;
		}
		if (o1.isFile() && o2.isDirectory()) {
			return 1*flag;
		}
		return 0;
	}

}
