package hr.fer.zemris.java.tecaj.hw5.sorter;

import hr.fer.zemris.java.tecaj.hw5.sorter.comparators.*;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ResultsSorter {

	public static String sortRegex = "(-?s|-?n|-?m|-?t|-?l|-?e)";
	
	private List<String> sorts;
	private Comparator<File> comparator;

	/**
	 * Class for sorting list of files by given list of sort specificators.
	 * 
	 * @param sorts
	 *            List of sort specificators.
	 */
	public ResultsSorter(List<String> sorts) {
		this.sorts = sorts;
	}

	/**
	 * For submitted sorter instantiates appropriate comparator and sorts Files.
	 * 
	 * @param sortResults
	 *            List<List<Files>> to sort
	 * @return new sorted List<List<File>>
	 */
	public List<List<File>> sortResults(List<List<File>> sortResults) {
		for (String sort : sorts) {
			if (sort.startsWith("s")) {
				comparator = new SizeComparator(false);
			}
			if (sort.startsWith("-s")) {
				comparator = new SizeComparator(true);
			}
			if (sort.startsWith("n")) {
				comparator = new NameComparator(false);
			}
			if (sort.startsWith("-n")) {
				comparator = new NameComparator(true);
			}
			if (sort.startsWith("m")) {
				comparator = new LastModifiedComparator(false);
			}
			if (sort.startsWith("-m")) {
				comparator = new LastModifiedComparator(true);
			}
			if (sort.startsWith("t")) {
				comparator = new TypeComparator(false);
			}
			if (sort.startsWith("-t")) {
				comparator = new TypeComparator(true);
			}
			if (sort.startsWith("l")) {
				comparator = new NameLengthComparator(false);
			}
			if (sort.startsWith("-l")) {
				comparator = new NameLengthComparator(true);
			}
			if (sort.startsWith("e")) {
				comparator = new ExecutableComparator(false);
			}
			if (sort.startsWith("-e")) {
				comparator = new ExecutableComparator(true);
			}
			for (List<File> list : sortResults) {
				Collections.sort(list, comparator);
			}
			sortResults = separateSameSortResults(sortResults);
		}

		return sortResults;
	}

	/**
	 * Groups up results to which comparator returns value 0 into same
	 * List<File> for further sorting.
	 * 
	 * @param results
	 *            List<List<File>> list of lists that contain values to which
	 *            comparator returns value 0
	 * @return new List<List<File>> with sorted results
	 */
	private List<List<File>> separateSameSortResults(List<List<File>> results) {

		List<List<File>> listOfLists = new LinkedList<>();
		List<File> sortedResultsList = null;

		for (List<File> sameSortResult : results) {
			sortedResultsList = new LinkedList<>();
			for (File file : sameSortResult) {
				if (sortedResultsList.size() == 0) {
					sortedResultsList.add(file);
				} else {
					if (comparator
							.compare(sortedResultsList.get(sortedResultsList
									.size() - 1), file) == 0) {
						sortedResultsList.add(file);
					} else {
						listOfLists.add(sortedResultsList);
						sortedResultsList = new LinkedList<File>();
						sortedResultsList.add(file);
					}
				}
			}
			if (sortedResultsList.size() > 0) {
				listOfLists.add(sortedResultsList);
			}
		}
		return listOfLists;
	}
}
