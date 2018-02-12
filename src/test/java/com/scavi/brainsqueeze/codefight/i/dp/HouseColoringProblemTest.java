package com.scavi.brainsqueeze.codefight.i.dp;

import org.junit.Test;
import static com.google.common.truth.Truth.*;

public class HouseColoringProblemTest {

    @Test
    public void test1() {
        int[][] cost = new int[][] {{1, 3, 4}, {2, 3, 3}, {3, 1, 4}};
        int minPrice = new HouseColoringProblem().paintHouses(cost);
        assertThat(minPrice).isEqualTo(5);
    }
}
