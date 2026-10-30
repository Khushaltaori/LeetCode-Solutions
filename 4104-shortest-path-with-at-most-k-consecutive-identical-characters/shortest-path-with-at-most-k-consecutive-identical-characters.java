import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        // dist[node][count] = minimum distance to reach node
        // with count consecutive identical characters
        int[][] dist = new int[n][k + 1];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // {distance, node, consecutiveCount}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        dist[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int d = curr[0];
            int node = curr[1];
            int count = curr[2];

            if (d != dist[node][count]) {
                continue;
            }

            if (node == n - 1) {
                return d;
            }

            for (int[] next : adj[node]) {
                int v = next[0];
                int weight = next[1];

                int newCount;

                if (labels.charAt(node) == labels.charAt(v)) {
                    newCount = count + 1;
                } else {
                    newCount = 1;
                }

                if (newCount > k) {
                    continue;
                }

                int newDist = d + weight;

                if (newDist < dist[v][newCount]) {
                    dist[v][newCount] = newDist;
                    pq.offer(new int[]{newDist, v, newCount});
                }
            }
        }

        return -1;
    }
}