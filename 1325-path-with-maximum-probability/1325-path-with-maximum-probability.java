class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair<Integer, Double>>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++ ) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++ ) {
            graph.get(edges[i][0]).add(new Pair<Integer, Double>(edges[i][1], succProb[i]));
            graph.get(edges[i][1]).add(new Pair<Integer, Double>(edges[i][0], succProb[i]));
        }

        // Max Probability Array for each node
        double[] prob = new double[n];
        prob[start_node] = 1d;

        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) -> -Double.compare(a.getKey(), b.getKey()));
        pq.add(new Pair<>(prob[start_node], start_node));

        while (!pq.isEmpty()) {
            Pair<Double, Integer> candidate = pq.poll();
            double currentProb = candidate.getKey();
            int currentNode = candidate.getValue();

            if (currentNode == end_node) {
                return currentProb;
            }

            for (Pair<Integer, Double> next : graph.get(currentNode)) {
                int nextNode = next.getKey();
                double nextProb = next.getValue();

                if (currentProb * nextProb > prob[nextNode]) {
                    prob[nextNode] = currentProb * nextProb;
                    pq.add(new Pair<Double, Integer>(prob[nextNode], nextNode));
                }
            }

            graph.get(currentNode).clear();
        }

        return prob[end_node];
    }
}