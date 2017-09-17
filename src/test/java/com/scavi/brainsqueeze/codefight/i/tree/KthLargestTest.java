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

public class KthLargestTest {
    @Test
    public void test1() {
        Tree<Integer> root = new Tree<>(3);
        Tree<Integer> l = new Tree<>(1);
        Tree<Integer> r = new Tree<>(5);
        Tree<Integer> rl = new Tree<>(4);
        Tree<Integer> rr = new Tree<>(6);

        r.left = rl;
        r.right = rr;
        root.right  = r;
        root.left  = l;
        //Assert.assertEquals(3, new KthLargest().kthLargestInBST(root, 2));
        Assert.assertEquals(4, new KthLargest().kthLargestInBST(root, 3));
    }


    @Test
    public void test2() {
        Tree<Integer> root = new Tree<>(1);
        Tree<Integer> l = new Tree<>(-1);
        Tree<Integer> ll = new Tree<>(-2);
        Tree<Integer> lr = new Tree<>(0);

        l.left = ll;
        l.right = lr;
        root.left  = l;
        int retVal = new KthLargest().kthLargestInBST(root, 1);
        Assert.assertEquals(-2, retVal);
    }
}
