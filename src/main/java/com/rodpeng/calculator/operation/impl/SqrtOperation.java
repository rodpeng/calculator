package com.rodpeng.calculator.operation.impl;

import java.math.BigDecimal;

import com.rodpeng.calculator.OperationStack;
import com.rodpeng.calculator.operation.OperationType;

/**
 * Sqrt operation class.
 * 
 * @author ropeng
 *
 */
public class SqrtOperation extends AbstractOperation {

	public SqrtOperation(OperationStack operationStack) {
		super(operationStack, OperationType.SINGLE, "sqrt");
	}

	@Override
	public BigDecimal[] operate(BigDecimal[] operators) {
		BigDecimal[] result = new BigDecimal[1];
		double value = Math.sqrt(operators[0].doubleValue());
		result[0] = BigDecimal.valueOf(value);
		
		return result;
	}

}
