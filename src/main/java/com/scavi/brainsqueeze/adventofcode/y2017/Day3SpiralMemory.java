package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.adventofcode.util.Direction;
import com.scavi.brainsqueeze.util.Point;

public class Day3SpiralMemory {
    /**
     * Based on the given input the required fields for the matrix (two-dimensional-array) will be determined.
     * E.g. with a puzzle input of 16, 25 fields (5x5) matrix would be required.
     * <p/>
     * The input puzzle value we want to find is at the border. In a determined AxA matrix, the top left value is A² / 2
     * at Point(x=0;y=0), the top down value is A² at Point(x=A-1;y=A-1).
     * <p/>
     * If the input value is smaller then A² / 2 we know that the position is somewhere at the top / left bottom.
     * If it is higher then the position is on the right / bottom side.
     *
     * @param input the puzzle input
     * @return the steps from the puzzle input position to the center position
     */
    public int solveA(final int input) {
        int fields = fieldsOfMatrix(input);
        int dimension = (int) Math.sqrt(fields);
        Point target = positionOf(input, fields);
        Point center = new Point(dimension / 2, dimension / 2);
        return Math.abs(target.getY() - center.getY()) + Math.abs(target.getX() - center.getX());
    }


    /**
     * The position will be determined as follows:
     *
     * @param input  the given puzzle input
     * @param fields the amount of fields in the matrix to the given input.
     * @return the target point of the input puzzle representing x and y in the matrix
     */
    private Point positionOf(final int input, final int fields) {
        int diff = fields - input;
        int dim = (int) Math.sqrt(fields) - 1;
        if (diff == 0) {
            return new Point(dim, dim);
        }
        Point result;
        int lookup = fields - (dim << 1);
        if (diff == lookup) {
            result = new Point(0, 0);
        }
        // side: left and bottom
        else if (input > lookup) {
            result = new Point(dim - (diff > dim ? dim : diff), dim - Math.max(0, diff - dim));
        }
        // side: top and right
        else {
            diff = lookup - input;
            result = new Point(diff > dim ? dim : diff, diff > dim ? diff - dim : dim);
        }
        return result;
    }


    /**
     * Determines the required fields of the matrix (int-array) for the given puzzle input
     *
     * @param input the puzzle input
     * @return the amount of fields
     */
    private int fieldsOfMatrix(final int input) {
        // stolen from https://github.com/shaeberling/euler/blob/master/go/src/aoc17/problems/p03/p03.go ;-)
        int ring = (int) Math.ceil((Math.sqrt(input) - 1) / 2);
        return (int) Math.pow((ring << 1) + 1, 2);
//        int mul = 0;
//        int length = 1;
//        while (input > length) {
//            length += 8 * mul++;
//        }
//        return length;
    }


    /**
     * Just brute-force: follow the path in a spiral way.
     *
     * @param input the puzzle input
     * @return the next higher value
     */
    public int solveB(final int input) {
        int sizeLookup = input < 25 ? 25 : (int) Math.pow(input, 0.85);
        int fields = fieldsOfMatrix(sizeLookup);
        int dimension = (int) Math.sqrt(fields);
        int x = dimension / 2;
        int y = dimension / 2;

        int[][] matrix = new int[dimension][dimension];
        matrix[y][x] = 1;

        Direction currentDir = Direction.East;
        int sum = 0;
        int steps = 1;
        while (input > sum) {
            // the spiral movement is 1(r),1(u),2(l),2(d),3(r),3(u),4(l),4(d)...
            // so it stays 2 times at a step size while changing the direction
            for (int i = 0; i < 2 && input > sum; ++i) {
                // move the required steps into the direction
                for (int j = 0; j < steps && input > sum; ++j) {
                    if (currentDir == Direction.East) x++;
                    else if (currentDir == Direction.North) y--;
                    else if (currentDir == Direction.West) x--;
                    else if (currentDir == Direction.South) y++;
                    // Lazy brute force - just add all values together of all adjacent fields of x, y
                    sum = matrix[y][x] =
                            matrix[y - 1][x - 1] + matrix[y - 1][x] + matrix[y - 1][x + 1] +
                                    matrix[y][x - 1] + matrix[y][x + 1] + matrix[y + 1][x - 1] + matrix[y + 1][x] +
                                    matrix[y + 1][x + 1];
                }
                // change the direction
                currentDir = Direction.valueOf((currentDir.getValue() + 1) % 4);
            }
            // increase the steps into a direction
            steps++;
        }
        return sum;
    }
}