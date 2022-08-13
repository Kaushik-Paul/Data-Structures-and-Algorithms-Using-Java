package com.example;

public class CaesarCipherEncryptor {

    public static String caesarCipherEncryptor(String string, int target) {
        char[] chars = string.toCharArray();
        target = target % 26;

        for (int i = 0; i < chars.length; i++) {
            chars[i] = getNewLetter(chars[i], target);
        }
        return new String(chars);
    }

    private static char getNewLetter(char ch, int target) {
        int num = ch + target;
        if (num > 122) {
            num = num - 26;
        } else if (num < 97) {
            num = num + 26;
        }
        return (char) num;
    }

    public static void main(String[] args) {
        String str = "xyz";
        System.out.println("The converted String of " + str + " is : " + caesarCipherEncryptor(str, 54));
        System.out.println("The converted String of " + str + " is : " + caesarCipherEncryptor(str, -2));
    }

}
