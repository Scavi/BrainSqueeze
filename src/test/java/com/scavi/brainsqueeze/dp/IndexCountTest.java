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

package com.scavi.brainsqueeze.dp;

import org.junit.Assert;
import org.junit.Test;

import static com.scavi.brainsqueeze.dp.IndexCount.Range;

/**
 * @author Michael Heymel
 * @since 29/11/16
 */
public class IndexCountTest {

    @Test
    public void test1() {
        Range[] inputRange =
                new Range[]{new Range(5, 7), new Range(1, 4), new Range(2, 3), new Range(6, 8),
                            new Range(3, 5)};
        int[] expectedOutput = new int[]{0, 1, 2, 3, 2, 2, 2, 2, 1};
        IndexCount indexCounter = new IndexCount();
        int[] output = indexCounter.countIndex(8, inputRange);

        Assert.assertArrayEquals(expectedOutput, output);
    }
}
