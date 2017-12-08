package com.scavi.brainsqueeze.career;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExpressionTree {
    public static class Node {
        private Node _left;
        private Node _right;
        private final String _value;

        public Node(final String value) {
            this(value, null, null);
        }

        public Node(final String value, final Node left, final Node right) {
            _value = value;
            _left = left;
            _right = right;
        }

        public void setLeft(Node left) {
            _left = left;
        }

        public void setRight(Node right) {
            _right = right;
        }

        public Node getLeft() {
            return _left;
        }

        public Node getRight() {
            return _right;
        }

        @Override
        public String toString() {
            return _value;
        }
    }

    public String formula(Node root) {
        if (root == null) {
            return "";
        }
        return formula(root, false);
    }


    private String formula(final Node root, final boolean isBracket) {
        if (root.getLeft() == null && root.getRight() == null) {
            return root.toString();
        }
        boolean isSubBracket = root.toString().equals("*") || isBracket;
        String left = formula(root.getLeft(), isSubBracket);
        String right = formula(root.getRight(), isSubBracket);
        String result = isBracket ?
                String.format("(%s %s %s)", left, root.toString(), right) :
                String.format("%s %s %s", left, root.toString(), right);
        return result;
    }


    private final Set<Character> OPERATORS = new HashSet<>(Arrays.asList('+', '-', '*', '/'));

    public Node createTree(final String input) {
        if (input == null || input.length() == 0) {
            return null;
        }
        Node root = new Node(input.substring(0, 1));
        return createTree(input.replace(" ", ""), root, new int[]{0});
    }


    private Node createTree(final String input, final Node currentRoot, final int[] pos) {
        pos[0]++;
        if (OPERATORS.contains(input.charAt(pos[0]))) {
            Node operatorNode1 = new Node(String.valueOf(input.charAt(pos[0])));
            currentRoot.setLeft(createTree(input, operatorNode1, pos));

            Node operatorNode2 = new Node(String.valueOf(input.charAt(++pos[0])));
            currentRoot.setRight(createTree(input, operatorNode2, pos));
        } else {
            currentRoot.setLeft(new Node(String.valueOf(input.charAt(pos[0]))));
            currentRoot.setRight(new Node(String.valueOf(input.charAt(++pos[0]))));
        }
        return currentRoot;
    }


    public double solve(final Node root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return Double.parseDouble(root.toString());
        }

        double t1 = solve(root.getLeft());
        double t2 = solve(root.getRight());
        double result = 0;
        switch (root.toString()) {
            case "+":
                result = t1 + t2;
                break;
            case "-":
                result = t1 - t2;
                break;
            case "*":
                result = t1 * t2;
                break;
            case "/":
                result = t1 / t2;
                break;
            default:
                throw new IllegalArgumentException("Unknown operation: " + root.toString());
        }
        return result;
    }
}
