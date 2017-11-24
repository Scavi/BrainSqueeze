/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.scavi.brainsqueeze.career;

import com.google.common.base.Preconditions;
import com.scavi.brainsqueeze.util.Point;

import java.util.*;

/**
 * Created by Scavenger on 5/13/2017.
 */
public class ClosestPoints {
    /**
     * This method uses a max heap to keep track of the k min values to 0.
     * This algorithm runs in O(k + (n-k) log k) and uses O(k) space.
     *
     * @param points the k points. int[0] represents the x coordinate, int[1] the y coordinate
     * @param k      the k closest points to 0
     * @return the k closest points
     */
    public int[][] findClosestPointsTo0(final int[][] points, final int k) {
        Preconditions.checkArgument(k < points.length, "Illegal argument! More required points than available");

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(k, (o1, o2) -> {
            double d1 = distanceTo0(o1[0], o1[1]);
            double d2 = distanceTo0(o2[0], o2[1]);
            return Double.compare(d2, d1);
        });
        // add the first k entries into the heap
        for (int i = 0; i < k; ++i) {
            maxHeap.offer(points[i]);
        }

        double currentDistance;
        double maxHeapDistance;
        for (int i = k; i < points.length; ++i) {
            int[] currentPoint = points[i];
            currentDistance = distanceTo0(currentPoint[0], currentPoint[1]);
            maxHeapDistance = distanceTo0(maxHeap.peek()[0], maxHeap.peek()[1]);

            if (Double.compare(currentDistance, maxHeapDistance) < 0) {
                maxHeap.remove(maxHeap.peek());
                maxHeap.offer(currentPoint);
            }
        }

        // put the results of the maxHeap into the result array
        int[][] result = new int[k][2];
        for (int i = 0; i < k; ++i) {
            result[i] = maxHeap.poll();
        }
        return result;
    }


    private double distanceTo0(final int x, final int y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}
