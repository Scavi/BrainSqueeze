package com.scavi.brainsqueeze.codefight.i.hsq;

import org.junit.Test;
import static com.google.common.truth.Truth.*;

public class CloudCountTest {
    @Test
    public void test1() {
        char[][] skyMap = new char[][] {
                {'0', '1', '1', '0', '1'},
                {'0', '1', '1', '1', '1'},
                {'0', '0', '0', '0', '1'},
                {'1', '0', '0', '1', '1'}
        };
        int clouds = new CloudCount().countClouds(skyMap);
        assertThat(clouds).isEqualTo(2);
    }
}
