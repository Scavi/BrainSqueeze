package com.scavi.brainsqueeze.adventofcode.y2017;

import com.scavi.brainsqueeze.adventofcode.util.Tower;

import static com.scavi.brainsqueeze.adventofcode.util.Tower.Node;

import java.util.HashMap;
import java.util.Map;

public class Day7RecursiveCircus {

    /**
     * Iterates through all nodes of the given tower and find to each node the amount of sub nodes.
     * In case the amount of sub nodes + the root node is equal to all existing nodes in the tower, the root node is
     * found.
     * The algorithm runs in O(n*m) time and uses beside the recursion no additional space
     *
     * @param tower the tower containing all nodes and their correlation
     * @return the name of the root node.
     */
    public String solveA(final Tower tower) {
        for (Map.Entry<String, Node> current : tower.getAllNodes().entrySet()) {
            int iterated = solveA(current.getValue());
            if (iterated == tower.getAllNodes().size()) {
                return current.getValue().getName();
            }
        }
        return null;
    }

    private int solveA(final Node current) {
        int cnt = 1;
        for (Node subNode : current.getNodes()) {
            cnt += solveA(subNode);
        }
        return cnt;
    }


    /**
     * Determines the root node ({@link #solveA(Tower)}
     *
     * @param tower the tower containing all nodes and their correlation
     * @return the new weight to balance
     */
    public int solveB(final Tower tower) {
        String rootNodeName = solveA(tower);
        Node rootNode = tower.getAllNodes().get(rootNodeName);
        return solveB(rootNode).weightBalance;
    }


    private Result solveB(final Node current) {
        if (current == null || current.getNodes().size() == 0) {
            return new Result();
        }
        Map<Integer, Result> discLookup = new HashMap<>();
        int sum = 0;
        for (Node subNode : current.getNodes()) {
            Result result = solveB(subNode);
            result.subNode = subNode;
            // found the evil node ;-) - stop the search
            if (result.weightBalance != 0) {
                return result;
            }
            // determines the sum for this level and updates the balance of the nodes. The balance is required to
            // determine which one of the nodes is the evil node that causes the unbalance
            int tmpSum = subNode.getWeight() + result.sum;
            if (discLookup.containsKey(tmpSum)) {
                discLookup.get(tmpSum).discBalance++;
            } else {
                discLookup.put(tmpSum, result);
            }
            sum += tmpSum;
        }
        // if the size is higher than 1 an unbalance was found.
        return discLookup.size() > 1 ? findUnbalance(discLookup) : new Result(sum);
    }


    /**
     * Tries to find the node that causes the unbalance based on the currently known nodes on this disc
     *
     * @param discLookup the the correlation of sum to results on the current disc
     * @return the node or <code>null</code> if the node can't get determined yet
     */
    private Result findUnbalance(final Map<Integer, Result> discLookup) {
        Map.Entry<Integer, Result> prev = null;
        for (Map.Entry<Integer, Result> currentErrorLookup : discLookup.entrySet()) {
            if (prev != null && prev.getValue().discBalance != currentErrorLookup.getValue().discBalance) {
                Result errorResult = new Result();
                int diff = Math.abs(prev.getKey() - currentErrorLookup.getKey());
                errorResult.weightBalance = currentErrorLookup.getValue().subNode.getWeight() - diff;
                return errorResult;
            }
            prev = currentErrorLookup;
        }
        return null;
    }


    private final class Result {
        private int sum;
        private Node subNode;
        private int weightBalance;
        private int discBalance = 1;

        Result() {
            this(0);
        }

        Result(int sum) {
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "" + sum;
        }
    }
}