package com.example;

public class ValidPalindrome {

    // O(n) time and O(1) space
    public static boolean isValidPalindrome(String string) {
        int left = 0, right = string.length() - 1;
        while (left < right) {
            char charLeft = string.charAt(left);
            char charRight = string.charAt(right);
            if (!Character.isLetterOrDigit(charLeft)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(charRight)) {
                right--;
                continue;
            }
            if (Character.toLowerCase(charLeft) != Character.toLowerCase(charRight)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String string = "A man, a plan, a canal: Panama";
        System.out.println("Is the String Palindrome: " + isValidPalindrome(string));
    }
}
