package com.example;

public class MagicNumber {

    private static int sumOfDigits(int num) {
        
        int sum = 0;
        while (num > 0) {
            int temp = num % 10;
            num = num / 10;
            sum += temp;
        }
        return sum;
    }

    public static boolean isMagicNumber(int num) {

        int magicNumber = sumOfDigits(num);

        while (magicNumber / 10 != 0) {
            magicNumber = sumOfDigits(magicNumber);
        }

        return magicNumber == 1;
    }

    public static void main(String[] args) {
        int magicNumber = 164;
        System.out.println("The Number is magic Number: " + isMagicNumber(magicNumber));
    }
}
