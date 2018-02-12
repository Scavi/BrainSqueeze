package com.scavi.brainsqueeze.codefight.i.g;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class DeadlockAnalyseTest {
    @Test
    public void test1() {
        int[][] graph = new int[][]{
                {1},
                {2},
                {3, 4},
                {4},
                {0}
        };
        assertThat(new DeadlockAnalyse().hasDeadlock(graph)).isTrue();
    }


    @Test
    public void test2() {
        int[][] graph = new int[][]{
                {1, 2, 3},
                {2, 3},
                {3},
                {}
        };
        assertThat(new DeadlockAnalyse().hasDeadlock(graph)).isFalse();
    }
}
