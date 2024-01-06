package 回溯算法;

import java.util.Arrays;

/**
 * m图的着色问题
 * 回溯法
 */
public class GraphColoring {
   public static int[] graphColoring(int[][] graph, int m) {
        // 获取图的节点数
        int n = graph.length;
        // 初始化颜色数组
        int[] colors = new int[n];
        // 全部初始化为0
        Arrays.fill(colors, 0);
        // 调用graphColoringUtil函数，传入图、颜色数组、节点数、0
        if (graphColoringUtil(graph, m, colors, 0)) {
            // 如果返回true，则返回颜色数组
            return colors;
        } else {
            // 如果返回false，则返回一个空数组
            return new int[0];
        }
    }

    public static boolean graphColoringUtil(int[][] graph, int m, int[] colors, int v) {
        // 获取图的节点数
        int n = graph.length;
        // 如果节点数等于颜色数组的长度，则返回true
        if (v == n) {
            return true;
        }
        // 遍历颜色数组，从1开始，到m结束
        for (int c = 1; c <= m; c++) {
            // 调用isSafe函数，传入图、颜色数组、节点数、颜色
            if (isSafe(graph, colors, v, c)) {
                // 如果返回true，则将颜色数组中对应节点赋值为c
                colors[v] = c;
                // 调用graphColoringUtil函数，传入图、颜色数组、节点数、节点数+1
                if (graphColoringUtil(graph, m, colors, v + 1)) {
                    // 如果返回true，则返回true
                    return true;
                }
                // 如果返回false，则将颜色数组中对应节点赋值为0
                colors[v] = 0;
            }
        }
        // 如果遍历完颜色数组，没有返回true，则返回false
        return false;
    }

    public static boolean isSafe(int[][] graph, int[] colors, int v, int c) {
        // 获取图的节点数
        int n = graph.length;
        // 遍历图的每一行
        for (int i = 0; i < n; i++) {
            // 如果图的v行和i列有边，且颜色数组中对应节点赋值为c，则返回false
            if (graph[v][i] == 1 && colors[i] == c) {
                return false;
            }
        }
        // 否则返回true
        return true;
    }

    //main方法
    public static void main(String[] args) {
        //初始化图
        int[][] graph = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0}
        };
        //颜色数量
        int m = 3;
        //调用graphColoring方法
        int[] colors = graphColoring(graph, m);
        System.out.println(Arrays.toString(colors));
    }

}

