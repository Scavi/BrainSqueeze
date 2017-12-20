package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.adventofcode.util.Direction;
import com.scavi.brainsqueeze.util.Pair;

import javax.annotation.Nonnull;

public class Day19ASeriesOfTubes {
    private final char BLANK = ' ';

    public String solveA(@Nonnull final char[][] puzzle) {
        return solve(puzzle).getKey();
    }

    public long solveB(@Nonnull final char[][] puzzle) {
        return solve(puzzle).getValue();
    }

    private Pair<String, Long> solve(@Nonnull final char[][] puzzle) {
        StringBuilder path = new StringBuilder();
        int x = 0;
        int y = 0;
        for (int i = 0; i < puzzle.length; ++i) {
            if (puzzle[0][i] == '|') {
                x = i;
                break;
            }
        }
        boolean isAtEnd = false;
        long steps = 0;
        Direction direction = Direction.Unknown;
        while (!isAtEnd) {
            int mX = 0;
            int mY = 0;
            if (puzzle[y][x] == BLANK) {
                isAtEnd = true;
            } else if (direction != Direction.East && x > 0 && puzzle[y][x - 1] != BLANK) {
                mX = -1;
                direction = Direction.West;
            } else if (direction != Direction.West && x < puzzle[0].length - 1 && puzzle[y][x + 1] != BLANK) {
                mX = 1;
                direction = Direction.East;
            } else if (direction != Direction.South && y > 0 && puzzle[y - 1][x] != BLANK) {
                mY = -1;
                direction = Direction.North;
            } else if (direction != Direction.North && y < puzzle.length - 1 && puzzle[y + 1][x] != BLANK) {
                mY = 1;
                direction = Direction.South;
            } else {
                throw new IllegalArgumentException("The developer screwed up!");
            }
            if (!isAtEnd) {
                char cell;
                do {
                    x += mX;
                    y += mY;
                    steps++;
                    cell = puzzle[y][x];
                    if (cell >= 65 && cell <= 90) {
                        path.append(cell);
                    }
                } while (cell != '+' && cell != BLANK);
            }
        }
        return new Pair<>(path.toString(), steps);
    }
}