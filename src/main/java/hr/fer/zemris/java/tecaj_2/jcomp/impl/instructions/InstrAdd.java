package hr.fer.zemris.java.tecaj_2.jcomp.impl.instructions;

import java.util.List;

import hr.fer.zemris.java.tecaj_2.jcomp.Computer;
import hr.fer.zemris.java.tecaj_2.jcomp.Instruction;
import hr.fer.zemris.java.tecaj_2.jcomp.InstructionArgument;

public class InstrAdd implements Instruction {
	
	private int registerIndex1;
	private int registerIndex2;
	private int registerIndex3;
	
	public InstrAdd(List<InstructionArgument> arguments) {
		if (arguments.size() != 3) {
			throw new IllegalArgumentException("Expected 3 arguments!");
		}
		if (!arguments.get(0).isRegister()) {
			throw new IllegalArgumentException("Type mismatch for argument 0!");
		}
		if (!arguments.get(1).isRegister()) {
			throw new IllegalArgumentException("Type mismatch for argument 1!");
		}
		if (!arguments.get(2).isRegister()) {
			throw new IllegalArgumentException("Type mismatch for argument 2!");
		}
		
		this.registerIndex1 = ((Integer) arguments.get(0).getValue())
				.intValue();
		this.registerIndex2 = ((Integer) arguments.get(1).getValue())
				.intValue();
		this.registerIndex3 = ((Integer) arguments.get(2).getValue())
				.intValue();
	}

	@Override
	public boolean execute(Computer computer) {
		Object value1 = computer.getRegisters()
				.getRegisterValue(registerIndex2);
		Object value2 = computer.getRegisters()
				.getRegisterValue(registerIndex3);
		computer.getRegisters().setRegisterValue(
				registerIndex1,
				Integer.valueOf(((Integer) value1).intValue()
						+ ((Integer) value2).intValue()));
		return false;
	}
}
