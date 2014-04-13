package hr.fer.zemris.java.tecaj_2.jcomp.impl.instructions;

import java.util.List;

import hr.fer.zemris.java.tecaj_2.jcomp.Computer;
import hr.fer.zemris.java.tecaj_2.jcomp.Instruction;
import hr.fer.zemris.java.tecaj_2.jcomp.InstructionArgument;

public class InstrEcho implements Instruction {

	private Object parameter;
	private boolean isRegister;

	/**
	 * Writes out the value of the first and only argument to standard output.
	 * 
	 * @param arguments
	 *            Expects only 1 input argument.
	 * @throws IllegalArgumentException
	 *             when number of List arguments is != 1
	 */
	public InstrEcho(List<InstructionArgument> arguments) {
		if (arguments.size() != 1) {
			throw new IllegalArgumentException("Expected only 1 argument!");
		}

		if (arguments.get(0).isRegister()) {
			parameter = arguments.get(0).getValue();
			isRegister = true;
		} else {
			parameter = arguments.get(0).getValue();
		}
	}

	@Override
	public boolean execute(Computer computer) {
		if(isRegister) {
			System.out.print(computer.getRegisters().getRegisterValue((Integer)parameter));
		} else {
			System.out.print(parameter);
		}
		return false;
	}
}
