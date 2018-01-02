package com.scavi.brainsqueeze.codefight.arcade.graph;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class RoadsBuildingTest {
    @Test
    public void test1() {
        int[][] roads = new int[][]{{0, 1}, {1, 2}, {2, 0}};
        int[][] result = new RoadsBuilding().roadsBuilding(4, roads);
        int i = 0;
    }
}
