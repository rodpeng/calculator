package com.rodpeng.calculator.operation;

public class InsufficientNumException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8937785599195489015L;
	
	private Operation operation;

	public InsufficientNumException(Operation operation) {
		super();
		this.operation = operation;
	}

	public Operation getOperation() {
		return operation;
	}
}
