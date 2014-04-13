package hr.fer.zemris.java.tecaj_2.jcomp.impl.instructions;

import java.util.List;

import hr.fer.zemris.java.tecaj_2.jcomp.Computer;
import hr.fer.zemris.java.tecaj_2.jcomp.Instruction;
import hr.fer.zemris.java.tecaj_2.jcomp.InstructionArgument;

public class InstrLoad implements Instruction {

	private int registerIndex;
	private int memoryAddress;

	/**
	 * Creates new InstrLoad instance.
	 * 
	 * @param registerIndex
	 *            String in form of a rX, where X is a number
	 * @param memoryAddress
	 *            integer value >= 0
	 */
	public InstrLoad(List<InstructionArgument> arguments) {
		// check arguments
		if (arguments.size() != 2) {
			throw new IllegalArgumentException("Expected 2 arguments!");
		}
		if (!arguments.get(0).isRegister()) {
			throw new IllegalArgumentException("Type mismatch for argument 0!");
		}
		if (arguments.get(1).isRegister() || arguments.get(1).isString()) {
			throw new IllegalArgumentException("Type mismatch for argument 1!");
		}

		// do the job
		registerIndex = (Integer) arguments.get(0).getValue();
		memoryAddress = (Integer) arguments.get(1).getValue();

		if (memoryAddress < 0) {
			throw new IllegalArgumentException("Memory address must be >= 0");
		}
	}

	@Override
	public boolean execute(Computer computer) {
		computer.getRegisters().setRegisterValue(registerIndex, computer.getMemory().getLocation(memoryAddress));
		return false;
	}
}
