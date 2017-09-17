/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.scavi.brainsqueeze.codefight.challenge;

/**
 * Created by Scavenger on 6/14/2017.
 */
public class BlockFiller {
    private final int MULTIPLIER = 4;

    public int fillingBlocks(int n) {
        if (n == 1) {
            return 1;
        }
        boolean[][] grid = new boolean[n][MULTIPLIER];
        return fillingBlocks(grid, 0, MULTIPLIER * n, 0);
    }

    private int fillingBlocks(boolean[][] grid, int placedCount, int required, int currentPos) {
        int result = 0;
        if (placedCount == required) {
            result = 1;
        } else {
            boolean hasBeenMoved = false;
            int x = currentPos % grid[0].length;
            int y = currentPos / grid[0].length;
            while (!hasBeenMoved && y < grid.length && x < grid[0].length) {

                if (isHorizontalMovable(grid, x, y)) {
                    placeHorizontal(grid, x, y, true);
                    result += fillingBlocks(grid, placedCount + 2, required, currentPos + 2);
                    placeHorizontal(grid, x, y, false);
                    hasBeenMoved = true;
                }
                if (isVerticalMovable(grid, x, y)) {
                    placeVertical(grid, x, y, true);
                    result += fillingBlocks(grid, placedCount + 2, required, currentPos + 1);
                    placeVertical(grid, x, y, false);
                    hasBeenMoved = true;
                }

                if (!hasBeenMoved) {
                    currentPos++;
                    x = currentPos % grid[0].length;
                    y = currentPos / grid[0].length;
                }
            }
        }
        return result;
    }

    private void placeHorizontal(boolean[][] grid, int x, int y, boolean isPlaced) {
        grid[y][x] = isPlaced;
        grid[y][x + 1] = isPlaced;
    }

    private void placeVertical(boolean[][] grid, int x, int y, boolean isPlaced) {
        grid[y][x] = isPlaced;
        grid[y + 1][x] = isPlaced;
    }

    private boolean isHorizontalMovable(boolean[][] grid, int x, int y) {
        return x + 1 < grid[0].length && !grid[y][x] && !grid[y][x + 1];
    }

    private boolean isVerticalMovable(boolean[][] grid, int x, int y) {
        return y + 1 < grid.length && !grid[y][x] && !grid[y + 1][x];
    }
}

