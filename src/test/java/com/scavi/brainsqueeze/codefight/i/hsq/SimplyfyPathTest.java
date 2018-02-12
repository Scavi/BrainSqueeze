package com.scavi.brainsqueeze.codefight.i.hsq;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class SimplyfyPathTest {
    @Test
    public void test1() {
        String path = new SimplyfyPath().simplifyPath("/home/a/./x/../b//c/");
        assertThat(path).isEqualTo("/home/a/b/c");
    }

    @Test
    public void test2() {
        String path = new SimplyfyPath().simplifyPath("/../");
        assertThat(path).isEqualTo("/");
    }
}
