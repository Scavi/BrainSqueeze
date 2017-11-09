package com.scavi.brainsqueeze.career;

import org.junit.Test;
import static com.google.common.truth.Truth.assertThat;

public class VehicleTest {

    @Test
    public void test1() {
        Vehicle parent = Vehicle.parentOf(Vehicle.corolla);
        assertThat(parent).isEqualTo(Vehicle.toyota);
    }
}
