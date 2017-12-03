package com.scavi.brainsqueeze.adventofcode.util;

public enum Direction {
    Unknown(-1), East(0), North(1), West(2), South(3);
    private int _value;

    Direction(final int value) {
        _value = value;
    }

    public static Direction valueOf(final int value) {
        Direction dir = Unknown;
        for (int i = 0; i < values().length && dir == Unknown; ++i) {
            dir = value == values()[i].getValue() ? values()[i] : Unknown;
        }
        return dir;
    }

    public int getValue() {
        return _value;
    }
}
