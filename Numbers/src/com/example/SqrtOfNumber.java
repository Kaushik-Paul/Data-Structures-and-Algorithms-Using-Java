package com.example;

public class SqrtOfNumber {

    // O(log n) time and O(1) space
    public static int squareRootOfNumber(int num) {
        if (num == 0) {
            return 0;
        }
        int start = 1, end = num;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid <= num / mid && (mid + 1) > num / (mid + 1)) {
                return mid;
            } else if (mid < num / mid) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int num = 8;
        System.out.println("The Square root of the number is: " + squareRootOfNumber(num));
    }
}
