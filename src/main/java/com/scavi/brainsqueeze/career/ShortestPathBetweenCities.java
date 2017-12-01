package com.scavi.brainsqueeze.career;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ShortestPathBetweenCities {
    /**
     * Give all n cities the distance between them, and then you have to follow all the cities in the order of small to
     * large index of the city, which means you must visit the cities in ascending order, and now you can choose not to
     * visit k cities (k < n), ask choose not to go to which k cities can make the path shortest? Return the shortest
     * journey.
     */
    /**
     * The algorithm takes O(k) space (for PriorityQueue and HashMap).
     * The runtime is (O (k) + O((n - k) log k) to build up the heap and O(n) to iterate through the length of the matrix.
     */
    public int findShortestPath(@Nonnull int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix[0].length != matrix.length) {
            return -1;
        }
        PriorityQueue<Integer> minHeapForMaxDistance = new PriorityQueue<>(k);

        int currentDistance = 0;
        // determine the longest distances that will be skipped later. The longest distance will be added
        // into the min heap. If the current distance is > then the min, it will be replaced.
        // This takes (O (k) + O((n - k) log k)
        for (int i = 1; i < matrix.length; ++i) {
            currentDistance = matrix[i - 1][i];
            while (minHeapForMaxDistance.size() >= k &&
                    minHeapForMaxDistance.peek() < currentDistance) {
                minHeapForMaxDistance.poll();
            }

            if (minHeapForMaxDistance.size() < k) {
                minHeapForMaxDistance.offer(currentDistance);
            }
        }

        int shortestPath = 0;
        // after we found all max distances, we put them into a HashMap. The key is the max distance and the value the
        // amount of max distances in the matrix. s represents source, t represents target position.
        Map<Integer, Integer> maxDistances = from(minHeapForMaxDistance);
        for (int s = 0, t = 1; t < matrix.length; ++t) {
            currentDistance = matrix[s][t];

            // found a max distance. Skip it. e.g. the path from a-800->b-300->c and a-400->c. B will be skipped
            // and a->c will be used.
            if (maxDistances.containsKey(currentDistance) &&
                    maxDistances.get(currentDistance) > 0) {
                maxDistances.put(currentDistance, maxDistances.get(currentDistance) - 1);
            } else {
                shortestPath += currentDistance;
                s = t;
            }
        }
        return shortestPath;
    }


    /**
     * Converts the priority queue to the HashMap. The key is the distance, the value the amount of the distance.
     */
    private Map<Integer, Integer> from(PriorityQueue<Integer> minHeapForMaxDistances) {
        Map<Integer, Integer> maxDistances = new HashMap<>();

        int current;
        while (!minHeapForMaxDistances.isEmpty()) {
            current = minHeapForMaxDistances.poll();
            if (maxDistances.containsKey(current)) {
                maxDistances.put(current, maxDistances.get(current) + 1);
            } else {
                maxDistances.put(current, 1);
            }
        }
        return maxDistances;
    }
}

