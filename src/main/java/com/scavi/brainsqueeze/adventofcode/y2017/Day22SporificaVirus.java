package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.adventofcode.util.Direction;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Day22SporificaVirus {
    public int solveA(@Nonnull final char[][] grid) {
        Map<Node, State> infected = determineInfected(grid);
        int infectionBursts = 0;
        Direction heading = Direction.North;
        Node virusCarrier = new Node(grid.length / 2, grid[0].length / 2);
        for (int i = 0; i < 10000; ++i) {
            heading = Direction.valueOf((infected.containsKey(virusCarrier) ?
                    heading.getValue() + 1 : heading == Direction.North ? 3 : heading.getValue() - 1) % 4);
            if (infected.containsKey(virusCarrier)) {
                infected.remove(virusCarrier);
            } else {
                infectionBursts++;
                infected.put(new Node(virusCarrier._x, virusCarrier._y), State.Infected);
            }
            move(virusCarrier, heading);
        }
        return infectionBursts;
    }

    public int solveB(@Nonnull final char[][] grid) {
        Map<Node, State> infected = determineInfected(grid);
        int infectionBursts = 0;
        Direction heading = Direction.North;
        Node virusCarrier = new Node(grid.length / 2, grid[0].length / 2);
        for (int i = 0; i < 10000000; ++i) {
            if (infected.containsKey(virusCarrier)) {
                switch (infected.get(virusCarrier)) {
                    case Infected:
                        heading = Direction.valueOf((heading.getValue() + 1) % 4);
                        break;
                    case Flagged:
                        heading = Direction.valueOf((heading.getValue() + 2) % 4);
                        break;
                }
            } else {
                heading = Direction.valueOf(heading == Direction.North ? 3 : heading.getValue() - 1);
            }
            if (infected.containsKey(virusCarrier)) {
                switch (infected.get(virusCarrier)) {
                    case Flagged:
                        infected.remove(virusCarrier);
                        break;
                    case Weakened:
                        infectionBursts++;
                        infected.put(virusCarrier, State.Infected);
                        break;
                    case Infected:
                        infected.put(virusCarrier, State.Flagged);
                        break;
                    default:
                        throw new IllegalArgumentException("the developer screwed up!");
                }
            } else {
                infected.put(new Node(virusCarrier._x, virusCarrier._y), State.Weakened);
            }
            move(virusCarrier, heading);
        }
        return infectionBursts;
    }

    private Map<Node, State> determineInfected(final char[][] grid) {
        Map<Node, State> infected = new HashMap<>(6000);
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[0].length; ++x) {
                if (grid[y][x] == '#') {
                    infected.put(new Node(x, y), State.Infected);
                }
            }
        }
        return infected;
    }


    private void move(final Node virusCarrier, final Direction heading) {
        switch (heading) {
            case North:
                virusCarrier._y--;
                break;
            case East:
                virusCarrier._x++;
                break;
            case South:
                virusCarrier._y++;
                break;
            case West:
                virusCarrier._x--;
                break;
            default:
                throw new IllegalArgumentException("the developer screwed up!");
        }
    }

    private class Node {
        private int _x;
        private int _y;

        public Node(int x, int y) {
            _x = x;
            _y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(_x, _y);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != Node.class) {
                return false;
            }
            Node compare = (Node) obj;
            return _x == compare._x && _y == compare._y;
        }
    }

    private enum State {
        Weakened, Infected, Flagged
    }
}
