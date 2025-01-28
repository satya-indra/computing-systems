package org.example.arrays;

import org.junit.Test;

public class KthLargestNumber {

    @Test
    public void bruteForce() {
        // simple sort the array
        // time complexity for sorting - nlogn
        // time complexity for finding the number - o(1)
        // total = 1 + nlogn = nlogn
    }

    @Test
    public void maxHeapApproach() {
        // first step to iterate over all the element and add in heap. --> time complexity - n
        // then we have to iterate over heap to find that element. timecomplexity for 1 pop = logn. hence for k element pop --> klogn
        // overall time complexity --> n + klogn
        // when will it be better than bruteForce ?
    }

    @Test
    public void quickSelectApproach() {
        /**
         * For a given k. First convert k to index. if k is 2, and we need to convert it to index.
         * if n is 5, k is 2, then index becomes ==> n-k = 3 i.e our answer will be at index 3
         * Solution steps
         * 1:
         *
         *
         *
         */
        int[] nums = {3,2,1,5,6,4};
        int k = 4;

        int[] result = quickSelect(nums, k);

        int ans = result[nums.length - k];

        System.out.println(ans);

    }

    private int[] quickSelect(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        int pivot = nums[high];

        int ptr = doQuickSelect(nums, low, high, k);
        return nums;

    }

    private int doQuickSelect(int[] nums, int low, int high, int k) {
        int pivot = nums[high];
        int ptr = partition(nums, pivot, low, high);

        if(k < nums.length - ptr) {
            return doQuickSelect(nums, ptr + 1, high, k);
        } else if( k > nums.length - ptr) {
            return doQuickSelect(nums, low, ptr - 1, k );
        } else {
            return nums[ptr];
        }

    }

    private int partition(int[] nums, int pivot, int low, int high) {
        int i = low;
        int j = low;
        while (i <= high) {
            if(nums[i] <= pivot) {
                // means we need to shift the number to left i.e swap
                swap(nums, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }

        return j - 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
