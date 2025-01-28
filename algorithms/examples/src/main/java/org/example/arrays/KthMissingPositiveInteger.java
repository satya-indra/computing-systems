package org.example.arrays;

import org.junit.Test;

public class KthMissingPositiveInteger {

    public Integer bruteForce(int[] input, int k) {

        // range will always start from 1 and go to last element which is max if kth elelemt is found between 1 and n or it'll be after last digit
        // for input 1,4,7,8 --> expands to 1,2,3,4,5,6,7,8 --> missing 4th will be 6. But missing 5th wil be --> 9
        // what it means is, for brute force, we start our loop from 1, and keeping going until we find the kth number.
        // we also need to keep count of how many we have found so far. If it exceeds the range, then we add the remaining in last number to get the kth value.
        int count = 0;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < input[input.length - 1]; i++ ) {
            if (i == input.length - 1) {
                int temp = input[input.length - 1];
                result = temp + (k - count);
                break;
            }
            int temp = input[i];
            if (temp != i  + 1) { // we have found ith missing number - which is actually i + 1
                if(count == k) {
                    result = i;
                    break;
                } else {
                    count++;
                }
            }
        }

        return result;
    }

    @Test
    public void bruteForceTest() {
        int[] input = {1,4,7,8}; // sorted
        int k = 4;
        System.out.println(bruteForce(input, k));
    }

}
