package hr.fer.zemris.java.tecaj_2.jcomp.impl.instructions;

import java.util.List;

import hr.fer.zemris.java.tecaj_2.jcomp.Computer;
import hr.fer.zemris.java.tecaj_2.jcomp.Instruction;
import hr.fer.zemris.java.tecaj_2.jcomp.InstructionArgument;

public class InstrHalt implements Instruction{

	public InstrHalt(List<InstructionArgument> arguments) {
		super();
	}
	
	@Override
	public boolean execute(Computer computer) {
		return true;
	}

}
