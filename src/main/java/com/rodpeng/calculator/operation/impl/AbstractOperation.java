package com.rodpeng.calculator.operation.impl;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

import com.rodpeng.calculator.OperationStack;
import com.rodpeng.calculator.operation.InsufficientNumException;
import com.rodpeng.calculator.operation.Operation;
import com.rodpeng.calculator.operation.OperationType;

public abstract class AbstractOperation implements Operation {
	/**
	 * numbers to operate. 
	 */
	private BigDecimal[] nums;
	
	/**
	 * operation result. Both <code>nums</code> and <code>result</code> are also used to withdraw operation.
	 */
	private BigDecimal[] result;
	
	private OperationStack operationStack;
	private OperationType operationType;
	private String operator;
	
	public AbstractOperation(OperationStack operationStack, OperationType type) {
		this(operationStack, type, "");
	}
	
	public AbstractOperation(OperationStack operationStack, OperationType type, String operator) {
		this.operationStack = operationStack;
		this.operationType = type;
		this.operator = operator;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() throws InsufficientNumException {
		switch(operationType) {
		case SINGLE:
			nums = new BigDecimal[1];
			break;
		case ALL:
			nums = new BigDecimal[operationStack.size()];
			break;
		case DOUBLE:
			nums = new BigDecimal[2];
			break;
		case ZERO:
			nums = new BigDecimal[0];
			break;
		}
		
		try {
			operationStack.retrieve(nums);
		} catch (NoSuchElementException ex) {
			throw new InsufficientNumException(this);
		}
		result = operate(nums);
		
		if(result != null) {
			for(BigDecimal data : result) {
				if(data != null) {
					operationStack.add(data);
				}
			}
		}
	}
	
	/**
	 * operate function. Concrete implementation should implement this function properly.
	 * 
	 * @param numbers operation numbers
	 * @return result
	 */
	public abstract BigDecimal[] operate(BigDecimal[] numbers);
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() {
		if(result != null) {
			operationStack.retrieve(new BigDecimal[result.length]);
		}
		
		for(int i = nums.length - 1; i >= 0; i--) {
			operationStack.add(nums[i]);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getOperator() {
		return operator;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public OperationType getOperationType() {
		return operationType;
	}
}
