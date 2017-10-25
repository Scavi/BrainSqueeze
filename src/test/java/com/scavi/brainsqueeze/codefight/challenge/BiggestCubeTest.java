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

package com.scavi.brainsqueeze.codefight.challenge;

import org.junit.Assert;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class BiggestCubeTest {
    @Test
    public void test1() {
        int[] input = {1, 2, 3};
        int[] result = new BiggestCube().biggestCube(input);

        assertThat(result[0]).isEqualTo(1);
        assertThat(result[1]).isEqualTo(1);
    }

    @Test
    public void test2() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -20, -7};
        int[] result = new BiggestCube().biggestCube(input);
        assertThat(result[0]).isEqualTo(-27);
        assertThat(result[1]).isEqualTo(2);
    }

    @Test
    public void test3() {
        int[] input = {-51, -77, -54, -51, -46, -70, -89, -16, -4, -45, -70, -50, -82, -78, -92, -71, -2, -3, -12, -51, -4, -91, -53, -17, -4, -76, -34, -17, -20, 9, -80, -77, -40, -62, -4, -32, -49, -80, -27, -1, -79, -53, 2, -31, -79, -55, -14, -10, -96, -51, -59, -5, -37, -88, -26, -82, 3, 3, -44, -8, -2, 3, -15, -21, -80, -57, -9, -20, -80, -45, -30, -94, -90, -69, -26, -53, -16, -69, 0, -9, -20, -27, -5, -31, -56, -66, 9, -64, -69, -53, -70, 2, -55, -38, -35, -46, -56, -41, -76, -86, -66, -70, -38, -52, -12, -14, -71, -8, -28, -15, 7, -32, -80, -49, -26, 0, -32, -11, -29, -42, -33, -6, 7, -16, -56, -16, -33, -14, -65, -36, -1, -17, -19, -89, -13, -46, -3, -73, -66, -42, -32, -79, -69, -70, -56, 8, -90, 5, -42, -4, -42, -1, -96, -44, -30, -3, -9, -80, -64, -74, -7, -93, -72, -44, -13, -72, -82, 5, -38, -9, -32, -88, -72, -38, -81, -59, -95, -70, -95, -12, -11, -97, -48, -42, -98, -60, -48, -45, -60, -5, -17, -36, -41, -95, 2, -28, -71, -60, -95, -61};
        int[] result = new BiggestCube().biggestCube(input);
        assertThat(result[0]).isEqualTo(-8000);
        assertThat(result[1]).isEqualTo(133);


    }
}
