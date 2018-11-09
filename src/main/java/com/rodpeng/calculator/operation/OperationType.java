package com.rodpeng.calculator.operation;

/**
 * Enum for all operation types.
 *  
 * @author ropeng
 *
 */
public enum OperationType {
	/**
	 * require no stack parameters
	 */
	ZERO, 
	
	/**
	 * require one stack parameter
	 */
	SINGLE, 
	
	/**
	 * require two stack parameters
	 */
	DOUBLE, 
	
	/**
	 * require all stack parameters
	 */
	ALL
}
