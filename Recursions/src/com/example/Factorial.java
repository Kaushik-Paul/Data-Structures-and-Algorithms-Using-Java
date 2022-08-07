package com.example;

public class Factorial {

    public static int getFactorial(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * getFactorial(num - 1);
    }

    public static void main(String[] args) {
        int factorialNum = 5;
        System.out.println("The Factorial of " + factorialNum + " is: " + getFactorial(factorialNum));
    }
}
