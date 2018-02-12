package com.scavi.brainsqueeze.codefight.i.hsq;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class MinStackProblemTest {

    @Test
    public void test1() {
        int[] expectedResult = new int[]{10, 5, 5, 5, 10};
        int[] result = new MinStackProblem().minimumOnStack(
                new String[]{
                        "push 10", "min", "push 5", "min", "push 8", "min", "pop", "min", "pop", "min"});
        assertThat(result).isEqualTo(expectedResult);
    }


    @Test
    public void test2() {
        int[] expectedResult = new int[]{10, 5, 5, 5, 10};
        int[] result = new MinStackProblem().minimumOnStack(
                new String[]{
                        "push 10", "min", "push 5", "min", "push 11", "min", "pop", "min", "pop", "min"});
        assertThat(result).isEqualTo(expectedResult);
    }
}
