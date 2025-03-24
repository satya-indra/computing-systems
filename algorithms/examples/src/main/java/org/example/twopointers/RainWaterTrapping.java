package org.example.twopointers;


/**
 * https://leetcode.com/problems/trapping-rain-water/description/
 */
public class RainWaterTrapping {

    public static void main(String[] args) {
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};

        int[] maxFromLeft = new int [input.length];
        // fill initial values
        maxFromLeft[0] = input[0];
        for (int i = 1; i < maxFromLeft.length ; i++) {
            maxFromLeft[i] = Math.max(input[i], maxFromLeft[i - 1]);
        }

        int[] maxFromRight = new int [input.length];
        // fill initial values
        maxFromRight[maxFromRight.length  - 1] = input[input.length - 1];
        for (int i = maxFromRight.length - 2; i >= 0; i--) {
            maxFromRight[i] = Math.max(input[i], maxFromRight[i  + 1]);
        }

        int totalCapacity = 0;

        for (int i = 0; i < input.length; i++) {
            if(i == 0 || i == input.length - 1) {
                continue;
            }
            int currVal = input[i];
            int trapped = Math.min(maxFromLeft[i], maxFromRight[i]) - currVal;
            totalCapacity+= trapped;
        }

        System.out.println(totalCapacity);

    }




}
