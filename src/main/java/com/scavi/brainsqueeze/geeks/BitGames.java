package com.scavi.brainsqueeze.geeks;

/**
 * @author Michael Heymel
 * @since 25.12.17
 */
public class BitGames {

    /**
     * Turns off a bit from <code>x</code> at the given pos.
     * Creates a binary number with all bit set except the bit to turn.
     * E.g. x=15, pos=1 => 14
     *
     * @param x         the value x
     * @param turnOfPos the bit pos to turn off (the position is zero based)
     * @return the new x with the turned of bit
     */
    public int turnOffBit(final int x, final int turnOfPos) {
        if (x == 0) {
            return x;
        }
        int v = ~(1 << turnOfPos);
        return x & v;
    }


    /**
     * Verifies if the given number is a palindrome or not
     *
     * @param x the value to check
     * @return <code>true</code> it is a palindrome<br/>
     * <code>false</code> it is not a palindrome
     */
    public boolean isPalindrome(final int x) {
        int r = 1;
        int l = 32;
        while (r < l) {
            if (isBitSet(x, r) != isBitSet(x, l)) {
                return false;
            }
            r++;
            l--;
        }
        return true;
    }


    /**
     * Swaps the nibbles of the given char
     *
     * @param x the value swap
     * @return swaps the nibbles of the char
     */
    public char swapNibbles(final char x) {
        int result = ((x & 0x0F) << 4 | (x & 0xF0) >> 4);
        return (char) result;
    }


    /**
     * Adds 1 to the given x value without using the + operator.
     * Uses the binaries Two's complement to swap every bit and multiply it
     * with -1.
     * E.g. ~8 becomes -9
     *
     * @param x the value that will be increased
     * @return the increased result
     */
    public int add1(final int x) {
        return -1 * (~x);
    }


    /**
     * Given a number x and two positions (from right side) in binary representation of x, write a function that swaps
     * n bits at given two positions and returns the result. It is also given that the two sets of bits do not overlap.
     *
     * @param value the value to swap
     * @param pos1  the first position. The position is zero based.
     * @param pos2  the second position. The position is zero based.
     * @param range the range to swap
     * @return the swapped value
     */
    public int swapBitsInRange(int value, final int pos1, final int pos2, final int range) {
        int xOr = ((value >> pos1) ^ (value >> pos2)) & ((1 << range) - 1);
        return value ^ ((xOr << pos1) | (xOr << pos2));
    }


    /**
     * Verifies if the bit is set at the given position
     *
     * @param x   the value
     * @param pos the position
     * @return <code>true</code> the bit is set<br/>
     * <code>false</code>
     */
    private boolean isBitSet(final int x, final int pos) {
        return (x & (1 << pos)) != 0;
    }


    /**
     * Adds two values without using +
     *
     * @param value1 the value 1 to add
     * @param value2 the value 2 to add
     * @return the sum of value1 and value2
     */
    public int add(int value1, int value2) {
        while (value2 != 0) {
            int tmp = value1 & value2;
            value1 ^= value2;
            value2 = tmp << 1;
        }
        return value1;
    }


    /**
     * Verifies if value 1 or value 2 have opposite sign.
     *
     * @param value1 the value one to compare
     * @param value2 the value two to compare
     * @return <code>true</code> have an opposite sign <br/>
     * <code>false</code> don't have an opposite sign
     */
    public boolean isOppositeSign(final int value1, final int value2) {
        return (value1 ^ value2) < 0;
    }


    private int swap(int x, final int pos1, final int pos2) {
        if (pos1 != pos2 && ((x >> pos1 != 0 && x >> pos2 == 0) || (x >> pos1 == 0 && x >> pos2 != 0))) {
            x ^= (1 << pos1);
            x ^= (1 << pos2);
        }
        return x;
    }
}
