package com.scavi.brainsqueeze.adventofcode.y2017;

public class Day5MazeOfTwistyTrampolines {

    public int solve(int[][] input, boolean isConfused) {
        int steps = 0;
        int position = 0;

        while (position < input.length) {
            int offset = input[position][0];
            input[position][0] += isConfused ? (offset >= 3 ? -1 : 1) : 1;
            if (offset != 0) {
                position += offset;
            }
            steps++;
        }
        return steps;
    }
}
