package com.scavi.brainsqueeze.codefight.i.tree;

import com.scavi.brainsqueeze.codefight.util.Tree;

import java.util.stream.IntStream;

public class RestoreBinaryTree {

    private int preOrderIndex;

    public Tree<Integer> restoreBinaryTree(final int[] inorder, final int[] preorder) {
        preOrderIndex = 0;
        return restoreBinaryTree(inorder, preorder, 0, inorder.length);
    }


    private Tree<Integer> restoreBinaryTree(
            final int[] inorder,
            final int[] preorder,
            final int start,
            final int end) {
        if (start > end) {
            return null;
        } else if (preOrderIndex >= preorder.length) {
            return null;
        }
        Tree<Integer> node = new Tree<>(preorder[preOrderIndex++]);
        if (start == end) {
            return node;
        }

        int inOrderIndex = IntStream.range(start, end + 1).filter(i -> node.value == inorder[i]).findFirst().orElse(-1);
        if (inOrderIndex == -1) {
            return null;
        }
        node.left = restoreBinaryTree(inorder, preorder, start, inOrderIndex - 1);
        node.right = restoreBinaryTree(inorder, preorder, inOrderIndex + 1, end);
        return node;
    }
}
