package com.rodpeng.calculator.operation;

import com.rodpeng.calculator.operation.impl.AdditionOperation;
import com.rodpeng.calculator.operation.impl.ClearOperation;
import com.rodpeng.calculator.operation.impl.DivisionOperation;
import com.rodpeng.calculator.operation.impl.InputOperation;
import com.rodpeng.calculator.operation.impl.MultiplicationOperation;
import com.rodpeng.calculator.operation.impl.SqrtOperation;
import com.rodpeng.calculator.operation.impl.SubtractionOperation;

/**
 * The interface defines all functions for every single operations. Concrete implementation should extend this interface.
 * <br/>
 * To execute corresponding operation, the function {@link #execute()} should be invoked; To undo it, the function {@link #undo()} should be invoked.
 * 
 * @see 
 * 	{@link AdditionOperation}
 *  {@link ClearOperation}
 *  {@link DivisionOperation}
 *  {@link InputOperation}
 *  {@link MultiplicationOperation}
 *  {@link SqrtOperation}
 *  {@link SubtractionOperation}
 * 
 * @author ropeng
 *
 */
public interface Operation {
	/**
	 * execute operation.
	 * 
	 * @throws InsufficientNumException while no enough parameters to operate on
	 */
	public void execute();
	
	/**
	 * withdraw operation.
	 */
	public void undo();
	
	/**
	 * return operation representative.
	 * @return operation representative
	 */
	public String getOperator();
	
	/**
	 * return operation type.
	 * @return operation type
	 */
	public OperationType getOperationType();
}
