package com.rodpeng.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class OperationStack {
	private Deque<BigDecimal> numbers = new ArrayDeque<>();
	
	public void add(BigDecimal num) {
		numbers.add(num);
	}
	
	public void retrieve(BigDecimal[] nums) {
		try {
			for(int i = 0; i < nums.length; i++) {
				nums[i] = numbers.removeLast();
			}
		} catch (NoSuchElementException ex) {
			for(int i = nums.length - 1; i >= 0; i--) {
				if(nums[i] != null) {
					numbers.add(nums[i]);
				}
			}
			
			throw ex;
		}
	}
	
	public int size() {
		return this.numbers.size();
	}
	
	@Override
	public String toString() {
		return "stack: " + numbers.stream().map(num -> {
				try {
					num.longValueExact();
					return num.toPlainString();
				} catch (Exception ex) {
					return num.setScale(10, RoundingMode.DOWN).toPlainString();
				}
			}).collect(Collectors.joining(" "));
	}
}
