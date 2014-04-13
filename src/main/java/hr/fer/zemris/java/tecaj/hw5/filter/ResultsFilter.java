package hr.fer.zemris.java.tecaj.hw5.filter;

import hr.fer.zemris.java.tecaj.hw5.filter.filters.*;

import java.io.File;
import java.io.FilenameFilter;
import java.util.LinkedList;
import java.util.List;

/**
 * Filters File by the give filters list criteria.
 * 
 * @author Igor Petkovski
 * 
 */
public class ResultsFilter {

	public static String filterRegex = "(-?s\\d+|-?l\\d+|f|e)";

	private List<String> filters;
	private FilenameFilter filenameFilter;

	public ResultsFilter(List<String> filters) {
		this.filters = filters;
	}

	public List<File> filterResults(List<File> files) {
		for (String filter : filters) {
			if (filter.startsWith("s")) {
				filenameFilter = new SizeFilenameFilter(Integer.parseInt(filter
						.substring(1)));
			}
			if (filter.startsWith("-s")) {
				filenameFilter = new ReverseSizeFilenameFilter(
						Integer.parseInt(filter.substring(2)));
			}
			if (filter.matches("f")) {
				filenameFilter = new FilesFilenameFilter();
			}
			if (filter.startsWith("l")) {
				filenameFilter = new NameLengthFilenameFilter(
						Integer.parseInt(filter.substring(1)));
			}
			if (filter.startsWith("-l")) {
				filenameFilter = new ReverseNameLengthFilenameFilter(
						Integer.parseInt(filter.substring(2)));
			}
			if (filter.matches("e")) {
				filenameFilter = new ExtensionFilenameFilter();
			}
			files = filterWithCurrentFilter(files);
		}
		return files;
	}

	/**
	 * Filters results with current instance of filename filter.
	 * 
	 * @param files
	 *            List<File> of files to be filtered.
	 * @return New List<File> of filtered results.
	 */
	private List<File> filterWithCurrentFilter(List<File> files) {
		List<File> results = new LinkedList<>();
		for (File file : files) {
			if (filenameFilter.accept(file, file.getName())) {
				results.add(file);
			}
		}
		return results;
	}
}
