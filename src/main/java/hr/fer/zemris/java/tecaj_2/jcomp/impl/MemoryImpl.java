package hr.fer.zemris.java.tecaj_2.jcomp.impl;

import hr.fer.zemris.java.tecaj_2.jcomp.Memory;

public class MemoryImpl implements Memory {

	private Object[] memory;

	public MemoryImpl(int size) {
		memory = new Object[size];
	}

	/**
	 * {@link Memory}
	 * @throws IndexOutOfBoundsException
	 *             when location is outside of memory range from 0 to size-1
	 */
	@Override
	public void setLocation(int location, Object value) {
		if (location < 0 || location > memory.length-1) {
			throw new IndexOutOfBoundsException(
					"You have tryed to access memory locatio outside of memory range!");
		}
		memory[location] = value;
	}

	/**
	 * @throws IndexOutOfBoundsException
	 *             when location is outside of memory range from 0 to size-1
	 */
	@Override
	public Object getLocation(int location) {
		if (location < 0 || location > memory.length-1) {
			throw new IndexOutOfBoundsException(
					"You have tryed to access memory locatio outside of memory range!");
		}
		return memory[location];
	}

}
