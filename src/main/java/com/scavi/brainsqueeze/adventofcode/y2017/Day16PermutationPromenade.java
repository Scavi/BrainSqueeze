package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.StringHelper;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class Day16PermutationPromenade {


    public String solveA(@Nonnull final String input, final String programs) {
        return solve(input, programs, 1);
    }


    public String solveB(@Nonnull final String programMoves, final String programNames) {
        return solve(programMoves, programNames, 1000000000);
    }


    private String solve(@Nonnull final String input, final String programs, final int iterations) {
        char[] programOrder = programs.toCharArray();
        String[] moves = StringHelper.split(input, ",");
        char[] firstProgramOrder = programs.toCharArray();
        for (int i = 0; i < iterations; ++i) {
            if (i > 0 && Arrays.equals(programOrder, firstProgramOrder)) {
                i = iterations - (iterations % i);
            }
            for (String move : moves) {
                char dance = move.charAt(0);
                switch (dance) {
                    case 's':
                        spin(move, programOrder);
                        break;
                    case 'x':
                        exchange(move, programOrder);
                        break;
                    case 'p':
                        partner(move, programOrder);
                        break;
                }
            }
        }
        return new String(programOrder);
    }


    private void spin(@Nonnull final String move, @Nonnull final char[] programOrder) {
        int spinPos = Integer.parseInt(move.substring(1));
        String temp = new String(programOrder);
        for (int i = 0; i < temp.length(); ++i) {
            programOrder[(i + spinPos) % temp.length()] = temp.charAt(i);
        }
    }


    private void exchange(@Nonnull final String move, @Nonnull final char[] programOrder) {
        int splitterPos = move.indexOf('/');
        swap(programOrder,
                Integer.parseInt(move.substring(1, splitterPos)),
                Integer.parseInt(move.substring(splitterPos + 1)));
    }


    private void partner(@Nonnull final String move, @Nonnull final char[] programOrder) {
        int p0 = -1;
        int p1 = -1;

        for (int i = 0; i < programOrder.length && (p0 == -1 || p1 == -1); ++i) {
            if (p0 == -1 && move.charAt(1) == programOrder[i]) {
                p0 = i;
            } else if (p1 == -1 && move.charAt(3) == programOrder[i]) {
                p1 = i;
            }

            if (p0 != -1 && p1 != -1) {
                swap(programOrder, p0, p1);
            }
        }
    }


    private void swap(final char[] data, final int pos1, final int pos2) {
        char tmp = data[pos1];
        data[pos1] = data[pos2];
        data[pos2] = tmp;
    }

/* -> around 35 seconds for solution b
    public String solveA(@Nonnull final String input, final String programs) {
        return solve(input, programs, 1);
    }

    public String solveB(@Nonnull final String programMoves, final String programNames) {
        return solve(programMoves, programNames, 1000000000);
    }


    private String solve(@Nonnull final String input, final String programs, int retries) {
        char[] programOrder = programs.toCharArray();
        String[] moves = StringHelper.split(input, ",");
        Map<String, String> cache = new HashMap<>();
        for (int i = 0; i < retries; ++i) {
            String start = new String(programOrder);
            if (cache.containsKey(start)) {
                programOrder = cache.get(start).toCharArray();
            } else {
                for (String move : moves) {
                    char dance = move.charAt(0);
                    switch (dance) {
                        case 's':
                            spin(move, programOrder);
                            break;
                        case 'x':
                            exchange(move, programOrder);
                            break;
                        case 'p':
                            partner(move, programOrder);
                            break;
                    }
                }
                cache.put(start, new String(programOrder));
            }
        }
        return new String(programOrder);
    }


    private void spin(@Nonnull final String move, @Nonnull final char[] programOrder) {
        int spinPos = Integer.parseInt(move.substring(1));
        String temp = new String(programOrder);
        for (int i = 0; i < temp.length(); ++i) {
            programOrder[(i + spinPos) % temp.length()] = temp.charAt(i);
        }
    }


    private void exchange(@Nonnull final String move, @Nonnull final char[] programOrder) {
        int splitterPos = move.indexOf('/');
        swap(programOrder,
                Integer.parseInt(move.substring(1, splitterPos)),
                Integer.parseInt(move.substring(splitterPos + 1)));
    }


    private void partner(@Nonnull final String move, @Nonnull final char[] programOrder) {
        int p0 = -1;
        int p1 = -1;

        for (int i = 0; i < programOrder.length && (p0 == -1 || p1 == -1); ++i) {
            if (p0 == -1 && move.charAt(1) == programOrder[i]) {
                p0 = i;
            } else if (p1 == -1 && move.charAt(3) == programOrder[i]) {
                p1 = i;
            }

            if (p0 != -1 && p1 != -1) {
                swap(programOrder, p0, p1);
            }
        }
    }


    private void swap(final char[] data, final int pos1, final int pos2) {
        char tmp = data[pos1];
        data[pos1] = data[pos2];
        data[pos2] = tmp;
    }*/
}
