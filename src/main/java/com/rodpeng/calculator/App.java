package com.rodpeng.calculator;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        CalculatorBoard board = new CalculatorBoard(scanner);
        board.process();
    }
}
