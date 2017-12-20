package com.scavi.brainsqueeze.codefight.challenge;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class SortByZTest {
    @Test
    public void test1() {
        String[] input = new String[]{"Cow", "Chicken", "Deer", "Rabbit"};
        String[] expected = new String[]{"Rabbit", "Deer", "Chicken", "Cow"};

        String[] result = new SortByZ().SortByZ(input, 3);

        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void test2() {
        String[] input = new String[]{"bbb", "Cow", "Chicken", "Deer", "Rabbit"};
        String[] expected = new String[]{"bbb", "Rabbit", "Deer", "Chicken", "Cow"};

        String[] result = new SortByZ().SortByZ(input, 3);

        assertThat(result).isEqualTo(expected);
    }
}
