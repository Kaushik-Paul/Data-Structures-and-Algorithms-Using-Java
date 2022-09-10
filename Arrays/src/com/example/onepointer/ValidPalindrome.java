package com.example.onepointer;

public class ValidPalindrome {

    public static boolean isValidPalindrome(String string) {
        int left = 0;
        int right = string.length() - 1;

        while (left < right) {
            if (!Character.isLetterOrDigit(string.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(string.charAt(right))) {
                right--;
                continue;
            }
            if (Character.toLowerCase(string.charAt(left)) != Character.toLowerCase(string.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String string = "A man, a plan, a canal: Panama";
        System.out.println("Is it Valid Palindrome: " + isValidPalindrome(string));
    }
}
