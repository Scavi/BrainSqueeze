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

package com.scavi.brainsqueeze.adventofcode2016;

import com.google.common.base.Preconditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Michael Heymel
 * @since 09/12/16
 */
public class Day8TwoFactorAuthentication {
    private Pattern RECT_PATTERN_WIDTH = Pattern.compile("(?<=rect\\s)[^x]*");
    private Pattern RECT_PATTERN_HEIGHT = Pattern.compile("(?<=x)[^$]*");
    private Pattern COLUMN_ROTATE_PATTERN_X = Pattern.compile("(?<=x\\=)[^\\s]*");
    private Pattern COLUMN_ROTATE_PATTERN_Y = Pattern.compile("(?<=y\\=)[^\\s]*");
    private Pattern ROTATION_LENGTH = Pattern.compile("(?<=by\\s)[^$]*");


    int countLidPixels(final String[] instructions, final int width, final int height) {
        Preconditions.checkNotNull(instructions, "Illegal instruction set: <null>");
        boolean[][] field = processInstructions(instructions, width, height);
        printScreen(field);
        return count(field);
    }


    private int count(final boolean[][] field) {
        int cnt = 0;
        for (final boolean[] aField : field) {
            for (int x = 0; x < aField.length; ++x) {
                cnt += aField[x] ? 1 : 0;
            }
        }
        return cnt;
    }


    private void printScreen(final boolean[][] field) {
        for (int i = 0; i < field.length; ++i) {
            for (int j = 0; j < field[i].length; ++j) {
                System.out.print(field[i][j] ? "#" : " ");
            }
            System.out.println();
        }
    }


    private boolean[][] processInstructions(final String[] instructions, final int width,
            final int height) {
        boolean[][] field = new boolean[height][width];

        for (String instruction : instructions) {
            if (instruction.startsWith("rect")) {
                processRect(field, instruction);
            } else if (instruction.startsWith("rotate column")) {
                processColumnRotation(field, instruction);
            } else if (instruction.startsWith("rotate row")) {
                processRowRotation(field, instruction);
            } else {
                throw new IllegalArgumentException(instruction);
            }
        }
        return field;
    }


    private void processRect(final boolean[][] field, final String instruction) {
        Matcher widthMatch = RECT_PATTERN_WIDTH.matcher(instruction);
        Matcher heightMatch = RECT_PATTERN_HEIGHT.matcher(instruction);
        Preconditions.checkArgument(widthMatch.find() && heightMatch.find(),
                "Illegal declaration to create a rectangle: " + instruction);
        int width = Integer.parseInt(widthMatch.group());
        int height = Integer.parseInt(heightMatch.group());
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                field[y][x] = true;
            }
        }
    }


    private void processColumnRotation(final boolean[][] field, final String instruction) {
        Matcher columnMatch = COLUMN_ROTATE_PATTERN_X.matcher(instruction);
        Matcher rotationLengthMatch = ROTATION_LENGTH.matcher(instruction);
        Preconditions.checkArgument(columnMatch.find() && rotationLengthMatch.find(),
                "Illegal column rotation instruction: ",
                instruction);
        int column = Integer.parseInt(columnMatch.group());
        int length = Integer.parseInt(rotationLengthMatch.group());
        long cache = 0;
        // setup cache
        for (int sourcePos = 0; sourcePos < field.length; ++sourcePos) {
            if (field[sourcePos][column]) {
                cache += (1L << sourcePos);
            }
        }
        // change column
        for (int sourcePos = 0; sourcePos < field.length; ++sourcePos) {
            int targetPos = (sourcePos + length) % field.length;
            field[targetPos][column] = ((1L << sourcePos) & cache) != 0;
        }
    }


    private void processRowRotation(final boolean[][] field, final String instruction) {
        Matcher rowMatch = COLUMN_ROTATE_PATTERN_Y.matcher(instruction);
        Matcher rotationLengthMatch = ROTATION_LENGTH.matcher(instruction);
        Preconditions.checkArgument(rowMatch.find() && rotationLengthMatch.find(),
                "Illegal row rotation instruction: ",
                instruction);

        int row = Integer.parseInt(rowMatch.group());
        int length = Integer.parseInt(rotationLengthMatch.group());
        long cache = 0;
        // setup cache
        for (int sourcePos = 0; sourcePos < field[row].length; ++sourcePos) {
            if (field[row][sourcePos]) {
                cache += (1L << sourcePos);
            }
        }
        // change column
        for (int sourcePos = 0; sourcePos < field[row].length; ++sourcePos) {
            int targetPos = (sourcePos + length) % field[row].length;
            field[row][targetPos] = ((1L << sourcePos) & cache) != 0;
        }
    }
}
