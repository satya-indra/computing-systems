package org.example.graph.prims;

import java.util.*;
import java.util.concurrent.ConcurrentMap;

/**
 * In a given graph, find the minimum cost required to connect all nodes/vertex
 * Minumim Spanning Tree :
 * Its a subgraph of given graph --> Its like a connected acyclic tree, spanning means all vertices all there, minimum here means sum of all edges in min.
 */
public class PrimsMinimumSpanningTree {

    static class Pair {
        int from;
        int neighbour;
        int weight;

        public Pair(int from, int neighbour, int weight) {
            this.from = from;
            this.neighbour = neighbour;
            this.weight = weight;
        }

    }

    public static void main(String[] args) {
        int vertex = 7;

        List<Edge>[] graph = getGraph(getInputLists(), vertex);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt((o1) -> o1.weight));

        pq.add(new Pair(0, 0, 0));

        Set<Integer> visited = new HashSet<>();

        StringBuilder path = new StringBuilder();
        int minWeight = 0;

        // we want to check vertex | acquiring vertex | weight
        while (!pq.isEmpty()) {

            Pair pair = pq.poll();

            if (visited.contains(pair.neighbour)) {
                continue;
            }

            visited.add(pair.neighbour);

            // do work
            if (pair.from != 0 || pair.neighbour != 0) {
                path.append("from ").append(pair.from).append(" to ").append(pair.neighbour).append(" @ weight ").append(pair.weight).append(" | ");
                minWeight+= pair.weight;
            }


            for (Edge edge : graph[pair.neighbour]) {
                if (!visited.contains(edge.neighbour))
                    pq.add(new Pair(edge.source, edge.neighbour, edge.weight));
            }

        }

        System.out.print(path);
        System.out.print( "total min cost : " + minWeight);
        

    }


    private static List<Edge>[] getGraph(List<List<Integer>> input, int totalVertex) {

        List<Edge>[] graph = new ArrayList[totalVertex];

        for (List<Integer> in : input) {
            List<Edge> res = graph[in.get(0)];
            if(res == null) {
                res = new ArrayList<>();
            }
            res.add(new Edge(in.get(0), in.get(1), in.get(2)));
            graph[in.get(0)] = res;

            List<Edge> res2 = graph[in.get(1)];
            if(res2 == null) {
                res2 = new ArrayList<>();
            }
            res2.add(new Edge(in.get(1), in.get(0), in.get(2)));
            graph[in.get(1)] = res2;


        }
        return graph;
    }

    private static List<List<Integer>> getInputLists() {
        List<List<Integer>> input = new ArrayList<>();
        input.add(List.of(0, 1, 10));
        input.add(List.of(0, 3, 25));
        input.add(List.of(1, 2, 26));
        input.add(List.of(2, 3, 10));
        input.add(List.of(3, 4, 2));
        input.add(List.of(4, 5, 3));
        input.add(List.of(4, 6, 8));
        input.add(List.of(5, 6, 3));
        return input;
    }


    static class Edge implements Comparable<Edge> {
        int source;
        int neighbour;
        int weight;

        public Edge(int source, int neighbour, int weight) {
            this.source = source;
            this.neighbour = neighbour;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

}
