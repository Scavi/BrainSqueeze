package com.scavi.brainsqueeze.career;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Robot {
    private final Map<Character, Integer> _alphabet;

    public Robot(final Map<Character, Integer> alphabet) {
        _alphabet = alphabet;
    }


    public List<String> moveRobot(final String message) {
        List<String> actions = new ArrayList<>(message.length() * 2);
        int currentPos = 0;
        for (char currentChar : message.toCharArray()) {

            if (!_alphabet.containsKey(currentChar)) {
                throw new IllegalArgumentException(
                        "Unknown character: " + currentChar);
            }
            int targetPos = _alphabet.get(currentChar);
            String move;
            // move right
            if (targetPos > currentPos) {
                move = String.format("%s%d", Actions.R, (targetPos - currentPos));
            }
            // move left
            else {
                move = String.format("%s%d", Actions.L, (currentPos - targetPos));
            }
            currentPos = targetPos;
            actions.add(move);
            actions.add(Actions.T.toString());
        }
        return actions;
    }

    private enum Actions {
        R, L, T
    }
}



