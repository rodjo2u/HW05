package hr.fer.zemris.java.tecaj_2.jcomp.impl;

import hr.fer.zemris.java.tecaj_2.jcomp.Registers;

public class RegistersImpl implements Registers {

	private Object[] registers;
	private int programCounter;
	private boolean flag;

	public RegistersImpl(int regsLen) {
		registers = new Object[regsLen];
	}

	@Override
	public Object getRegisterValue(int index) {
		return registers[index];
	}

	@Override
	public void setRegisterValue(int index, Object value) {
		if (index < 0 || index > registers.length) {
			throw new IndexOutOfBoundsException(
					"You have tryed to access registry outside of legal registry range!");
		}
		registers[index] = value;
	}

	@Override
	public int getProgramCounter() {
		return programCounter;
	}

	/**
	 * @throws IllegalArgumentException
	 *             when <code>value</code> < 0
	 */
	@Override
	public void setProgramCounter(int value) {
		if (value < 0) {
			throw new IllegalArgumentException("Program counter must be > 0.");
		}
		programCounter = value;
	}

	@Override
	public void incrementProgramCounter() {
		programCounter += 1;
	}

	@Override
	public boolean getFlag() {
		return flag;
	}

	@Override
	public void setFlag(boolean value) {
		flag = value;

	}
}
