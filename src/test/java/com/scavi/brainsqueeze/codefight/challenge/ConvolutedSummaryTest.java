package com.scavi.brainsqueeze.codefight.challenge;

import org.junit.Test;
import static com.google.common.truth.Truth.*;

public class ConvolutedSummaryTest {
    @Test
    public void test1() {
        String result = new ConvolutedSummary().convolutedSummary("Hello World");
        assertThat(result).isEqualTo("EwD");
    }
}
