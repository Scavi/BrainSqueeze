package com.scavi.brainsqueeze.misc;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class ParagraphDistanceTest {


    @Test
    public void testNotExists() {
        String lookupParagraph = "Join the dark side";
        String paragraph = "If you join to this side it is going to be dar. But you will get cookies. " +
                "So, join the dark side.";
        int distance = new ParagraphDistance().shortestDistance(paragraph, lookupParagraph);
        assertThat(distance).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    public void testExists() {
        String lookupParagraph = "join the dark side";
        String paragraph = "If you join to the side it is going to be dark. But you will get cookies. " +
                "So, join the dark side.";
        int distance = new ParagraphDistance().shortestDistance(paragraph, lookupParagraph);
        assertThat(distance).isEqualTo(4);
    }
}
