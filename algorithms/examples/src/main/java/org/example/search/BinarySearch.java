package org.example.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] input = {1,2,5,6,8,9,10,15,20};
        int target = 30;
        int answer = binarySearch(input, target);
        System.out.println(answer);
    }

    public static int binarySearch(int[] input, int target) {
        int left = 0;
        int right = input.length  - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (input[mid] == target) {
                return mid;
            } else if (target < input[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
