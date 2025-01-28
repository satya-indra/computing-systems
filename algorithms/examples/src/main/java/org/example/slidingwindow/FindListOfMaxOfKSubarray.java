package org.example.slidingwindow;

import java.util.*;
import java.util.stream.Stream;

public class FindListOfMaxOfKSubarray {

    public static void main(String[] args) {
        int[] arr = {41, 7, 9, 21};
        int k = 3;

        int[] ans = doSomething(arr, 0, k);

        List<Integer> list = doSomethingBetter(arr, k);
        list.forEach(System.out::println);

    }

    private static List<Integer> doSomethingBetter(int[] arr, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
            if (i >= k - 1) {
                int temp = heap.poll();
                ans.add(temp);
            }
        }

        return ans;
    }

    private static int[] doSomething(int[] arr, int start, int k) {
        if (k - 1 == arr.length && start == 1) {
            return arr;
        }

        if (k > arr.length) {
            return new int[start];
        }

        int[] ans = doSomething(arr, start + 1, k + 1);
        int max = Integer.MIN_VALUE;
        for (int curr = start; curr < k; curr++) {
            max = Math.max(max, arr[curr]);
        }

        ans[start] = max;

        return ans;
    }
}
