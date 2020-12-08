package com.scavi.brainsqueeze.adventofcode.util

class GraphAccess<N> {
    private val _graph: MutableMap<N, MutableSet<Edge<N>>> = mutableMapOf()

    fun addEdge(sourceNode: N, targetNode: N, weight: Int = 0) {
        if (!_graph.containsKey(targetNode)) {
            _graph[targetNode] = mutableSetOf()
        }
        if (_graph.containsKey(sourceNode)) {
            _graph[sourceNode]!!.add(Edge(targetNode, weight))
        } else {
            _graph[sourceNode] = mutableSetOf(Edge(targetNode, weight))
        }
    }

    fun findPossiblePathTo(lookup: N): Int {
        var pathCount = 0
        for ((node, edges) in _graph) {
            val cache = mutableSetOf<N>()
            if (node != lookup && edges.size > 0) {
                for (edge in edges) {
                    pathCount += followEdge(lookup, edge.targetNode, cache)
                }
            }
        }
        return pathCount
    }

    fun getGraph() : MutableMap<N, MutableSet<Edge<N>>> {
        return _graph
    }

    private fun followEdge(lookup: N, edge: N, cache: MutableSet<N>): Int {
        if (cache.contains(edge)) {
            return 0
        }
        cache.add(edge)
        if (lookup == edge) {
            return 1
        }
        var pathCount = 0
        for (e in _graph[edge]!!.iterator()) {
            pathCount += followEdge(lookup, e.targetNode, cache)
        }
        return pathCount
    }

    data class Edge<K>(val targetNode: K, val weight: Int)
}
