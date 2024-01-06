package 贪心算法;

import java.util.Arrays;

/**
 * 迪杰斯特拉算法求最短路径
 */
public class DijkstraAlgorithm {
    public static void dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int minDist = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    minIndex = j;
                }
            }

            visited[minIndex] = true;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && graph[minIndex][j] != 0 && dist[minIndex] != Integer.MAX_VALUE
                        && dist[minIndex] + graph[minIndex][j] < dist[j]) {
                    dist[j] = dist[minIndex] + graph[minIndex][j];
                }
            }
        }

        // 输出最短路径
        System.out.println("节点A到各顶点的最短路径:");
        for (int i = 0; i < n; i++) {
            System.out.println("A到顶点"+(char)(i+65) + "的最短距离为: " + dist[i]);
        }
    }


    /*
     * 例子:采用Dijkstra算法求下图中从点A到到其他各个顶点的最短路径：
     * A-B:1
     * A-D:2
     * B-C:3
     * B-D:4
     * C-D:1
     * C-E:2
     * C-F:2
     * E-F:2
     */
    public static void main(String[] args) {
        /**
         * A-B:1 A-D:2 B-C:3 B-D:4 C-D:1 C-E:2 C-F:2 E-F:2
         */
        int[][] graph = {
                {0, 1, 0, 2, 0, 0},
                {1, 0, 3, 4, 0, 0},
                {0, 3, 0, 1, 2, 2},
                {2, 4, 1, 0, 3, 0},
                {0, 0, 2, 3, 0, 2},
                {0, 0, 2, 0, 2, 0},
        };

        dijkstra(graph, 0);
    }
}


