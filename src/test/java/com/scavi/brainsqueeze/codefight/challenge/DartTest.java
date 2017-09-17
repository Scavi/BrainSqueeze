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

import com.scavi.brainsqueeze.codefight.challenge.Dart;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Scavenger on 6/25/2017.
 */
public class DartTest {
    @Test
    public void test1() {
        int score = new Dart().findScore(0, 0);
        Assert.assertEquals(10, score);
    }

    @Test
    public void test2() {
        int score = new Dart().findScore(1, 0);
        Assert.assertEquals(1, score);
    }

    @Test
    public void test3() {
        int score = new Dart().findScore(0.2, 0.2);
        Assert.assertEquals(8, score);
    }

    @Test
    public void test7() {
        int score = new Dart().findScore(0.3, 0.4);
        Assert.assertEquals(6, score);
    }

    @Test
    public void test8() {
        int score = new Dart().findScore(0, -0.2);
        Assert.assertEquals(9, score);
    }

    @Test
    public void test12() {
        int score = new Dart().findScore(-0.615538218153, 0.951369166449);
        Assert.assertEquals(0, score);
    }
}
