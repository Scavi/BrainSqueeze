package com.scavi.brainsqueeze.career;

import org.junit.Test;
import static com.google.common.truth.Truth.*;


public class UnmatchedParenthesesTest {
    @Test
    public void test1() {
        UnmatchedParentheses unmatched = new UnmatchedParentheses();
        String result = unmatched.decode("((a)");
        assertThat(result).isEqualTo("-10a1");
    }


    @Test
    public void test2() {
        UnmatchedParentheses unmatched = new UnmatchedParentheses();
        String result = unmatched.decode("(a))");
        assertThat(result).isEqualTo("0a1-1");
    }


    @Test
    public void test3() {
        UnmatchedParentheses unmatched = new UnmatchedParentheses();
        String result = unmatched.decode("(((abc))((d)))))");
        assertThat(result).isEqualTo("000abc1100d111-1-1");
    }
}
