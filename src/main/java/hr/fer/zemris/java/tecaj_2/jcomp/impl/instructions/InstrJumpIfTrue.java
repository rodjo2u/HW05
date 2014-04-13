package hr.fer.zemris.java.tecaj_2.jcomp.impl.instructions;

import java.util.List;

import hr.fer.zemris.java.tecaj_2.jcomp.Computer;
import hr.fer.zemris.java.tecaj_2.jcomp.Instruction;
import hr.fer.zemris.java.tecaj_2.jcomp.InstructionArgument;

public class InstrJumpIfTrue implements Instruction {
	
	private int newProgramCounterValue;
	
	public InstrJumpIfTrue(List<InstructionArgument> arguments) {
		if (arguments.size() != 1) {
			throw new IllegalArgumentException("Expected 1 argument!");
		}
		if (!arguments.get(0).isNumber()) {
			throw new IllegalArgumentException("Type mismatch for argument 0!");
		}
		newProgramCounterValue = (Integer)arguments.get(0).getValue();
	}

	@Override
	public boolean execute(Computer computer) {
		if(computer.getRegisters().getFlag()) {
			computer.getRegisters().setProgramCounter(newProgramCounterValue);
		}
		return false;
	}

}
