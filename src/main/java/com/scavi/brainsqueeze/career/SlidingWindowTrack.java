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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by Scavenger on 5/14/2017.
 * <p>
 * https://www.careercup.com/question?id=5655840062177280
 * how to keep track of the sum in a sliding window for the data that are on disk
 * rather than memory
 */
public class SlidingWindowTrack {
    public interface IWindowTrack {
        void track(Queue<Integer> slidingWindow);
    }

    public static class PrintWindowTrack implements IWindowTrack {
        public void track(Queue<Integer> slidingWindow) {
            if (slidingWindow != null) {
                for (Integer current : slidingWindow) {
                    System.out.print(current + " ");
                }
                System.out.println();
            }
        }
    }

    private final IWindowTrack _track;

    public SlidingWindowTrack(IWindowTrack track) {
        _track = track;
    }


    public void trackSum(Iterator<Integer> data, int windowSize) {
        Deque<Integer> slidingWindow = new ArrayDeque<>(windowSize);
        while (data.hasNext()) {
            if (slidingWindow.size() == windowSize) {
                slidingWindow.removeFirst();
            }
            slidingWindow.add(data.next());
            _track.track(slidingWindow);
        }
    }
}
