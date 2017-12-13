package com.scavi.brainsqueeze.util;

import javax.annotation.Nonnull;

public class Hex {
    private final int _x;
    private final int _y;
    private final int _z;

    public Hex(final int x, final int z) {
        _x = x;
        _y = (-1 * x) - z;
        _z = z;
    }

    public Hex subtract(@Nonnull final Hex hex1, @Nonnull final Hex hex2) {
        return new Hex(hex1.getX() - hex2.getX(), hex1.getZ() - hex2.getZ());
    }


    public int length(@Nonnull final Hex hex) {
        return (Math.abs(hex.getX()) + Math.abs(hex.getY()) + Math.abs(hex.getZ())) / 2;
    }


    public int distanceTo(@Nonnull final Hex hex) {
        Hex subtracted = subtract(this, hex);
        return length(subtracted);
    }


    public int getX() {
        return _x;
    }


    public int getY() {
        return _y;
    }


    public int getZ() {
        return _z;
    }
}
