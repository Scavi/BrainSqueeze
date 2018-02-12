package com.scavi.brainsqueeze.codefight.i.g;

public class DeadlockAnalyse {
    boolean hasDeadlock(int[][] connections) {

        for (int i = 0; i < connections.length; ++i) {
            boolean[] isKnown = new boolean[connections.length];
            isKnown[i] = true;
            if (hasDeadlock(connections, isKnown, i)) {
                return true;
            }
        }
        return false;
    }


    private boolean hasDeadlock(final int[][] connections, final boolean[] isKnown, final int currentNodePos) {
        boolean isDeadlock = false;
        for (int pos : connections[currentNodePos]) {
            if (isKnown[pos]) {
                return true;
            }
            isKnown[pos] = true;
            isDeadlock = hasDeadlock(connections, isKnown, pos);
            if (isDeadlock) {
                break;
            }
            isKnown[pos] = false;
        }
        return isDeadlock;
    }
}
