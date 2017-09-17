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

import com.scavi.brainsqueeze.codefight.challenge.SubsetSum;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Scavenger on 5/28/2017.
 */
public class SubsetSumTest {
    @Test
    public void test1() {
        Assert.assertTrue(new SubsetSum().subsetSum(new int[]{3, 5, 2, 6}));
    }

    @Test
    public void test2() {
        Assert.assertTrue(new SubsetSum().subsetSum(new int[]{3, 5, 16, 8}));
    }

    @Test
    public void test3() {
        Assert.assertFalse(new SubsetSum().subsetSum(new int[]{5, 7, 1}));
    }
}
