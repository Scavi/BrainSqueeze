package com.scavi.brainsqueeze.career;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class TemperatureLookupTest {
    @Test
    public void test1() {
        int[] temperatures = new int[]{73, 74, 75, 71, 70, 76, 72};
        int[] expected = new int[]{1, 1, 3, 2, 1, -1, -1};
        int[] output = new TemperatureLookup().findWarmerDays(temperatures);
        assertThat(output).isEqualTo(expected);
    }


    @Test
    public void test2() {
        int[] temperatures = new int[]{73, 74, 75, 70, 71, 76};
        int[] expected = new int[]{1, 1, 3, 1, 1, -1};
        int[] output = new TemperatureLookup().findWarmerDays(temperatures);
        assertThat(output).isEqualTo(expected);
    }

    @Test
    public void test3() {
        int[] temperatures = new int[]{73, 10, 15};
        int[] expected = new int[]{-1, 1, -1};
        int[] output = new TemperatureLookup().findWarmerDays(temperatures);
        assertThat(output).isEqualTo(expected);
    }


    @Test
    public void test4() {
        int[] temperatures = new int[]{73, 74, 75, 71, 70, 76, 72, 74, 10, 15};
        int[] expected = new int[]{1, 1, 3, 2, 1, -1, 1, -1, 1, -1};
        int[] output = new TemperatureLookup().findWarmerDays(temperatures);
        assertThat(output).isEqualTo(expected);
    }
}
