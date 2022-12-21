package com.example;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    // Solution provided by Nick White
    // https://www.youtube.com/watch?v=qBbZ3tS0McI&ab_channel=NickWhite
    public static List<String> generateParenthesis(int num) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, num);
        return list;
    }

    private static void backtrack(List<String> list, String currentString, int open, int close, int num) {
        if (currentString.length() == num * 2) {
            list.add(currentString);
            return;
        }
        if (open < num) {
            backtrack(list, currentString + "(", open + 1, close, num);
        }
        if (close < open) {
            backtrack(list, currentString + ")", open, close + 1, num);
        }
    }

    public static void main(String[] args) {
        int num = 3;
        System.out.println("Generated Parenthesis are: " + generateParenthesis(num));
    }
}
