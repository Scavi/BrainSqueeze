package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.FileHelper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.google.common.truth.Truth.assertThat;

public class Day20ParticleSwarmTest {

    @Test
    public void test1() {
        String[] input = new String[]{
                "p=< 3,0,0>, v=< 2,0,0>, a=<-1,0,0>",
                "p=< 4,0,0>, v=< 0,0,0>, a=<-2,0,0>"
        };

        int particle = new Day20ParticleSwarm().solveA(input);
        assertThat(particle).isEqualTo(0);
    }

    @Test
    public void testQuestion1() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day20.txt");
        int particle = new Day20ParticleSwarm().solveA(FileHelper.readLines(inputFile));
        assertThat(particle).isEqualTo(150);
    }


    @Test
    public void testQuestion2() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day20.txt");
        int remaining = new Day20ParticleSwarm().solveB(FileHelper.readLines(inputFile));
        assertThat(remaining).isEqualTo(657);
    }
}
