package hr.fer.zemris.java.tecaj_2.jcomp;

import hr.fer.zemris.java.tecaj_2.jcomp.impl.ComputerImpl;
import hr.fer.zemris.java.tecaj_2.jcomp.impl.ExecutionUnitImpl;
import hr.fer.zemris.java.tecaj_2.jcomp.parser.InstructionCreatorImpl;
import hr.fer.zemris.java.tecaj_2.jcomp.parser.ProgramParser;

public class Simulator {

	public static void main(String[] args) {

		Computer comp = new ComputerImpl(256, 16);

		InstructionCreator creator = new InstructionCreatorImpl(
				"hr.fer.zemris.java.tecaj_2.jcomp.impl.instructions");

		try {
			ProgramParser.parse("examples/prim2.txt", comp, creator);
		} catch(Exception e) {
			System.out.println("Could not parse assembly code.");
			e.printStackTrace();
		}
		
		ExecutionUnit exec = new ExecutionUnitImpl();
		
		exec.go(comp);
		
	}

}
