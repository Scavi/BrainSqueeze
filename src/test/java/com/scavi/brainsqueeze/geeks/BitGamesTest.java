package com.scavi.brainsqueeze.geeks;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * @author Michael Heymel
 * @since 25.12.17
 */
public class BitGamesTest {
    @Test
    public void testTurnBit1() {
        int result = new BitGames().turnOffBit(15, 0);
        assertThat(result).isEqualTo(14);
    }


    @Test
    public void testTurnBit2() {
        BitGames bg = new BitGames();
        int result = bg.turnOffBit(~0, 0);
        assertThat(result).isEqualTo(-2);
    }


    @Test
    public void testPalindrome1() {
        boolean isPalindrome = new BitGames().isPalindrome(-1);
        assertThat(isPalindrome).isTrue();
    }


    @Test
    public void testPalindrome2() {
        boolean isPalindrome = new BitGames().isPalindrome(7);
        assertThat(isPalindrome).isFalse();
    }


    @Test
    public void testSwapNibbles() {
        char expectedOutput = '\u0016';
        char output = new BitGames().swapNibbles('a');
        assertThat(output).isEqualTo(expectedOutput);
    }


    @Test
    public void testAdd1() {
        int result = new BitGames().add1(9);
        assertThat(result).isEqualTo(10);
    }


    @Test
    public void testAdd2() {
        int result = new BitGames().add1(2);
        assertThat(result).isEqualTo(3);
    }


    @Test
    public void testAdd3() {
        int result = new BitGames().add1(3);
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void testAdd4() {
        int result = new BitGames().add1(-4);
        assertThat(result).isEqualTo(-3);
    }

    @Test
    public void testSwapBitsInRange1() {
        int result = new BitGames().swapBitsInRange(47, 2, 6, 3);
        assertThat(result).isEqualTo(227);
    }

    @Test
    public void testAddSpeed() {
        int result = new BitGames().add(-12, 54);
        assertThat(result).isEqualTo(42);
    }

    @Test
    public void testOppositeSign1() {
        boolean isOpposite = new BitGames().isOppositeSign(10, 20);
        assertThat(isOpposite).isFalse();
    }

    @Test
    public void testOppositeSign2() {
        boolean isOpposite = new BitGames().isOppositeSign(-10, 20);
        assertThat(isOpposite).isTrue();
    }
}
