package com.example;

public class SquareRoot {

    // O(log sqrt(x)) time and O(1) space
    public static int squareRootOfTheNumber(int num) {
        int low = 0;
        int high = num;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid * mid <= num) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int num = 8;
        System.out.println("The Square root of the number is: " + squareRootOfTheNumber(num));
    }
}
