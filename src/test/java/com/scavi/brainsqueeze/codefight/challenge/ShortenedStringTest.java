package com.scavi.brainsqueeze.codefight.challenge;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
/**
 * @author Michael Heymel
 * @since 26.12.17
 */
public class ShortenedStringTest {
    @Test
    public void test1() {
        String result = new ShortenedString().shortenedString("H3A");
        assertThat(result).isEqualTo("HHHA");
    }
}
