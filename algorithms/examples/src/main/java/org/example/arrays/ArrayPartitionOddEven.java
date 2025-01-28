package org.example.arrays;

import org.junit.Test;

public class ArrayPartitionOddEven {

    public int[] partition(int[] arr, int pivot, int low, int high) {
        int i = 0;
        int j = 0;
        while (i < high) {
            if (arr[i]%2 > 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            } else {
                i++;
            }
        }

        return arr;
    }

    @Test
    public void testPartition() {
        int[] arr = {1,2,3,4,5,6};
        int low = 0;
        int high = 0;

        int[] result = partition(arr, 1, low, arr.length - 1);


    }

}
