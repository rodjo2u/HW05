package hr.fer.zemris.java.tecaj_2.jcomp.impl.instructions;

import java.util.List;

import hr.fer.zemris.java.tecaj_2.jcomp.Computer;
import hr.fer.zemris.java.tecaj_2.jcomp.Instruction;
import hr.fer.zemris.java.tecaj_2.jcomp.InstructionArgument;

public class InstrLoad implements Instruction{

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
		// TODO check input arguments
		
		registerIndex = (Integer)arguments.get(0).getValue();
		memoryAddress = (Integer)arguments.get(1).getValue();
		
		if (memoryAddress < 0) {
			throw new IllegalArgumentException("Memory address must be >= 0");
		}
		
		/*
		if (!registerIndex.startsWith("r")) {
			throw new IllegalArgumentException(
					"Register index must have prefix 'r', and then number value.");
		}
*/
		this.memoryAddress = memoryAddress;
	}

	@Override
	public boolean execute(Computer computer) {
		Object value = computer.getRegisters().getRegisterValue(registerIndex);
		value = computer.getMemory().getLocation(registerIndex);
		return false;
	}
}
