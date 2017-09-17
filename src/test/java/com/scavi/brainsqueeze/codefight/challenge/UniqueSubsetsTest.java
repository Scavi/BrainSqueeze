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

import com.scavi.brainsqueeze.codefight.challenge.UniqueSubsets;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Scavenger on 5/28/2017.
 */
public class UniqueSubsetsTest {
    @Test
    public void test1() {
        int[][] result = new UniqueSubsets().sumSubsets(new int[]{1, 2, 3, 4, 5}, 5);
        Assert.assertEquals(3, result.length);
        Assert.assertArrayEquals(new int[]{1, 4}, result[0]);
        Assert.assertArrayEquals(new int[]{2, 3}, result[1]);
        Assert.assertArrayEquals(new int[]{5}, result[2]);
    }


    @Test
    public void test2() {
        int[][] result = new UniqueSubsets().sumSubsets(new int[]{1, 2, 2, 3, 4, 5}, 5);
        Assert.assertEquals(4, result.length);
        Assert.assertArrayEquals(new int[]{1, 2, 2}, result[0]);
        Assert.assertArrayEquals(new int[]{1, 4}, result[1]);
        Assert.assertArrayEquals(new int[]{2, 3}, result[2]);
        Assert.assertArrayEquals(new int[]{5}, result[3]);
    }


    @Test
    public void test3() {
        int[][] result = new UniqueSubsets().sumSubsets(new int[]{1, 1, 2, 2, 2, 5, 5, 6, 8, 8}, 9);
        Assert.assertEquals(4, result.length);
        Assert.assertArrayEquals(new int[]{1, 1, 2, 5}, result[0]);
        Assert.assertArrayEquals(new int[]{1, 2, 6}, result[1]);
        Assert.assertArrayEquals(new int[]{1, 8}, result[2]);
        Assert.assertArrayEquals(new int[]{2, 2, 5}, result[3]);
    }

    @Test
    public void test4() {
        int[][] result = new UniqueSubsets().sumSubsets(new int[]{1, 1, 2, 4, 4, 4, 7, 9, 9, 13, 13, 13, 15, 15, 16, 16, 16, 19, 19, 20}, 36);
        Assert.assertEquals(49, result.length);
    }
}

