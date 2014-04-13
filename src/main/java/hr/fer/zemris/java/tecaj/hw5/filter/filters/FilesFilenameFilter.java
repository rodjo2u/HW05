package hr.fer.zemris.java.tecaj.hw5.filter.filters;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Filter accepts <code>dir</code> only if it is a file, not a directory.
 * 
 * @author Igor Petkovski
 * 
 */
public class FilesFilenameFilter implements FilenameFilter {

	public FilesFilenameFilter() {
		super();
	}

	@Override
	public boolean accept(File dir, String name) {
		if (!dir.isFile()) {
			return false;
		}
		return true;
	}
}
