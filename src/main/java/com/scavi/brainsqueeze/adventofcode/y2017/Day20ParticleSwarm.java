package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.util.PrimitiveHelper;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day20ParticleSwarm {

    public int solveA(@Nonnull final String[] puzzleInput) {
        List<Particle> allParticles = Particle.from(puzzleInput);
        Particle smallest = null;
        for (Particle particle : allParticles) {
            if (smallest == null || particle.acceleration() < smallest.acceleration() ||
                    (smallest.acceleration() == particle.acceleration() && particle.point() < smallest.point())) {
                smallest = particle;
            }
        }
        return smallest._pos;
//        return solve(allParticles, false);
    }

    public int solveB(@Nonnull final String[] puzzleInput) {
        List<Particle> allParticles = Particle.from(puzzleInput);
        solve(allParticles, true);
        return allParticles.size();
    }

    private int solve(final List<Particle> allParticles, final boolean areParticlesDestroyed) {
        int closestPosition = 0;
        int closestCount = 0;
        while (closestCount < 300) { // TODO I don't like this. There should be a smarter solution
            Map<Particle, Integer> collided = new HashMap<>();
            PriorityQueue<long[]> particleDistances = new PriorityQueue<>(Comparator.comparingLong(x -> x[0]));
            int j = 0;
            for (Particle particle : allParticles) {
                particle.move();
                if (areParticlesDestroyed) {
                    int count = collided.getOrDefault(particle, 0);
                    collided.put(particle, count + 1);
                }
                particleDistances.offer(new long[]{Math.abs(particle.getDistance()), j});
                j++;
            }
            if (areParticlesDestroyed) {
                allParticles.removeIf(current -> collided.getOrDefault(current, 0) > 1);
            }
            if (particleDistances.peek()[1] == closestPosition) {
                closestCount++;
            }
            closestPosition = (int) particleDistances.poll()[1];
        }
        return closestPosition;
    }


    static class Particle {
        private int _pos;
        private int[] _point;
        private int[] _velocity;
        private int[] _acceleration;
        private long _distance;

        Particle(final int pos, final String[] data) {
            _pos = pos;
            _point = PrimitiveHelper.toIntArray(data[0], ",");
            _velocity = PrimitiveHelper.toIntArray(data[1], ",");
            _acceleration = PrimitiveHelper.toIntArray(data[2], ",");
        }

        public void move() {
            _distance = 0;
            for (int i = 0; i < 3; ++i) {
                _velocity[i] += _acceleration[i];
                _point[i] += _velocity[i];
                _distance += Math.abs(_point[i]);
            }
        }

        public int acceleration() {
            return Math.abs(_acceleration[0]) + Math.abs(_acceleration[1]) + Math.abs(_acceleration[2]);
        }

        public int point() {
            return Math.abs(_point[0]) + Math.abs(_point[1]) + Math.abs(_point[2]);
        }

        public int hashCode() {
            return Objects.hash(_point[0], _point[1], _point[2]);
        }

        public boolean equals(final Object obj) {
            if (obj == null || obj.getClass() != Particle.class) {
                return false;
            }
            Particle compare = (Particle) obj;
            return compare._point[0] == _point[0] && compare._point[1] == _point[1] && compare._point[2] == _point[2];
        }

        public long getDistance() {
            return _distance;
        }

        protected static List<Particle> from(final String[] puzzleInput) {
            Pattern particleData = Pattern.compile("(?<=(\\<))[^\\>]*", Pattern.CASE_INSENSITIVE);
            // use linked list even we know the size - it will enhance the removal of destroyed particles
            List<Particle> allParticles = new LinkedList<>();
            for (int i = 0; i < puzzleInput.length; ++i) {
                String[] data = new String[3];
                Matcher particleMatcher = particleData.matcher(puzzleInput[i]);
                int dataPos = 0;
                while (particleMatcher.find()) {
                    data[dataPos++] = particleMatcher.group();
                }
                allParticles.add(new Particle(i, data));
            }
            return allParticles;
        }
    }
}