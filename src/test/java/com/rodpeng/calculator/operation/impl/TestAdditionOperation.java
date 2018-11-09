package com.rodpeng.calculator.operation.impl;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.rodpeng.calculator.OperationStack;
import com.rodpeng.calculator.operation.OperationType;


public class TestAdditionOperation {
	private AdditionOperation operation = new AdditionOperation(new OperationStack());
	
	@Test
	public void testGetOperator() {
		Assert.assertEquals("+", operation.getOperator());
	}
	
	@Test
	public void testGetOperationType() {
		Assert.assertEquals(OperationType.DOUBLE, operation.getOperationType());
	}
	
	@Test
	public void testOperate() {
		BigDecimal[] params = new BigDecimal[2];
		params[0] = new BigDecimal("1");
		params[1] = new BigDecimal("2");
		
		BigDecimal[] result = operation.operate(params);
		Assert.assertEquals(1, result.length);
		Assert.assertEquals(new BigDecimal("3"), result[0]);
	}
}
