package org.example.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindAllUniquePermutationsArrayInteger {

    @Test
    public void testPermutations() {
        int[] arr = {1,2,3,4};
        List<int[]> per = new ArrayList<>();
        int[] result = findPermutations(arr, per, 0);
        System.out.println(per);
    }

    private int[] findPermutations(int[] arr, List<int[]> per, int index) {

        if(index == arr.length - 1) {
            return new int[arr.length - 1];
        }

        int[] ans = findPermutations(arr, per, ++index);
        ans[index - 1] = arr[index -1];
        per.add(ans);
        return ans;
    }

}
