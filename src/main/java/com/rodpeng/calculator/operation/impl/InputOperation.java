package com.rodpeng.calculator.operation.impl;

import java.math.BigDecimal;

import com.rodpeng.calculator.OperationStack;
import com.rodpeng.calculator.operation.OperationType;

/**
 * Parameter input operation class.
 * 
 * @author ropeng
 *
 */
public class InputOperation extends AbstractOperation {

	public InputOperation(OperationStack operationStack) {
		super(operationStack, OperationType.ZERO);
	}

	@Override
	public BigDecimal[] operate(BigDecimal[] operators) {
		BigDecimal[] result = new BigDecimal[1];
		
		return result;
	}

}
