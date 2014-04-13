package hr.fer.zemris.java.tecaj_2.jcomp.impl.instructions;

import hr.fer.zemris.java.tecaj_2.jcomp.Computer;
import hr.fer.zemris.java.tecaj_2.jcomp.Instruction;
import hr.fer.zemris.java.tecaj_2.jcomp.InstructionArgument;

import java.util.List;

public class InstrIncrement implements Instruction {

	private int registerIndex;

	public InstrIncrement(List<InstructionArgument> arguments) {
		if (arguments.size() != 1) {
			throw new IllegalArgumentException("Expected 1 argument!");
		}
		if (!arguments.get(0).isRegister()) {
			throw new IllegalArgumentException("Type mismatch for argument 0!");
		}
		this.registerIndex = ((Integer) arguments.get(0).getValue())
				.intValue();
	}

	@Override
	public boolean execute(Computer computer) {
		computer.getRegisters().setRegisterValue(
				registerIndex,
				(Integer) computer.getRegisters().getRegisterValue(
						registerIndex) + 1);
		return false;
	}
}
