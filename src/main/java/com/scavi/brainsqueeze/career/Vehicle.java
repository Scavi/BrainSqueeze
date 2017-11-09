package com.scavi.brainsqueeze.career;

import java.util.HashMap;
import java.util.Map;

public enum Vehicle {
    car(1),
        toyota(11),
            camry(111),
            corolla(112),
        honda(12),
    truck(2),
        GMC(21);

    private final int _value;
    private static final Map<Integer, Vehicle> _allVehicles = new HashMap<>();
    static {
        for (Vehicle vehicle : values()) {
            _allVehicles.put(vehicle.getValue(), vehicle);
        }
    }

    Vehicle(final int value) {
        _value = value;

    }


    public int getValue() {
        return _value;
    }


    public static Vehicle parentOf(Vehicle vehicle) {
        if (vehicle.getValue() < 10) {
            throw new UnsupportedOperationException("No parent");
        }
        return _allVehicles.get(vehicle.getValue() / 10);
    }
}