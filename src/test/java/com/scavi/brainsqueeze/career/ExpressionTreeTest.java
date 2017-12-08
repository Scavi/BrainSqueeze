package com.scavi.brainsqueeze.career;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class ExpressionTreeTest {
    @Test
    public void testFormula1() {
        ExpressionTree.Node node1 = new ExpressionTree.Node("1");
        ExpressionTree.Node node2 = new ExpressionTree.Node("2");
        ExpressionTree.Node node3 = new ExpressionTree.Node("3");
        ExpressionTree.Node node4 = new ExpressionTree.Node("4");
        ExpressionTree.Node nodePlus = new ExpressionTree.Node("+", node1, node2);
        ExpressionTree.Node nodeMinus = new ExpressionTree.Node("-", node3, node4);
        ExpressionTree.Node root = new ExpressionTree.Node("*", nodePlus, nodeMinus);

        ExpressionTree tree = new ExpressionTree();
        String result = tree.formula(root);
        assertThat(result).isEqualTo("(1 + 2) * (3 - 4)");
    }


    @Test
    public void testFormula2() {
        ExpressionTree.Node node1 = new ExpressionTree.Node("1");
        ExpressionTree.Node node2 = new ExpressionTree.Node("2");
        ExpressionTree.Node node3 = new ExpressionTree.Node("3");
        ExpressionTree.Node node4 = new ExpressionTree.Node("4");
        ExpressionTree.Node nodePlus = new ExpressionTree.Node("+", node1, node2);
        ExpressionTree.Node nodeMinus = new ExpressionTree.Node("-", node3, node4);
        ExpressionTree.Node root = new ExpressionTree.Node("+", nodePlus, nodeMinus);

        ExpressionTree tree = new ExpressionTree();
        String result = tree.formula(root);
        assertThat(result).isEqualTo("1 + 2 + 3 - 4");
    }


    @Test
    public void testCreateTree1() {
        ExpressionTree tree = new ExpressionTree();
        ExpressionTree.Node result = tree.createTree("* + 12-34");

        assertThat(result.toString()).isEqualTo("*");
        assertThat(result.getLeft().toString()).isEqualTo("+");
        assertThat(result.getLeft().getLeft().toString()).isEqualTo("1");
        assertThat(result.getLeft().getRight().toString()).isEqualTo("2");
        assertThat(result.getRight().toString()).isEqualTo("-");
        assertThat(result.getRight().getLeft().toString()).isEqualTo("3");
        assertThat(result.getRight().getRight().toString()).isEqualTo("4");
    }


    @Test
    public void testSolve() {
        ExpressionTree.Node node1 = new ExpressionTree.Node("1");
        ExpressionTree.Node node2 = new ExpressionTree.Node("2");
        ExpressionTree.Node node3 = new ExpressionTree.Node("3");
        ExpressionTree.Node node4 = new ExpressionTree.Node("4");
        ExpressionTree.Node nodePlus = new ExpressionTree.Node("+", node1, node2);
        ExpressionTree.Node nodeMinus = new ExpressionTree.Node("-", node3, node4);
        ExpressionTree.Node root = new ExpressionTree.Node("*", nodePlus, nodeMinus);

        ExpressionTree tree = new ExpressionTree();
        double expected = -3;
        double result = tree.solve(root);
        assertThat(result).isEqualTo(expected);
    }
}
