package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.adventofcode.util.Tower;
import com.scavi.brainsqueeze.util.FileHelper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.google.common.truth.Truth.assertThat;

public class Day7RecursiveCircusTest {
    @Test
    public void test1() {
        String[] input = new String[]{
                "pbga (66)",
                "xhth (57)",
                "ebii (61)",
                "havc (66)",
                "ktlj (57)",
                "fwft (72) -> ktlj, cntj, xhth",
                "qoyq (66)",
                "padx (45) -> pbga, havc, qoyq",
                "tknk (41) -> ugml, padx, fwft",
                "jptl (61)",
                "ugml (68) -> gyxo, ebii, jptl",
                "gyxo (61)",
                "cntj (57)"
        };

        Tower tower = Tower.from(input);
        String name = new Day7RecursiveCircus().solveA(tower);
        assertThat(name).isEqualTo("tknk");
    }


    @Test
    public void testQuestionA() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day7.txt");
        String[] input = FileHelper.readLines(inputFile);
        Tower tower = Tower.from(input);
        String name = new Day7RecursiveCircus().solveA(tower);
        assertThat(name).isEqualTo("uownj");
    }


    @Test
    public void test2() {
        String[] input = new String[]{
                "pbga (66)",
                "xhth (57)",
                "ebii (61)",
                "havc (66)",
                "ktlj (57)",
                "fwft (72) -> ktlj, cntj, xhth",
                "qoyq (66)",
                "padx (45) -> pbga, havc, qoyq",
                "tknk (41) -> ugml, padx, fwft",
                "jptl (61)",
                "ugml (68) -> gyxo, ebii, jptl",
                "gyxo (61)",
                "cntj (57)"
        };

        Tower tower = Tower.from(input);
        int change = new Day7RecursiveCircus().solveB(tower);
        assertThat(change).isEqualTo(60);
    }


    @Test
    public void testQuestionB() throws IOException {
        File inputFile = FileHelper.forUnitTests("adventofcode/y2017/Day7.txt");
        String[] input = FileHelper.readLines(inputFile);
        Tower tower = Tower.from(input);
        int change = new Day7RecursiveCircus().solveB(tower);
        assertThat(change).isEqualTo(596);
    }
}
