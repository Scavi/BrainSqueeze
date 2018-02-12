package com.scavi.brainsqueeze.codefight.i.dp;

public class FillingBlocks {

    /**
     * You have a block with the dimensions 4 × n. Find the number of different ways you can fill this block with
     * smaller blocks that have the dimensions 1 × 2. You are allowed to rotate the smaller blocks.
     *
     * @param n
     * @return
     */
    int fillingBlocks(int n) {
        if (n < 2) {
            return n;
        } else if (n == 2) {
            return 5;
        } else if (n == 3) {
            return 11;
        } else if (n == 4) {
            return 36;
        }
        int back4 = 1;
        int back3 = 5;
        int back2 = 11;
        int back = 36;
        int current = 0;
        for (int i = 5; i <= n; ++i) {
            current = back + (5 * back2) + back3 - back4;
            back4 = back3;
            back3 = back2;
            back2 = back;
            back = current;
        }
        return current;
    }


// http://oeis.org/A005178
//    int fillingBlocks(int n) {
//        n+=1;
//        return (int) ((5 * Math.sqrt(29) / 145) *
//                (Math.pow(((1 + Math.sqrt(29) + Math.sqrt(14 + 2 * Math.sqrt(29))) / 4), n) +
//                        Math.pow(((1 + Math.sqrt(29) - Math.sqrt(14 + 2 * Math.sqrt(29))) / 4), n) -
//                        Math.pow(((1 - Math.sqrt(29) + Math.sqrt(14 - 2 * Math.sqrt(29))) / 4), n) -
//                        Math.pow(((1 - Math.sqrt(29) - Math.sqrt(14 - 2 * Math.sqrt(29))) / 4), n)));
//    }

// TOO SLOW:
//    private final int MULTIPLIER = 4;
//
//    public int fillingBlocks(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        boolean[][] grid = new boolean[n][MULTIPLIER];
//        return fillingBlocks(grid, 0, MULTIPLIER * n, 0);
//    }
//
//
//    private int fillingBlocks(boolean[][] grid, int placedCount, int required, int currentPos) {
//        int result = 0;
//        if (placedCount == required) {
//            result = 1;
//        } else {
//            boolean hasBeenMoved = false;
//            int x = currentPos % grid[0].length;
//            int y = currentPos / grid[0].length;
//            while (!hasBeenMoved && y < grid.length && x < grid[0].length) {
//
//                if (isHorizontalMovable(grid, x, y)) {
//                    placeHorizontal(grid, x, y, true);
//                    result += fillingBlocks(grid, placedCount + 2, required, currentPos + 2);
//                    placeHorizontal(grid, x, y, false);
//                    hasBeenMoved = true;
//                }
//                if (isVerticalMovable(grid, x, y)) {
//                    placeVertical(grid, x, y, true);
//                    result += fillingBlocks(grid, placedCount + 2, required, currentPos + 1);
//                    placeVertical(grid, x, y, false);
//                    hasBeenMoved = true;
//                }
//
//                if (!hasBeenMoved) {
//                    currentPos++;
//                    x = currentPos % grid[0].length;
//                    y = currentPos / grid[0].length;
//                }
//            }
//        }
//        return result;
//    }
//
//    private void placeHorizontal(boolean[][] grid, int x, int y, boolean isPlaced) {
//        grid[y][x] = isPlaced;
//        grid[y][x + 1] = isPlaced;
//    }
//
//    private void placeVertical(boolean[][] grid, int x, int y, boolean isPlaced) {
//        grid[y][x] = isPlaced;
//        grid[y + 1][x] = isPlaced;
//    }
//
//    private boolean isHorizontalMovable(boolean[][] grid, int x, int y) {
//        return x + 1 < grid[0].length && !grid[y][x] && !grid[y][x + 1];
//    }
//
//    private boolean isVerticalMovable(boolean[][] grid, int x, int y) {
//        return y + 1 < grid.length && !grid[y][x] && !grid[y + 1][x];
//    }
}
