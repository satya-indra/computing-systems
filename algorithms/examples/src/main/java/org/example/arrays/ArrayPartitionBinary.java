package org.example.arrays;

import org.junit.Test;

public class ArrayPartitionBinary {

    public int[] partition(int[] arr, int pivot, int low, int high) {
        int i = 0;
        int j = 0;
        while (i < high) {
            if (arr[i] < pivot) {
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
        int[] arr = {1,0,0,1,0,1};
        int low = 0;
        int high = 0;

        int[] result = partition(arr, 1, low, arr.length - 1);


    }

}
