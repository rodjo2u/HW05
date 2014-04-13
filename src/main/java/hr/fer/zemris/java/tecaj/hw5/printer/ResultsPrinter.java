package hr.fer.zemris.java.tecaj.hw5.printer;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ResultsPrinter {

	public static String printRegex = "(n|t|s|m|h)";
	private List<String> printSpecifiers;
	private int[] printSpecifiersLengths;
	
	public ResultsPrinter(List<String> printSpecifiers) {
		this.printSpecifiers = printSpecifiers;
		printSpecifiersLengths = new int[printSpecifiers.size()];
	}
	
	public void printResults(List<List<File>> results) {
		initializeSpecifierLengths(results);
		String frameLine = initializeFrameLine();
		System.out.println(frameLine);
		for (List<File> list : results) {
			for (File file : list) {
				printFile(file);
			}
		}
		System.out.println(frameLine);
	}
	
	private void initializeSpecifierLengths(List<List<File>> results) {
		for (List<File> list : results) {
			for (File file : list) {
				checkSpecifierList(file);
			}
		}
	}
	
	private void checkSpecifierList(File file) {
		for (int i=0; i < printSpecifiers.size(); i++) {
			switch (printSpecifiers.get(i)) {
				case ("n") :
					checkNameLength(file, i);
					break;
				case ("t") :
					printSpecifiersLengths[i] = 1;
					break;
				case ("s") :
					checkSizeLength(file, i);
					break;
				case ("m") :
					printSpecifiersLengths[i] = 19;
					break;
				case ("h") :
					printSpecifiersLengths[i] = 1;
					break;
			}
		}
	}
	
	private void checkNameLength(File file, int index) {
		if (file.getName().length() > printSpecifiersLengths[index]) {
			printSpecifiersLengths[index] = file.getName().length();
		}
	}
	
	private void checkSizeLength(File file, int index) {
		if ( (int)Math.ceil(Math.log10(file.length())) > printSpecifiersLengths[index]) {
			printSpecifiersLengths[index] = (int) Math.ceil(Math.log10(file.length()));
		}
	}

	private String initializeFrameLine() {
		String frameLine = "";
		for (int i=0; i < printSpecifiersLengths.length; i++) {
			frameLine += "-+-" + generatePadding("", "-", printSpecifiersLengths[i]);
		}
		frameLine += "-+";
		frameLine = frameLine.substring(1);
		
		return frameLine;
	}
	
	private String leftPadding(String str, String padding, int length) {
		padding = generatePadding(str, padding, length);
		return padding + str;
	}

	
	private String rightPadding(String str, String padding, int length) {
		padding = generatePadding(str, padding, length);
		return str + padding;
	}
	
	private String generatePadding(String str, String padding, int length) {
		String result = "";
		if (str.length() < length) {
			for(int i=0; i < length - str.length(); i++) {
				result += padding;
			}
		}
		return result;
	}
	
	private void printFile(File file) {
		String result = "| ";
		for (int i=0; i < printSpecifiers.size(); i++) {
			
			switch (printSpecifiers.get(i)) {
				case ("n") :
					result += rightPadding(file.getName(), " ", printSpecifiersLengths[i]) + " |";
					break;
				case ("t") :
					if (file.isDirectory()) {
						result += " d" + " |";
					} else {
						result += " f" + " |";
					}
					break;
				case ("s") :
					result += " " + leftPadding(String.valueOf(file.length()), " ", printSpecifiersLengths[i]) + " |";
					break;
				case ("m") :
						Date date = new Date(file.lastModified());
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						result += " " + sdf.format(date) + " |";
					break;
				case ("h") :
					if (file.isHidden()) {
						result += " d" + " |";
					} else {
						result += "   |";
					}
					break;
			}
		}
		System.out.println(result);
	}
}
