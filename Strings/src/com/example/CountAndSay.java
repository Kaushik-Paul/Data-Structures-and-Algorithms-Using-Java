package com.example;

public class CountAndSay {

    // O(n^2) time and O(n) space
    public static String countAndSay(int num) {
        String result = "1";
        // We already have one result which is above
        for (int i = 0; i < num - 1; i++) {
            char ch = result.charAt(0);
            int count = 1; // we already have one number
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) != ch) {
                    stringBuilder.append(count);
                    stringBuilder.append(ch);
                    count = 0;
                    ch = result.charAt(j);
                }
                count++;
            }
            stringBuilder.append(count);
            stringBuilder.append(ch);
            result = stringBuilder.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println("The Count for the Num is: " + countAndSay(num));
    }
}
