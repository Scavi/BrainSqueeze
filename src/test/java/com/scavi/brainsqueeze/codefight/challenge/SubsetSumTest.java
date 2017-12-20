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

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.*;

public class SubsetSumTest {
    @Test
    public void testSubsetDividable1() {
        Assert.assertTrue(new SubsetSum().isSubsetDividable(new int[]{3, 5, 2, 6}));
    }

    @Test
    public void testSubsetDividable2() {
        Assert.assertTrue(new SubsetSum().isSubsetDividable(new int[]{3, 5, 16, 8}));
    }

    @Test
    public void testSubsetDividable3() {
        Assert.assertFalse(new SubsetSum().isSubsetDividable(new int[]{5, 7, 1}));
    }

    @Test
    public void testFindKElementsOfSum1() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 5, 2, 3, 4, 6, 7, 8, 9));
        List<List<Integer>> result = new SubsetSum().findKElementsOfSum(input, 3, 9);
        assertThat(result.size()).isEqualTo(10);
        assertThat(result.get(0)).isEqualTo(Arrays.asList(1, 2, 6));
    }
}
