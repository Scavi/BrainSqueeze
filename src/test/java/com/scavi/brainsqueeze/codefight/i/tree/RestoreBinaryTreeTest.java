package com.scavi.brainsqueeze.codefight.i.tree;


import com.scavi.brainsqueeze.codefight.util.Tree;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class RestoreBinaryTreeTest {


    @Test
    public void test1() {
        int[] inorder = {2, 5};
        int[] preorder = {5, 2};
        Tree<Integer> result = new RestoreBinaryTree().restoreBinaryTree(inorder, preorder);
        assertThat(result.value).isEqualTo(5);
        assertThat(result.left.value).isEqualTo(2);
        assertThat(result.right).isNull();
        assertThat(result.left.left).isNull();
        assertThat(result.left.right).isNull();
    }

    @Test
    public void test2() {
        int[] inorder = {4, 2, 1, 5, 3, 6};
        int[] preorder = {1, 2, 4, 3, 5, 6};
        Tree<Integer> result = new RestoreBinaryTree().restoreBinaryTree(inorder, preorder);

        assertThat(result.value).isEqualTo(1);

        assertThat(result.left.value).isEqualTo(2);
        assertThat(result.left.left.value).isEqualTo(4);
        assertThat(result.left.left.left).isNull();
        assertThat(result.left.left.right).isNull();
        assertThat(result.left.right).isNull();

        assertThat(result.right.value).isEqualTo(3);
        assertThat(result.right.left.value).isEqualTo(5);
        assertThat(result.right.left.left).isNull();
        assertThat(result.right.left.right).isNull();

        assertThat(result.right.right.value).isEqualTo(6);
        assertThat(result.right.right.left).isNull();
        assertThat(result.right.right.right).isNull();
    }
}
