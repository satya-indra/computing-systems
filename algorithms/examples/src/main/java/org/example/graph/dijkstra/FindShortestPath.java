package org.example.graph.dijkstra;

import java.util.*;

/**
 * For un directed weighted non negative graph
 */
public class FindShortestPath {

    static class Path implements Comparable<Path> {
        int vertex;
        int weightSoFar;
        String psf;

        public Path(int vertex, int weightSoFar, String psf) {
            this.vertex = vertex;
            this.weightSoFar = weightSoFar;
            this.psf = psf;
        }

        @Override
        public int compareTo(Path o) {
            return this.weightSoFar - o.weightSoFar;
        }
    }

    public static void main(String[] args) {
        int totalVertex = 7;
        int source = 0;
        int destination = 6;
        List<Edge>[] graph = getGraph(getInputLists(), totalVertex);

        PriorityQueue<Path> pq = new PriorityQueue<>();
        pq.add(new Path(source, 0, source + ""));

        Set<Integer> visited = new HashSet<>();


        /**
         * RemoveAndCheck MarkStar DoWork AddToQueue
         * 1. Remove from queue
         * 2. Check if already visited
         * 3. mark it visited
         * 4. Do your work
         * 5. Add unvisited vertex in queue
         */
        while (!pq.isEmpty()) {
            // 1. Remove from queue
            Path path = pq.poll();
            // 2. Check if already visited
            if(visited.contains(path.vertex)) {
                continue;
            }
            // 3. mark it visisted
            visited.add(path.vertex);


            // 4. Do your work
            if(path.vertex == destination) {
                System.out.println(path.psf + " | " + path.weightSoFar);
            }

            // 5. Add unvisited vertex in queue
            for(Edge edge : graph[path.vertex]) {
                if(!visited.contains(edge.neighbour)) {
                    pq.add(new Path(edge.neighbour, path.weightSoFar + edge.weight, path.psf + " " + edge.neighbour));
                }
            }

        }



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
        input.add(List.of(0, 3, 40));
        input.add(List.of(1, 2, 10));
        input.add(List.of(2, 3, 10));
        input.add(List.of(3, 4, 2));
        input.add(List.of(4, 5, 3));
        input.add(List.of(4, 6, 5));
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
