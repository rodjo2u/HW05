package hr.fer.zemris.java.tecaj_2.jcomp.impl.instructions;

import java.util.List;

import hr.fer.zemris.java.tecaj_2.jcomp.Computer;
import hr.fer.zemris.java.tecaj_2.jcomp.Instruction;
import hr.fer.zemris.java.tecaj_2.jcomp.InstructionArgument;

public class InstrTestEquals implements Instruction {

	private int registerIndex1;
	private int registerIndex2;
	
	public InstrTestEquals(List<InstructionArgument> arguments) {
		if (arguments.size() != 2) {
			throw new IllegalArgumentException("Expected 2 arguments!");
		}
		if (!arguments.get(0).isRegister()) {
			throw new IllegalArgumentException("Type mismatch for argument 0!");
		}
		if (!arguments.get(1).isRegister()) {
			throw new IllegalArgumentException("Type mismatch for argument 1!");
		}

		this.registerIndex1 = ((Integer) arguments.get(0).getValue())
				.intValue();
		this.registerIndex2 = ((Integer) arguments.get(1).getValue())
				.intValue();
	}

	@Override
	public boolean execute(Computer computer) {
		Object obj1 = computer.getRegisters().getRegisterValue(registerIndex1);
		Object obj2 = computer.getRegisters().getRegisterValue(registerIndex2);
		computer.getRegisters().setFlag(false);
		if (obj1.getClass() != obj2.getClass()) {
			return false;
		}
		if (obj1.toString().equals(obj2.toString())) {
			computer.getRegisters().setFlag(true);
		}
		return false;
	}
}
