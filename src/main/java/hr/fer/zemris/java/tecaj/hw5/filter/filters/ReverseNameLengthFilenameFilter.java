package hr.fer.zemris.java.tecaj.hw5.filter.filters;

import java.io.File;
import java.io.FilenameFilter;

public class ReverseNameLengthFilenameFilter implements FilenameFilter {

	private int size;
	
	public ReverseNameLengthFilenameFilter(int size) {
		this.size = size;
	}

	@Override
	public boolean accept(File dir, String name) {
		if (name.length() <= size) {
			return false;
		}
		return true;
		
	}
	
	
}
