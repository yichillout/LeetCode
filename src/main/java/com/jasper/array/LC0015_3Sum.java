package com.jasper.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0015_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    System.out.println(i + " " + l + " " + r);
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[l]);
                    tmp.add(nums[r]);
                    result.add(tmp);
                    l++;
                    r--;
                    while (l < r && nums[l - 1] == nums[l]) {
                        l++;
                    }
                    while (l < r && nums[r + 1] == nums[r]) {
                        r--;
                    }
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return result;
    }
}
