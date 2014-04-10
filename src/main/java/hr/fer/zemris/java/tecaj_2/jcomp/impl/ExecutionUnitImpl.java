package hr.fer.zemris.java.tecaj_2.jcomp.impl;

import hr.fer.zemris.java.tecaj_2.jcomp.Computer;
import hr.fer.zemris.java.tecaj_2.jcomp.ExecutionUnit;
import hr.fer.zemris.java.tecaj_2.jcomp.Instruction;

public class ExecutionUnitImpl implements ExecutionUnit {

	public ExecutionUnitImpl() {
		super();
	}

	@Override
	public boolean go(Computer computer) {
		computer.getRegisters().setProgramCounter(0);
		while (true) {
			try {
				Instruction instr = (Instruction) computer.getMemory()
						.getLocation(
								computer.getRegisters().getProgramCounter());
				computer.getRegisters().incrementProgramCounter();
				if (instr.execute(computer)) {
					break;
				}
			} catch (Exception e) {
				System.out
						.println("An error happened while executing assembly code.");
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

}
