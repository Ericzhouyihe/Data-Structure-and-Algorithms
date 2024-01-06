package 贪心算法;

import java.util.Arrays;

/**
 * 迪杰斯特拉算法求最短路径
 */
public class DijkstraAlgorithm {
   public static void dijkstra(int[][] graph, int source) {
        // 初始化节点数量
        int n = graph.length;
        // 初始化距离数组
        int[] dist = new int[n];
        // 初始化距离数组，距离初始化为最大值
        Arrays.fill(dist, Integer.MAX_VALUE);
        // 距离源点的距离为0
        dist[source] = 0;

        // 初始化访问标记数组
        boolean[] visited = new boolean[n];

        // 循环n-1次，每次循环找到最小距离的节点，并更新距离数组
        for (int i = 0; i < n - 1; i++) {
            // 初始化最小距离
            int minDist = Integer.MAX_VALUE;
            // 初始化最小距离的节点
            int minIndex = -1;

            // 遍历所有节点，找到最小距离的节点
            for (int j = 0; j < n; j++) {
                // 如果节点未被访问，且距离小于最小距离
                if (!visited[j] && dist[j] < minDist) {
                    // 将当前节点设置为最小距离的节点
                    minDist = dist[j];
                    minIndex = j;
                }
            }

            // 将最小距离的节点标记为已访问
            visited[minIndex] = true;

            // 遍历所有节点，如果节点未被访问，且节点与最小距离的节点有边，且距离小于当前距离数组中的距离，则更新距离数组
            for (int j = 0; j < n; j++) {
                if (!visited[j] && graph[minIndex][j] != 0 && dist[minIndex] != Integer.MAX_VALUE
                        && dist[minIndex] + graph[minIndex][j] < dist[j]) {
                    // 更新距离数组
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


