package hr.fer.zemris.java.tecaj_2.jcomp.impl.instructions;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import hr.fer.zemris.java.tecaj_2.jcomp.Computer;
import hr.fer.zemris.java.tecaj_2.jcomp.Instruction;
import hr.fer.zemris.java.tecaj_2.jcomp.InstructionArgument;

public class InstrIinput implements Instruction {

	private int memoryLocation;
	
	public InstrIinput(List<InstructionArgument> arguments) {
		if (arguments.size() != 1) {
			throw new IllegalArgumentException("Expected 1 argument!");
		}
		if (!arguments.get(0).isNumber()) {
			throw new IllegalArgumentException("Type mismatch for argument 0!");
		}
		memoryLocation = (Integer)arguments.get(0).getValue();
	}

	@Override
	public boolean execute(Computer computer) {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(new BufferedInputStream(System.in))
				);
		try {
			int input = Integer.parseInt(reader.readLine());
			computer.getMemory().setLocation(memoryLocation, input);
			computer.getRegisters().setFlag(true);
		} catch (NumberFormatException e){
			System.out.println("");
			computer.getRegisters().setFlag(false);
		} catch (IOException e) {
			System.out.println("There was a problem reading from input stream. We are very sorry :(, please try again.");
			computer.getRegisters().setFlag(false);
		}
		return false;
	}
}
