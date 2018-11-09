package com.rodpeng.calculator.operation.impl;

import java.math.BigDecimal;

import com.rodpeng.calculator.OperationStack;
import com.rodpeng.calculator.operation.OperationType;

/**
 * Addition operation class.
 * 
 * @author ropeng
 *
 */
public class AdditionOperation extends AbstractOperation {

	public AdditionOperation(OperationStack operationStack) {
		super(operationStack, OperationType.DOUBLE, "+");
	}

	@Override
	public BigDecimal[] operate(BigDecimal[] operators) {
		BigDecimal[] result = new BigDecimal[1];
		result[0] = operators[0].add(operators[1]);
		
		return result;
	}

}
