package com.scavi.brainsqueeze.codefight.arcade.graph;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class NewRoadSystemTest {

    @Test
    public void test1() {
        boolean[][] roadRegister = new boolean[][]{
                {false, true, false, false, false, false, false},
                {true, false, false, false, false, false, false},
                {false, false, false, true, false, false, false},
                {false, false, true, false, false, false, false},
                {false, false, false, false, false, false, true},
                {false, false, false, false, true, false, false},
                {false, false, false, false, false, true, false}};
        boolean isValid = new NewRoadSystem().newRoadSystem(roadRegister);
        assertThat(isValid).isTrue();
    }

}
