package com.scavi.brainsqueeze.codefight.arcade.graph;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class EfficientRoadNetworkTest {
    @Test
    public void test1() {
        int[][] roads = new int[][]{{3, 0}, {0, 4}, {5, 0}, {2, 1}, {1, 4}, {2, 3}, {5, 2}};
        boolean isEfficient = new EfficientRoadNetwork().efficientRoadNetwork(6, roads);
        assertThat(isEfficient).isTrue();
    }


    @Test
    public void test2() {
        int[][] roads = new int[][]{{0, 4}, {5, 0}, {2, 1}, {1, 4}, {2, 3}, {5, 2}};
        boolean isEfficient = new EfficientRoadNetwork().efficientRoadNetwork(6, roads);
        assertThat(isEfficient).isFalse();
    }
}
