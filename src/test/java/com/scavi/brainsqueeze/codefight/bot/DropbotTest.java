package com.scavi.brainsqueeze.codefight.bot;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class DropbotTest {
    @Test
    public void test1_1() {
        String[] attempts = new String[]{"9999", "9999",
                "9999", "9999",
                "9999", "9999",
                "9999", "9999",
                "9999", "1234",
                "9999", "9999"};
        boolean isCorrect = new Dropbot().incorrectPasscodeAttempts("1234", attempts);
        assertThat(isCorrect).isFalse();
    }

    @Test
    public void test2_1() {
        String compressed = new Dropbot().losslessDataCompression("abacabadabacaba", 7);
        assertThat(compressed).isEqualTo("ab(0,1)c(0,3)d(4,3)c(8,3)");
    }

    @Test
    public void test3_0() {
        String result = new Dropbot().displayDiff("abb", "bb");
        assertThat(result).isEqualTo("(a)bb");
    }


    @Test
    public void test3_1() {
        String result = new Dropbot().displayDiff("a", "a");
        assertThat(result).isEqualTo("a");
    }


    @Test
    public void test3_2() {
        String result = new Dropbot().displayDiff("ab", "bb");
        assertThat(result).isEqualTo("(a)b[b]");
    }


    @Test
    public void test3_3() {
        String result = new Dropbot().displayDiff("_7", "27_");
        assertThat(result).isEqualTo("(_)[2]7[_]");
    }

    @Test
    public void test3_4() {
        String result = new Dropbot().displayDiff("a2_3b42c_78d", "a_34c27_8ed");
        assertThat(result).isEqualTo("a(2)_3(b)4(2)c(_)[2]7[_]8[e]d");
    }

    @Test
    public void test3_5() {
        String result = new Dropbot().displayDiff("same_prefix_1233_same_suffix", "same_prefix23123_same_suffix");
        assertThat(result).isEqualTo("same_prefix(_1)23[12]3_same_suffix");
    }


    @Test
    public void test3_6() {
        String result = new Dropbot().displayDiff("same_prefix_1233_same_suffix", "same_prefix23123_same_suffix");
        assertThat(result).isEqualTo("same_prefix(_1)23[12]3_same_suffix");
    }
}
