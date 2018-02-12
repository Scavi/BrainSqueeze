package com.scavi.brainsqueeze.codefight.i.dfsbfs;

import com.scavi.brainsqueeze.codefight.util.Tree;
import org.junit.Test;
import static com.google.common.truth.Truth.assertThat;

public class DigitTreeSumTest {
    @Test
    public void test1(){
        Tree<Integer> root = new Tree<>(1);
        root.left = new Tree<>(0);
        root.left.left = new Tree<>(3);
        root.left.right = new Tree<>(1);
        root.right = new Tree<>(4);

        long result = new DigitTreeSum().digitTreeSum(root);
        assertThat(218).isEqualTo(result);
    }


    @Test
    public void test2(){
        Tree<Integer> root = new Tree<>(0);
        root.left = new Tree<>(1);

        long result = new DigitTreeSum().digitTreeSum(root);
        assertThat(1).isEqualTo(result);
    }
}
