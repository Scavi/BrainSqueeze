package com.scavi.brainsqueeze.dp;

import com.scavi.brainsqueeze.util.Pair;
import org.junit.Test;

import java.util.List;

import static com.google.common.truth.Truth.*;
import static com.scavi.brainsqueeze.dp.JobScheduling.Job;

public class JobSchedulingTest {
    @Test
    public void test1() {
        Pair<Integer, List<Integer>> result = new JobScheduling().findMaxLucrativeJobs(
                new Job(4, 6, 7),
                new Job(5, 4, 6),
                new Job(11, 5, 8),
                new Job(2, 7, 9),
                new Job(5, 1, 3),
                new Job(6, 2, 5));
        assertThat(result.getKey()).isEqualTo(17);
        assertThat(result.getValue().size()).isEqualTo(2);
        assertThat(result.getValue().get(0)).isEqualTo(1);
        assertThat(result.getValue().get(1)).isEqualTo(4);
    }

    @Test
    public void test2() {
        Pair<Integer, List<Integer>> result = new JobScheduling().findMaxLucrativeJobs(
                new Job(4, 6, 7),
                new Job(5, 4, 6),
                new Job(9, 5, 8),
                new Job(2, 7, 9),
                new Job(5, 1, 3),
                new Job(6, 2, 5));
        assertThat(result.getKey()).isEqualTo(16);
        assertThat(result.getValue().size()).isEqualTo(4);
        assertThat(result.getValue().get(0)).isEqualTo(0);
        assertThat(result.getValue().get(1)).isEqualTo(2);
        assertThat(result.getValue().get(2)).isEqualTo(3);
        assertThat(result.getValue().get(3)).isEqualTo(5);
    }
}
