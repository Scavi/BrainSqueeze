package com.scavi.brainsqueeze.career;

import org.junit.Test;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import static com.google.common.truth.Truth.*;

public class RobotTest {

    @Test
    public void test() {
        Map<Character, Integer> inputMap = createInput();
        Robot robot = new Robot(inputMap);
        List<String> actions = robot.moveRobot("HUGO");
        assertThat(actions.size()).isEqualTo(8);
        assertThat(actions.get(0)).isEqualTo("R8");
        assertThat(actions.get(1)).isEqualTo("T");
        assertThat(actions.get(2)).isEqualTo("R13");
        assertThat(actions.get(3)).isEqualTo("T");
        assertThat(actions.get(4)).isEqualTo("L14");
        assertThat(actions.get(5)).isEqualTo("T");
        assertThat(actions.get(6)).isEqualTo("R8");
        assertThat(actions.get(7)).isEqualTo("T");
    }

    private Map<Character, Integer> createInput() {
        Map<Character, Integer> inputMap = new HashMap<>(40);
        int base = 65;
        for (int i = 0; i < 26; ++i) {
            inputMap.put((char) (base + i), (i + 1));
        }
        return inputMap;
    }
}
