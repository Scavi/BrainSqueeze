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

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Scavenger on 7/4/2017.
 */
public class RotateImageTest {
    @Test
    public void test1() {
        int[][] input = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] output = new RotateImage().rotateImage(input);
        Assert.assertArrayEquals(new int[]{7, 4, 1}, output[0]);
        Assert.assertArrayEquals(new int[]{8, 5, 2}, output[1]);
        Assert.assertArrayEquals(new int[]{9, 6, 3}, output[2]);
    }

    @Test
    public void test2() {
        int[][] input = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] output = new RotateImage().rotateImage(input);
        Assert.assertArrayEquals(new int[]{13, 9, 5, 1}, output[0]);
        Assert.assertArrayEquals(new int[]{14, 10, 6, 2}, output[1]);
        Assert.assertArrayEquals(new int[]{15, 11, 7, 3}, output[2]);
        Assert.assertArrayEquals(new int[]{16, 12, 8, 4}, output[3]);
    }
}
