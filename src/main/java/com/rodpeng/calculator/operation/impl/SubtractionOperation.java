package com.rodpeng.calculator.operation.impl;

import java.math.BigDecimal;

import com.rodpeng.calculator.OperationStack;
import com.rodpeng.calculator.operation.OperationType;

/**
 * Subtraction operation class.
 * 
 * @author ropeng
 *
 */
public class SubtractionOperation extends AbstractOperation {

	public SubtractionOperation(OperationStack operationStack) {
		super(operationStack, OperationType.DOUBLE, "-");
	}

	@Override
	public BigDecimal[] operate(BigDecimal[] operators) {
		BigDecimal[] result = new BigDecimal[1];
		result[0] = operators[1].subtract(operators[0]);
		
		return result;
	}

}
