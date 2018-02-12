package com.scavi.brainsqueeze.codefight.i.dp;

public class HouseRoboter {
    /**
     * You are planning to rob houses on a specific street, and you know that every house on the street has a certain
     * amount of money hidden. The only thing stopping you from robbing all of them in one night is that adjacent
     * houses on the street have a connected security system. The system will automatically trigger an alarm if two
     * adjacent houses are broken into on the same night.
     * <p>
     * Given a list of non-negative integers nums representing the amount of money hidden in each house, determine
     * the maximum amount of money you can rob in one night without triggering an alarm.
     *
     * @param nums
     * @return
     */
    int houseRobber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 2; i < nums.length; ++i) {
            nums[i] = Math.max(nums[i - 2], i > 2 ? nums[i - 3] : 0) + nums[i];
        }
        return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
    }
}
