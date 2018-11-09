package com.rodpeng.calculator.operation.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.rodpeng.calculator.OperationStack;
import com.rodpeng.calculator.operation.OperationType;

/**
 * Division operation class.
 * 
 * @author ropeng
 *
 */
public class DivisionOperation extends AbstractOperation {

	public DivisionOperation(OperationStack operationStack) {
		super(operationStack, OperationType.DOUBLE, "/");
	}

	@Override
	public BigDecimal[] operate(BigDecimal[] operators) {
		BigDecimal[] result = new BigDecimal[1];
		result[0] = operators[1].divide(operators[0], 10, RoundingMode.DOWN);
		
		return result;
	}

}
