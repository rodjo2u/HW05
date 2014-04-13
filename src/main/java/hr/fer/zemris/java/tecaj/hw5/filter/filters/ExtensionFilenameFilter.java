package hr.fer.zemris.java.tecaj.hw5.filter.filters;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Filter accepts <code>dir</code> only if it is a file, not a directory.
 * 
 * @author Igor Petkovski
 * 
 */
public class ExtensionFilenameFilter implements FilenameFilter {

	public ExtensionFilenameFilter() {
		super();
	}

	@Override
	public boolean accept(File dir, String name) {
		if (name.lastIndexOf(".")>0 && name.length()>name.lastIndexOf(".")) {
			return true;
		}
		return false;
	}
}
