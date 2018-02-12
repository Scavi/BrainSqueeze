package com.scavi.brainsqueeze.codefight.i.hsq;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class DecodeStringTest {
    @Test
    public void test1() {
        String result = new DecodeString().decodeString("2[abc]3[cd]ef");
        assertThat(result).isEqualTo("abcabccdcdcdef");
    }
}
