package com.scavi.brainsqueeze.codefight.i.dp;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class MapDecodingTest {
    @Test
    public void test1() {
        int result = new MapDecoding().mapDecoding("123");
        assertThat(result).isEqualTo(3);
    }


    @Test
    public void test2() {
        int result = new MapDecoding().mapDecoding("1001");
        assertThat(result).isEqualTo(0);
    }


    @Test
    public void test3() {
        int result = new MapDecoding().mapDecoding("2871221111122261");
        assertThat(result).isEqualTo(233);
    }



    @Test
    public void test4() {
        int result = new MapDecoding().mapDecoding("301");
        assertThat(result).isEqualTo(0);
    }
}
