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

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 5/9/2017
 */
public class TaskArrangeTest {
    @Test
    public void test1() {
        TaskArrange taskArranger = new TaskArrange();
        String tasks = "AAABBBCCC";
        int result = taskArranger.rearrangeTasks(tasks, 3);
        Assert.assertEquals(9, result);
    }

    @Test
    public void test2() {
        TaskArrange taskArranger = new TaskArrange();
        String tasks = "AAABC";
        int result = taskArranger.rearrangeTasks(tasks, 3);
        Assert.assertEquals(7, result);
    }

    @Test
    public void test3() {
        TaskArrange taskArranger = new TaskArrange();
        String tasks = "AABAABDCCCCCC";
        int result = taskArranger.rearrangeTasks(tasks, 3);
        Assert.assertEquals("CABCABCADCA_C__C".length(), result);
    }
}
