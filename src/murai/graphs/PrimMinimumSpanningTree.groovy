package murai.graphs

import groovy.transform.ToString
import org.codehaus.groovy.runtime.StringGroovyMethods

class PrimMinimumSpanningTree {

    static void main(String[] args) {
        def minimumSpanningTree = new PrimMinimumSpanningTree()
        /*List<List<E>> graph =
                [
                        [new E(destV: 1, weight: 1), new E(destV: 2, weight: 4), new E(destV: 3, weight: 3)],
                        [new E(destV: 0, weight: 1), new E(destV: 3, weight: 2)],
                        [new E(destV: 0, weight: 4), new E(destV: 3, weight: 5)],
                        [new E(destV: 0, weight: 3), new E(destV: 2, weight: 5), new E(destV: 1, weight: 2)]
                ]//Min-spanning tree:[0, 1, 3, 2]*/

        List<List<E>> graph =
                [
                        [new E(destV: 1, weight: 2), new E(destV: 5, weight: 3)],
                        [new E(destV: 0, weight: 2), new E(destV: 5, weight: 5), new E(destV: 4, weight: 4), new E(destV: 2, weight: 3)],
                        [new E(destV: 1, weight: 3), new E(destV: 4, weight: 2), new E(destV: 3, weight: 3)],
                        [new E(destV: 2, weight: 3), new E(destV: 4, weight: 5)],
                        [new E(destV: 5, weight: 4), new E(destV: 1, weight: 4), new E(destV: 2, weight: 2), new E(destV: 3, weight: 5)],
                        [new E(destV: 0, weight: 3), new E(destV: 1, weight: 5), new E(destV: 4, weight: 4)]
                ]//1 Min-spanning tree:[0, 1, 5, 2, 4, 3], with cost=13
        minimumSpanningTree.findMST(graph)
    }

    void findMST(List<List<E>> adjList) {
        Set<Integer> mst = [] as LinkedHashSet
        PriorityQueue<E> priorityQueue = new PriorityQueue<>(adjList.size())
        int startVertex = 0
        int minWeight = 0
        mst.add(startVertex)
        populateEdges(adjList, startVertex, mst, priorityQueue)
        while (!priorityQueue.isEmpty()) {
            def topEdge = priorityQueue.poll()
            if (!mst.contains(topEdge.destV)) {
                mst.add(topEdge.destV)
                minWeight = minWeight + topEdge.weight
                populateEdges(adjList, topEdge.destV, mst, priorityQueue)
            }
        }
        println("Min-spanning tree cost=$minWeight for path:${mst}")
    }

    private void populateEdges(List<List<E>> adjList, int vertex, Set<Integer> mst, PriorityQueue<E> priorityQueue) {

        println("AdjList for vertex, $vertex is =${adjList[vertex]}")
        for (int i = 0; i < adjList[vertex].size(); i++) {
            def edge = adjList[vertex][i]
            if (!mst.contains(edge.destV)) {
                priorityQueue.add(adjList[vertex][i])
            }
        }
    }
}

class E implements Comparable<E> {
    int destV
    int weight

    @Override
    int compareTo(E o) {
        return weight <=> o.weight
    }

    String toString() {
        "destV=$destV,weight=$weight"
    }
}

