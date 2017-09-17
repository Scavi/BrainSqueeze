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


public class SumPathTest {

    @Test
    public void test1() {
        Tree<Integer> root = new Tree<>(4);
        Tree<Integer> l = new Tree<>(1);
        Tree<Integer> ll = new Tree<>(-2);
        Tree<Integer> llr = new Tree<>(3);

        Tree<Integer> r = new Tree<>(3);
        Tree<Integer> rl = new Tree<>(1);
        Tree<Integer> rr = new Tree<>(2);
        Tree<Integer> rrl = new Tree<>(-4);
        Tree<Integer> rrr = new Tree<>(-3);

        root.left = l;
        root.right = r;
        l.left = ll;
        ll.right = llr;
        r.right = rr;
        r.left = rl;
        rr.left = rrl;
        rr.right = rrr;

        Assert.assertFalse(new SumPath().hasPathWithGivenSum(root, 7));
    }
}