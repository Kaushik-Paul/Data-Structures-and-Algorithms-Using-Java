package com.example;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    // O(n) time and O(1) space
    public static List<String> getFizzBuzz(int num) {
        List<String> list = new ArrayList<>();
        for (int i = 1, fizz = 0, buzz = 0; i <= num; i++) {
            fizz++;
            buzz++;
            if (fizz == 3 && buzz == 5) {
                list.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            } else if (fizz == 3) {
                list.add("Fizz");
                fizz = 0;
            } else if (buzz == 5) {
                list.add("Buzz");
                buzz = 0;
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int num = 15;
        System.out.println("The Fizz Buzz List is: " + getFizzBuzz(num));
    }
}
