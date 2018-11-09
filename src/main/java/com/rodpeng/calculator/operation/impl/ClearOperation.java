package com.rodpeng.calculator.operation.impl;

import java.math.BigDecimal;

import com.rodpeng.calculator.OperationStack;
import com.rodpeng.calculator.operation.OperationType;

/**
 * Clear operation class.
 * 
 * @author ropeng
 *
 */
public class ClearOperation extends AbstractOperation {

	public ClearOperation(OperationStack operationStack) {
		super(operationStack, OperationType.ALL);
	}

	@Override
	public BigDecimal[] operate(BigDecimal[] operators) {
		return null;
	}

}
