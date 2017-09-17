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

package com.scavi.brainsqueeze.codefight.i.tree;

import com.scavi.brainsqueeze.codefight.util.Tree;
import org.junit.Assert;
import org.junit.Test;

public class SubtreeTest {
    @Test
    public void test1() {
        Tree<Integer> t1Root = new Tree<>(1);
        t1Root.left = new Tree<>(2);
        t1Root.right = new Tree<>(2);

        Tree<Integer> t2Root = new Tree<>(2);
        Assert.assertTrue(new Subtree().isSubtree(t1Root, t2Root));
    }
}

