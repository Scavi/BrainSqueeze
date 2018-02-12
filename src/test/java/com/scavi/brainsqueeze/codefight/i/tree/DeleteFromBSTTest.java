package com.scavi.brainsqueeze.codefight.i.tree;

import com.scavi.brainsqueeze.codefight.util.Tree;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class DeleteFromBSTTest {
    @Test
    public void test1() {
        Tree<Integer> root = new Tree<>(5);
        root.left = new Tree<>(2);
        root.left.left = new Tree<>(1);
        root.left.right = new Tree<>(3);
        root.right = new Tree<>(6);
        root.right.right = new Tree<>(8);
        root.right.right.left = new Tree<>(7);

        Tree<Integer> result = new DeleteFromBST().deleteFromBST(root, new int[]{4, 5, 6});
        assertThat(result.value).isEqualTo(3);
        assertThat(result.left.value).isEqualTo(2);
        assertThat(result.left.left.value).isEqualTo(1);
        assertThat(result.left.right).isNull();
        assertThat(result.left.left.right).isNull();

        assertThat(result.right.value).isEqualTo(8);
        assertThat(result.right.right).isNull();
        assertThat(result.right.left.value).isEqualTo(7);
    }


    @Test
    public void test2() {
        Tree<Integer> root = new Tree<>(3);
        root.left = new Tree<>(2);

        Tree<Integer> result = new DeleteFromBST().deleteFromBST(root, new int[]{1, 2, 3, 5});
        assertThat(result).isNull();
    }

    @Test
    public void test3() {
        Tree<Integer> root = new Tree<>(3);
        root.left = new Tree<>(2);
        root.left.left = new Tree<>(1);
        root.right = new Tree<>(5);

        Tree<Integer> result = new DeleteFromBST().deleteFromBST(root, new int[]{3, 2, 1});
        assertThat(result.value).isEqualTo(5);
        assertThat(result.left).isNull();
        assertThat(result.right).isNull();
    }

//    @Test
//    public void test4() {
//        Tree<Integer> root = new Tree<>(7);
//        root.left = new Tree<>(2);
//        root.left.left = new Tree<>(1);
//
//        root.left.right = new Tree<>(6);
//        root.left.right.left = new Tree<>(3);
//        root.left.right.left = new Tree<>(5);
//
//        Tree<Integer> result = new DeleteFromBST().deleteFromBST(root, new int[]{6});
//    }


    @Test
    public void test5() {
        Tree<Integer> root = new Tree<>(4);
        root.left = new Tree<>(2);
        root.left.left = new Tree<>(1);
        root.left.right = new Tree<>(3);

        Tree<Integer> result = new DeleteFromBST().deleteFromBST(root, new int[]{4});
        assertThat(result.value).isEqualTo(3);
        assertThat(result.left.value).isEqualTo(2);
        assertThat(result.left.left.value).isEqualTo(1);
    }
}
