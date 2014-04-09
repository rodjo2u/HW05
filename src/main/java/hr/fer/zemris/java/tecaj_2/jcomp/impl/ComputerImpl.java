package hr.fer.zemris.java.tecaj_2.jcomp.impl;

import hr.fer.zemris.java.tecaj_2.jcomp.Computer;
import hr.fer.zemris.java.tecaj_2.jcomp.Memory;
import hr.fer.zemris.java.tecaj_2.jcomp.Registers;

public class ComputerImpl implements Computer {

	private MemoryImpl memory;
	private RegistersImpl registers;
	
	public ComputerImpl(int memorySize, int regsLen) {
		if (memorySize<1 || regsLen<1) {
			throw new IllegalArgumentException("Memory size and register length must me > 0");
		}
		memory = new MemoryImpl(memorySize);
		registers = new RegistersImpl(regsLen);
	}
	
	@Override
	public Registers getRegisters() {
		return registers;
	}

	@Override
	public Memory getMemory() {
		return memory;
	}

}
