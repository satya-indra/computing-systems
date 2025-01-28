package org.example.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 Example 1:
 Input: nums = [1,2,0]
 Output: 3
 Explanation: The numbers in the range [1,2] are all in the array.

 Example 2:
 Input: nums = [3,4,-1,1]
 Output: 2
 Explanation: 1 is in the array but 2 is missing.

 Example 3:
 Input: nums = [7,8,9,11,12]
 Output: 1
 Explanation: The smallest positive integer 1 is missing.

 Constraints:

 1 <= nums.length <= 105
 -231 <= nums[i] <= 231 - 1
 */
public class FirstMissingPositiveTest {

    private static int findUsingArraysAsExtraSpace(int[] input) {
        int ans = 1;

        // Iteration 1 --> mark all invalid input as ZERO
        for (int i = 0; i < input.length; i++) {
            if (input[i] < 1) {
               input[i] = 0;
            }
        }

        // Iteration 2 --> Use array index to mark element is already seen -->
        // read the value -> do value - 1 --> find index using that --> multiply i by -1.
        // What is that value is already marked as zero --> then mark it as ( arr.length + 1 )*-1
        for (int i = 1; i < input.length; i++) {
            int val = input[i - 1];
            int index = val - 1;
            if (val == 0) {
                input[index] = input[index]*-1;
            } else {
                input[index] = (input.length + 1)*-1;
            }
        }



        return ans;
    }

    private static int findUsingSet(int[] input) {
        // Iteration 1 : add elements in set -- space complexity --> N
        Set<Integer> set = Arrays.stream(input).filter(ele -> ele > 0).boxed().collect(Collectors.toSet());
        int ans = 1;
        // Iteration 2 : iterate over given input from 1 to total length and check if number is present or not.
        // Time complexity --> N
        for (; ans <= input.length; ans++) {
            if(!set.contains(ans)) {
                break;
            }
        }
        return ans;
    }

    private static int findUsingBruteForce(int[] input) {
        int[] ans = Arrays.stream(input).filter(ele -> ele > 0).sorted().toArray();
        int res = 1;
        for (;res <= ans.length; res++) {
            int index = res - 1;
            int currVal = ans[index];
            if(res != currVal) {
                break;
            }
        }
        return res;
    }

    @Test
    public void test1() {
        int[] input = {1,2,3};
//        int burteForceAnswer = findUsingBruteForce(input);
//        Assert.assertEquals(4, burteForceAnswer);
//
//        int setAnswer = findUsingSet(input);
//        Assert.assertEquals(4, setAnswer);


        int aAESpace = findUsingArraysAsExtraSpace(input);
        Assert.assertEquals(4, aAESpace);
    }

    @Test
    public void test2() {
        int[] input = {3,4,-1,1};
        int ans = findUsingBruteForce(input);
        Assert.assertEquals(2, ans);


        int setAnswer = findUsingSet(input);
        Assert.assertEquals(2, setAnswer);
    }

    @Test
    public void test3() {
        int[] input = {7,8,9,11,12};
        int ans = findUsingBruteForce(input);
        Assert.assertEquals(1, ans);


        int setAnswer = findUsingSet(input);
        Assert.assertEquals(1, setAnswer);
    }

}
