package hr.fer.zemris.java.tecaj.hw5.sorter.comparators;

import java.io.File;
import java.util.Comparator;

public class ExecutableComparator implements Comparator<File>{

	private int flag;
	
	/**
	 * Compares canExecute of files. Executable files are shown first.
	 * 
	 * @param reverseOrder
	 *            If <code>reverseOrder</code> is <code>true</code> comparator will reverse the order of
	 *            elements.
	 */
	public ExecutableComparator(boolean reverseOrder) {
		if (reverseOrder) {
			flag = 1;
		} else {
			flag = -1;
		}
	}
	@Override
	public int compare(File o1, File o2) {
		if (o1.canExecute() && !o2.canExecute()) {
			return -1*flag;
		} else if (!o1.canExecute() && o2.canExecute()) {
			return 1*flag;
		}
		return 0;
	}

}
