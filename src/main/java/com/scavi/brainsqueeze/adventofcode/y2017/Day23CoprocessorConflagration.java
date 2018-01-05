package com.scavi.brainsqueeze.adventofcode.y2017;

/**
 * @author Michael Heymel
 * @since 27.12.17
 */
public class Day23CoprocessorConflagration {
    public int solveA(final String[] instructions) {
        Day18Duet.Duet duet = new Day18Duet.Duet(1, instructions);
        duet.run();
        return duet.getMulCount();
    }

    public long solveB(final String[] instructions) {
        Day18Duet.Duet duet = new Day18Duet.Duet(1, instructions);
        duet.getAssembly().put('a', 1L);
        duet.run();
        return duet.getAssembly().get('h');
    }
}
