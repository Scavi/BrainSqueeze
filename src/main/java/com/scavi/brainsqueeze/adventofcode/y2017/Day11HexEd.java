package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.Hex;

import javax.annotation.Nonnull;

public class Day11HexEd {
    public int solveA(@Nonnull final String[] moves) {
        return solve(moves)[0];
    }


    public int solveB(@Nonnull final String[] moves) {
        return solve(moves)[1];
    }


    private int[] solve(@Nonnull final String[] moves) {
        Hex start = new Hex(0, 0);
        int maxDistance = 0;
        int x = 0;
        int y = 0;
        for (String move : moves) {
            switch (move) {
                case "se":
                    x--;
                    y++;
                    break;
                case "s":
                    x--;
                    break;
                case "sw":
                    y--;
                    break;
                case "nw":
                    x++;
                    y--;
                    break;
                case "n":
                    x++;
                    break;
                case "ne":
                    y++;
                    break;
                default:
                    throw new IllegalArgumentException("Not supported move: " + move);
            }
            maxDistance = Math.max(maxDistance, start.distanceTo(new Hex(x, y)));
        }
        return new int[]{
                new Hex(x, y).distanceTo(start), maxDistance
        };
    }
}
