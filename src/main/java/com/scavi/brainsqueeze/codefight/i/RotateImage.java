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

package com.scavi.brainsqueeze.codefight.i;

/**
 * Created by Scavenger on 7/4/2017.
 */
public class RotateImage {

    int[][] rotateImage(int[][] image) {
        for (int y = 0; y < image.length; ++y) {
            for (int x = y; x < image[0].length; ++x) {
                swap(image, x, y, y, x);
            }
        }
        int xLen = image[0].length - 1;
        for (int y = 0; y < image.length; ++y) {
            for (int x = 0; x < image[0].length / 2; x++) {
                swap(image, x, y, xLen - x, y);
            }
        }
        return image;
    }

    private void swap(int[][] image, int x1, int y1, int x2, int y2) {
        if (x1 != x2 || y1 != y2) {
            image[y1][x1] ^= image[y2][x2];
            image[y2][x2] ^= image[y1][x1];
            image[y1][x1] ^= image[y2][x2];
        }
    }
}
