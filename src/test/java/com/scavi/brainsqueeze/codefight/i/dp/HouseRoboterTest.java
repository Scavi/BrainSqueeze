package com.scavi.brainsqueeze.codefight.i.dp;

import org.junit.Test;

import static com.google.common.truth.Truth.*;


public class HouseRoboterTest {
    @Test
    public void test1() {
        int max = new HouseRoboter().houseRobber(new int[]{5, 0, 1, 0, 1, 100});
        assertThat(max).isEqualTo(106);
    }
}
