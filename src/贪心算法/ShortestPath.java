package 贪心算法;

import java.util.Arrays;

/**
 * 最短路径算法
 */
public class ShortestPath {
    public static int[] shortestPath(int[][] graph, int start) {
        // 定义图的节点数
        int n = graph.length;
        // 定义最短路径数组
        int[] path = new int[n];
        // 定义访问标记数组
        boolean[] visited = new boolean[n];
        // 将最短路径数组中的值设置为最大值
        Arrays.fill(path, Integer.MAX_VALUE);
        // 将起点路径设置为0
        path[start] = 0;
        // 遍历图中的每一个节点
        for (int i = 0; i < n; i++) {
            // 定义一个变量，用来存储最短路径的节点
            int u = -1;
            // 遍历每一个节点
            for (int j = 0; j < n; j++) {
                // 如果该节点未被访问，且路径小于当前最短路径，则更新最短路径节点
                if (!visited[j] && (u == -1 || path[j] < path[u])) {
                    u = j;
                }
            }
            // 将当前节点标记为已访问
            visited[u] = true;
            // 遍历每一个节点
            for (int v = 0; v < n; v++) {
                // 如果两个节点之间有边，且当前节点路径加上边权小于最短路径，则更新最短路径
                if (graph[u][v] != 0 && path[u] + graph[u][v] < path[v]) {
                    path[v] = path[u] + graph[u][v];
                }
            }
        }
        // 返回最短路径数组
        return path;
    }

    public static void main(String[] args) {
        // 定义图
        int[][] graph = {
                {0, 1, 3, 0, 0},
                {1, 0, 2, 5, 1},
                {3, 2, 0, 7, 0},
                {0, 5, 7, 0, 2},
                {0, 1, 0, 2, 0},
        };
        // 调用最短路径函数，获取起点到其他节点的最短路径
        int[] path = shortestPath(graph, 0);
        // 打印最短路径数组
        System.out.println(Arrays.toString(path));
    }
}

