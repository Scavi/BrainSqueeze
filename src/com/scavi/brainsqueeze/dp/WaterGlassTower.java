package com.scavi.brainsqueeze.dp;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Scavenger on 21/09/16.
 */
public class WaterGlassTower {

    private static final float MAX_GLASS_SIZE = 1;


    /**
     * There are some glasses with equal volume 1 litre. The glasses kept as follows
     * 1
     * 2   3
     * 4    5    6
     * 7    8    9   10
     * You can put water to only top glass. If you put more than 1 litre water to 1st glass,
     * water overflow and fill equally both 2nd and 3rd glass. Glass 5 will get water from
     * both 2nd glass and 3rd glass and so on.
     * If you have X litre of water and you put that water in top glass, so tell me how much water
     * contained by jth glass in ith row. Example. If you will put 6 litre on top:
     * 1.0
     * 1.0   1.0
     * 0.75   1.0   0.75
     * 0.0   0.25   0.25   0.0
     *
     * @param waterAmount the amount of given water
     * @param xPos        the horizontal position of the target glass (not zero based)
     * @param yPos        the vertical position of the target glass (not zero based)
     * @return the amount of water in the glass at the given x / y position
     */
    public float findWaterAmount(final float waterAmount, final int xPos, final int yPos) {

        if (xPos <= 0 || yPos <= 0) {
            throw new IllegalArgumentException(
                    "Illegal positions! Positions must be greater than 0.");
        }
        if (xPos > yPos) {
            throw new IllegalArgumentException("Illegal column definition!");
        }
        //int glassAmount = BigInteger.valueOf(yPos - 1).pow(2).intValue();
        int glassAmount = determineCacheSize(yPos);
        float result = 0;
        float[] glassTower = new float[glassAmount];

        // setup
        int currentPos = 0;
        glassTower[currentPos] = waterAmount;

        for (int y = 0; y < yPos; ++y) {
            int maxX = y + 1;
            for (int x = 0; x < maxX && currentPos < glassAmount; ++x, ++currentPos) {
                // more water than allowed in the current glass
                if (glassTower[currentPos] > MAX_GLASS_SIZE) {
                    // water overflow - leave max in the current glass and determine the rest
                    float rest = glassTower[currentPos] - MAX_GLASS_SIZE;
                    glassTower[currentPos] = MAX_GLASS_SIZE;
                    // determine the left and right position within the array of the glasses below
                    int left = leftPos(currentPos, y);
                    int right = rightPos(currentPos, y);
                    // put half of it to the left and the other half to the right
                    if (left < glassAmount) {
                        glassTower[left] += rest / 2;
                    }
                    if (right < glassAmount) {
                        glassTower[right] += rest / 2;
                    }
                }

                // target position
                if (y == yPos - 1 && x == xPos - 1) {
                    result = glassTower[currentPos];
                }
            }
        }
        return result;
    }


    /**
     * Determines the required cache size
     *
     * @param rows the target row
     * @return the cache size
     */
    private int determineCacheSize(final int rows) {
        int size = 0;
        for (int i = 1; i <= rows; ++i) {
            size += i;
        }
        return size;
    }


    /**
     * Determines the position of the glass left below to the current glass
     *
     * @param index the index
     * @param row   the current row
     * @return the position of the glass left below
     */
    private int leftPos(final int index, final int row) {
        return index + row + 1;
    }


    /**
     * Determines the position of the glass right below to the current glass
     *
     * @param index the index
     * @param row   the current row
     * @return the position of the glass right below
     */
    private int rightPos(final int index, final int row) {
        return index + row + 2;
    }
}
