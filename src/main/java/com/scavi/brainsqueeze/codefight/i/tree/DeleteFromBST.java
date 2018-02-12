package com.scavi.brainsqueeze.codefight.i.tree;

import com.scavi.brainsqueeze.codefight.util.Tree;

public class DeleteFromBST {
    Tree<Integer> deleteFromBST(Tree<Integer> t, int[] queries) {
        if (t == null) {
            return t;
        }
        for (int query : queries) {
            t = deleteFromBST(t, query);
        }
        return t;
    }


    private Tree<Integer> deleteFromBST(Tree<Integer> root, int query) {
        if (root == null) {
            return root;
        }

        // found value to delete
        if (root.value == query) {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root = root.right;
            } else {
                Tree<Integer> toReplace = leftRightMost(root);
                root.value = toReplace.value;
                root.left = deleteFromBST(root.left, root.value);
            }
        } else if (root.value < query) {
            root.right = deleteFromBST(root.right, query);
        } else {
            root.left = deleteFromBST(root.left, query);
        }
        return root;
    }


    private Tree<Integer> leftRightMost(Tree<Integer> current) {
        if (current.left == null) {
            return current;
        }
        Tree<Integer> last = null;
        current = current.left;
        while (current.right != null) {
            last = current;
            current = current.right;
        }
        if (last != null) {
            last.right = null;
        }
        return current;
    }


//    Tree<Integer> deleteFromBST(Tree<Integer> t, int[] queries) {
//        if (t == null) {
//            return t;
//        }
//
//        for (int query : queries) {
//            // root
//            if (query == t.value) {
//                Tree<Integer> newNode = leftRightMost(t);
//                if (newNode == t) {
//                    t = null;
//                    break;
//                } else {
//                    t = rearrange(null, t, newNode);
//                }
//            } else {
//                deleteFromBST(null, t, query);
//            }
//        }
//        return t;
//    }
//
//    private boolean deleteFromBST(Tree<Integer> parent, Tree<Integer> current, int query) {
//        if (current == null) {
//            return false;
//        }
//        boolean wasDeleted;
//        // found node to delete
//        if (current.value == query) {
//            // leaf node
//            if (current.left == null && current.right == null) {
//                rearrange(parent, current, null);
//            } else if (current.left == null) {
//                rearrange(parent, current, current.right);
//            } else if (current.right == null) {
//                rearrange(parent, current, current.left);
//            } else {
//                Tree<Integer> toReplace = leftRightMost(current);
//                rearrange(parent, current, toReplace);
//            }
//            wasDeleted = true;
//        } else {
//            wasDeleted = deleteFromBST(current, current.left, query);
//            if (!wasDeleted) {
//                wasDeleted = deleteFromBST(current, current.right, query);
//            }
//        }
//        return wasDeleted;
//    }
//
//
//    private Tree<Integer> rearrange(Tree<Integer> parent, Tree<Integer> currentToDelete, Tree<Integer> newNode) {
//        // root node was deleted
//        if (parent == null) {
//            currentToDelete.value = newNode.value;
//            parent = currentToDelete;
//        } else {
//            if (parent.left == currentToDelete) {
//                parent.left = newNode;
//            } else {
//                parent.right = newNode;
//            }
//        }
//        return parent;
//    }
//

}
