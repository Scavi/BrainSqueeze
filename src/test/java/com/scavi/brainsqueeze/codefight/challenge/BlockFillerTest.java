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

import com.scavi.brainsqueeze.codefight.challenge.BlockFiller;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Scavenger on 6/14/2017.
 */
public class BlockFillerTest {
    @Test
    public void test1() {
        Assert.assertEquals(1, new BlockFiller().fillingBlocks(1));
    }

    @Test
    public void test2() {
        Assert.assertEquals(36, new BlockFiller().fillingBlocks(4));
    }

    @Test
    public void test3() {
        Assert.assertEquals(5, new BlockFiller().fillingBlocks(2));
    }

    @Test
    public void test4() {
        Assert.assertEquals(18061, new BlockFiller().fillingBlocks(10));
    }

    @Test
    public void test5() {
        Assert.assertEquals(145601, new BlockFiller().fillingBlocks(12));
    }

    @Test
    public void test6() {
        Assert.assertEquals(3335651, new BlockFiller().fillingBlocks(15));
    }

    @Test
    public void test7() {
        Assert.assertEquals(616891945, new BlockFiller().fillingBlocks(20));
    }

    @Test
    public void test8() {
        Assert.assertEquals(1752296281, new BlockFiller().fillingBlocks(21));
    }
}
