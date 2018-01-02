package com.scavi.brainsqueeze.codefight.i.ht;

import java.util.*;

public class SwapLexOrder {
    String swapLexOrder(String str, int[][] pairs) {
        Map<Integer, List<Integer>> graph = createPairGraph(pairs);

        List<List<Integer>> linked = createLinkedPairs(graph);
        char[] data = str.toCharArray();

        for (List<Integer> entry : linked) {
            PriorityQueue<Character> chars = new PriorityQueue<>(entry.size(), Comparator.reverseOrder());
            for (int pos : entry) {
                chars.offer(data[pos]);
            }
            for (int pos : entry) {
                data[pos] = chars.poll();
            }
        }
        return String.valueOf(data);
    }


    private List<List<Integer>> createLinkedPairs(final Map<Integer, List<Integer>> graph) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> used = new HashSet<>();

        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            LinkedList<Integer> linked = new LinkedList<>();
            createLinkedPairs(graph, linked, used, entry.getKey());
            if (linked.size() > 0) {
                Collections.sort(linked);
                result.add(linked);
            }
        }
        return result;
    }


    private void createLinkedPairs(
            final Map<Integer, List<Integer>> graph,
            final LinkedList<Integer> linked,
            Set<Integer> used,
            final Integer currentValue) {
        if (used.contains(currentValue)) {
            return;
        }
        add(linked, currentValue, used);
        for (Integer value : graph.get(currentValue)) {
            createLinkedPairs(graph, linked, used, value);
        }
    }

    private Map<Integer, List<Integer>> createPairGraph(final int[][] pairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : pairs) {
            int p1 = pair[0] - 1;
            int p2 = pair[1] - 1;
            add(graph, p1, p2);
            add(graph, p2, p1);
        }
        return graph;
    }

    private void add(LinkedList<Integer> linked, Integer entry, Set<Integer> used) {
        if (!used.contains(entry)) {
            linked.add(entry);
            used.add(entry);
        }
    }

    private void add(Map<Integer, List<Integer>> graph, final int value1, final int value2) {
        if (graph.containsKey(value1)) {
            graph.get(value1).add(value2);
        } else {
            List<Integer> links = new ArrayList<>();
            links.add(value2);
            graph.put(value1, links);
        }
    }
}
