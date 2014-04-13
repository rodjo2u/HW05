package hr.fer.zemris.java.tecaj.hw5;

import hr.fer.zemris.java.tecaj.hw5.filter.ResultsFilter;
import hr.fer.zemris.java.tecaj.hw5.printer.ResultsPrinter;
import hr.fer.zemris.java.tecaj.hw5.sorter.ResultsSorter;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/******************************************************************************
 * 
 * This class implements command line program for working with directories.
 * Program implements single command line function which takes in a list of
 * arguments. Program takes input argument and writes out directories in
 * compliance with provided arguments.
 * <p>
 * First argument is imperative, and is always a file system path. Rest of the
 * parameters are not obligatory. Rest of the parameters represent filters,
 * sorters and information output options for output results.
 * </p>
 * <p>
 * TODO explain sort , output and filter parameters
 * </p>
 * <p>
 * TODO usage example
 * </p>
 * 
 * @author Igor Petkovski
 * @version 1.0
 */
public class Dir {

	private static List<String> filtersList = new LinkedList<>();
	private static List<String> sortersList = new LinkedList<>();
	private static List<String> printList = new LinkedList<>();

	public static void main(String[] args) {
		// Check input parameters
		if (args.length < 1) {
			System.out.println("Please provide root directory path!");
			System.exit(-1);
		}

		File file = new File(args[0]);
		if (!file.isDirectory()) {
			System.out.println("Given 'path' is not directory!");
			System.exit(-1);
		}

		if(args.length == 1) {
			args[0] = "-w:n";
			parseInputSpecificators(args);
		}
		parseInputSpecificators(Arrays.copyOfRange(args, 1, args.length));
		
		// Filter results
		List<File> filteredResults;
		ResultsFilter filter = new ResultsFilter(filtersList);
		filteredResults = filter.filterResults(Arrays.asList(file.listFiles()));
		
		// Sort results
		List<List<File>> sortedResults = new LinkedList<>();
		sortedResults.add(filteredResults);
		ResultsSorter sorter = new ResultsSorter(sortersList);
		sortedResults = sorter.sortResults(sortedResults);
		
		ResultsPrinter rp = new ResultsPrinter(printList);
		rp.printResults(sortedResults);
		
		//printResults(sortedResults);
	}

	/**
	 * This method parses input string. While parsing checks for user errors,
	 * and if there are none adds all specifiers to appropriate list: filters,
	 * sorters or print specifiers.
	 * 
	 * If specifiers contain non legal values, program stops executing with
	 * appropriate message.
	 * 
	 * @param specificators
	 *            Array of strings containing specifiers for filtering, sorting
	 *            and printing.
	 */
	private static void parseInputSpecificators(String[] specificators) {
		String[] specificator;
		for (String s : specificators) {
			specificator = s.split(":");
			switch (specificator[0]) {
				case ("-f") :
					if (specificator[1].matches(ResultsFilter.filterRegex)) {
						filtersList.add(specificator[1]);
					} else {
						System.out.println("There is no filter specificator: "
								+ specificator[1]);
						System.exit(-1);
					}
					break;
				case ("-s") :
					if (specificator[1].matches(ResultsSorter.sortRegex)) {
						sortersList.add(specificator[1]);
					} else {
						System.out.println("There is no sort specificator: "
								+ specificator[1]);
						System.exit(-1);
					}
					break;
				case ("-w") :
					if (specificator[1].matches(ResultsPrinter.printRegex)) {
						printList.add(specificator[1]);
					} else {
						System.out.println("There is no print specificator: "
								+ specificator[1]);
						System.exit(-1);
					}
					break;
				default : {
					System.out.println("Unsupported specificator: " + s);
					System.exit(-1);
				}
			}
		}
	}
	
	private static void printResults(List<List<File>> results) {
		for (List<File> list : results) {
			for (File file :list) {
				System.out.println(file.getName());
			}
			
		}
	}

}
