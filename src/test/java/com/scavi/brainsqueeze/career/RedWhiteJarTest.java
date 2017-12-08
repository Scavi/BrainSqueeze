package com.scavi.brainsqueeze.career;

import org.junit.Test;
import static com.google.common.truth.Truth.*;

public class RedWhiteJarTest {
    @Test
    public void test1() {
        double prob = new RedWhiteJar(12, 10).probabilityLastWhite();
        assertThat(prob).isEqualTo(0.03496503496503496);
    }


    @Test
    public void test2() {
        double prob = new RedWhiteJar(12, 10).probabilityLastWhiteDP();
        assertThat(prob).isEqualTo(0.03496503496503496);
    }
}
