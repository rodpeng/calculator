package com.rodpeng.calculator.operation.impl;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.rodpeng.calculator.OperationStack;
import com.rodpeng.calculator.operation.OperationType;

public class TestDivisionOperation {
	private DivisionOperation operation = new DivisionOperation(new OperationStack());
	
	@Test
	public void testGetOperator() {
		Assert.assertEquals("/", operation.getOperator());
	}
	
	@Test
	public void testGetOperationType() {
		Assert.assertEquals(OperationType.DOUBLE, operation.getOperationType());
	}
	
	@Test
	public void testOperate() {
		BigDecimal[] params = new BigDecimal[2];
		params[0] = new BigDecimal("3");
		params[1] = new BigDecimal("6");
		
		BigDecimal[] result = operation.operate(params);
		Assert.assertEquals(1, result.length);
		Assert.assertEquals(new BigDecimal("2.0000000000"), result[0]);
	}
}
