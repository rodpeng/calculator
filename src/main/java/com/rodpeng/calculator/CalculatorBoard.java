package com.rodpeng.calculator;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.rodpeng.calculator.operation.InsufficientNumException;
import com.rodpeng.calculator.operation.Operation;
import com.rodpeng.calculator.operation.impl.AdditionOperation;
import com.rodpeng.calculator.operation.impl.ClearOperation;
import com.rodpeng.calculator.operation.impl.DivisionOperation;
import com.rodpeng.calculator.operation.impl.InputOperation;
import com.rodpeng.calculator.operation.impl.MultiplicationOperation;
import com.rodpeng.calculator.operation.impl.SqrtOperation;
import com.rodpeng.calculator.operation.impl.SubtractionOperation;

public class CalculatorBoard {
	private Scanner scanner;
	
	private OperationStack stack = new OperationStack();
	private Deque<Operation> operationList = new ArrayDeque<>();
	
	public CalculatorBoard(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void process() {
		while(this.scanner.hasNextLine()) {
			String originLine = this.scanner.nextLine();
			String line = originLine.trim() ;
			
			if(line.equals("q!")) {
				break;
			} else if (line.equals("")) {
				continue;
			}
			
			String[] params = line.split("\\s");
			int i = 0;
			
			try {
				for(; i < params.length; i++) {
					String param = params[i];
					if(param.equals("+")) {
						Operation operation = new AdditionOperation(stack);
						operation.execute();
						operationList.push(operation);
					} else if(param.equals("-")) {
						Operation operation = new SubtractionOperation(stack);
						operation.execute();
						operationList.push(operation);
					} else if (param.equals("*")) {
						Operation operation = new MultiplicationOperation(stack);
						operation.execute();
						operationList.push(operation);
					} else if (param.equals("/")) {
						Operation operation = new DivisionOperation(stack);
						operation.execute();
						operationList.push(operation);
					} else if (param.equals("sqrt")) {
						Operation operation = new SqrtOperation(stack);
						operation.execute();
						operationList.push(operation);
					} else if (param.equals("clear")) {
						Operation operation = new ClearOperation(stack);
						operation.execute();
						operationList.push(operation);
					} else if (param.equals("undo")) {
						Operation operation = operationList.pop();
						operation.undo();
					} else {
						stack.add(new BigDecimal(param));
						Operation operation = new InputOperation(stack);
						operation.execute();
						operationList.push(operation);
					}
				}
			} catch (InsufficientNumException e) {
				String operator = e.getOperation().getOperator();
				
				int count = 0;
				for(int j = 0; j <= i; j++) {
					if(params[j].equals(operator)) {
						count++;
					}
				}
				
				int index = originLine.indexOf(operator);
				for(int k = 1; k < count; k++) {
					index = originLine.indexOf(operator, index + 1);
				}
				
				System.out.println(String.format("operator %s(position: %d): insucient parameters", operator, index + 1));
			} catch (NumberFormatException ex) {
				System.out.println("Unknown operator");
			}
			
			System.out.println(stack);
		}
	}
}
