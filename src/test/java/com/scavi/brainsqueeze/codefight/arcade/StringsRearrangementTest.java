package com.scavi.brainsqueeze.codefight.arcade;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class StringsRearrangementTest {
    @Test
    public void test1() {
        String[] input = new String[]{"aba",
                "bbb",
                "bab"};
        boolean isValid = new StringsRearrangement().stringsRearrangement(input);
        assertThat(isValid).isFalse();
    }

    @Test
    public void test2() {
        String[] input = new String[]{"ab",
                "ad",
                "ef",
                "eg"};
        boolean isValid = new StringsRearrangement().stringsRearrangement(input);
        assertThat(isValid).isFalse();
    }

    @Test
    public void test3() {
        String[] input = new String[]{"ab",
                "bb",
                "aa"};
        boolean isValid = new StringsRearrangement().stringsRearrangement(input);
        assertThat(isValid).isTrue();
    }

    @Test
    public void test4() {
        String[] input = new String[]{"ab",
                "ad",
                "ef",
                "eg"};
        boolean isValid = new StringsRearrangement().stringsRearrangement(input);
        assertThat(isValid).isFalse();
    }


    @Test
    public void test5() {
        String[] input = new String[]{"abc",
                "bef",
                "bcc",
                "bec",
                "bbc",
                "bdc"};
        boolean isValid = new StringsRearrangement().stringsRearrangement(input);
        assertThat(isValid).isTrue();
    }

    @Test
    public void test6() {
        String[] input = new String[]{"abc",
                "abx",
                "axx",
                "abc"};
        boolean isValid = new StringsRearrangement().stringsRearrangement(input);
        assertThat(isValid).isFalse();
    }

    @Test
    public void test7() {
        String[] input = new String[]{"abc",
                "abx",
                "axx",
                "abx",
                "abc"};
        boolean isValid = new StringsRearrangement().stringsRearrangement(input);
        assertThat(isValid).isTrue();
    }
}
