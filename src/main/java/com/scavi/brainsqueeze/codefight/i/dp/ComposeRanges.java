package com.scavi.brainsqueeze.codefight.i.dp;

import java.util.LinkedList;
import java.util.List;

public class ComposeRanges {
    /**
     * Given a sorted integer array that does not contain any duplicates, return a summary of the number ranges it
     * contains.
     *
     * @param nums
     * @return
     */
    String[] composeRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new String[0];
        } else if (nums.length == 1) {
            return new String[]{createResult(nums)};
        }
        List<String> result = new LinkedList<>();
        int lookup = nums.length - 1;
        int last = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i < lookup) {
                if (nums[i] + 1 != nums[i + 1]) {
                    if (i == last) {
                        result.add(createResult(nums[i]));
                    } else {
                        result.add(createResult(nums[last], nums[i]));
                    }
                    last = i + 1;
                }
            } else {
                if (i == last) {
                    result.add(createResult(nums[i]));
                } else {
                    result.add(createResult(nums[last], nums[i]));
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }


    private String createResult(int... params) {
        return params.length > 1 ?
                String.format("%d->%d", params[0], params[1]) :
                String.format("%d", params[0]);
    }
}
