package com.rodpeng.calculator;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

public class TestOperationStack {
	@Test
	public void testAdd() {
		OperationStack stack = new OperationStack();
		
		stack.add(new BigDecimal("2"));
		Assert.assertEquals(1, stack.size());
	}
	
	@Test
	public void testRetrieve() {
		OperationStack stack = new OperationStack();
		stack.add(new BigDecimal("2"));
		
		BigDecimal[] content = new BigDecimal[1];
		stack.retrieve(content);
		
		Assert.assertEquals(new BigDecimal("2"), content[0]);
		Assert.assertEquals(0, stack.size());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testRetrieveWithException() {
		OperationStack stack = new OperationStack();
		stack.add(new BigDecimal("2"));
		
		BigDecimal[] content = new BigDecimal[2];
		stack.retrieve(content);
	}
	
	@Test
	public void testRetrieveWithExceptionNoDataLost() {
		OperationStack stack = new OperationStack();
		stack.add(new BigDecimal("2"));
		
		BigDecimal[] content = new BigDecimal[2];
		try {
			stack.retrieve(content);
		} catch (Exception ex) {
		}
		
		Assert.assertEquals(1, stack.size());
	}
	
	@Test
	public void testToString() {
		OperationStack stack = new OperationStack();
		stack.add(new BigDecimal("2"));
		
		Assert.assertEquals("stack: 2", stack.toString());
	}
}
