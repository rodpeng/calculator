package com.rodpeng.calculator.operation.impl;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.rodpeng.calculator.OperationStack;
import com.rodpeng.calculator.operation.InsufficientNumException;
import com.rodpeng.calculator.operation.OperationType;

public class TestAbstractOperation {
	class MockOperation extends AbstractOperation {

		public MockOperation(OperationStack operationStack) {
			super(operationStack, OperationType.DOUBLE);
		}

		@Override
		public BigDecimal[] operate(BigDecimal[] numbers) {
			BigDecimal[] BigDecimal = new BigDecimal[1];
			BigDecimal[0] = numbers[0].add(numbers[1]);
			
			return BigDecimal;
		}
		
	}
	
	@Test
	public void testUndo() {
		OperationStack stack = new OperationStack();
		stack.add(new BigDecimal("1"));
		stack.add(new BigDecimal("2"));
		stack.add(new BigDecimal("3"));
		
		MockOperation operation = new MockOperation(stack);
		operation.execute();
		operation.undo();
		
		Assert.assertEquals(3, stack.size());
		BigDecimal[] content = new BigDecimal[3];
		stack.retrieve(content);
		
		Assert.assertEquals(new BigDecimal("3"), content[0]);
		Assert.assertEquals(new BigDecimal("2"), content[1]);
		Assert.assertEquals(new BigDecimal("1"), content[2]);
	}
	
	@Test
	public void testExecute() {
		OperationStack stack = new OperationStack();
		stack.add(new BigDecimal("1"));
		stack.add(new BigDecimal("2"));
		stack.add(new BigDecimal("3"));
		
		MockOperation operation = new MockOperation(stack);
		operation.execute();
		
		Assert.assertEquals(2, stack.size());
		BigDecimal[] content = new BigDecimal[2];
		stack.retrieve(content);
		
		Assert.assertEquals(new BigDecimal("5"), content[0]);
		Assert.assertEquals(new BigDecimal("1"), content[1]);
	}
	
	@Test(expected = InsufficientNumException.class)
	public void testExecuteWithNoSuchElementException() {
		OperationStack stack = new OperationStack();
		stack.add(new BigDecimal("1"));
		
		MockOperation operation = new MockOperation(stack);
		operation.execute();
	}
}
