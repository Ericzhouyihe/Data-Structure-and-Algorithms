package 分支限界法;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 0-1背包问题
 * 分支限界法
 */
public class Knapsack {
    static class Node {
        int level;
        int profit;
        int weight;
        double bound;

        public Node(int level, int profit, int weight) {
            this.level = level;
            this.profit = profit;
            this.weight = weight;
        }
    }

    public static int knapsack(int[] weights, int[] profits, int capacity) {
        int n = weights.length;
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingDouble(o -> -o.bound));
        Node u = new Node(-1, 0, 0);
        Node v = new Node(0, 0, 0);
        int maxProfit = 0;
        v.bound = bound(v, weights, profits, capacity, n);
        queue.offer(v);
        while (!queue.isEmpty()) {
            v = queue.poll();
            if (v.bound > maxProfit) {
                u.level = v.level + 1;
                u.weight = v.weight + weights[u.level];
                u.profit = v.profit + profits[u.level];
                if (u.weight <= capacity && u.profit > maxProfit) {
                    maxProfit = u.profit;
                }
                u.bound = bound(u, weights, profits, capacity, n);
                if (u.bound > maxProfit) {
                    queue.offer(u);
                }
                u = new Node(u.level, v.profit, v.weight);
                u.bound = bound(u, weights, profits, capacity, n);
                if (u.bound > maxProfit) {
                    queue.offer(u);
                }
            }
        }
        return maxProfit;
    }

    private static double bound(Node u, int[] weights, int[] profits, int capacity, int n) {
        if (u.weight >= capacity) {
            return 0;
        }
        double bound = u.profit;
        int j = u.level + 1;
        int totWeight = u.weight;
        while (j < n && totWeight + weights[j] <= capacity) {
            totWeight += weights[j];
            bound += profits[j];
            j++;
        }
        if (j < n) {
            bound += (capacity - totWeight) * profits[j] / (double) weights[j];
        }
        return bound;
    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] profits = {60, 100, 120};
        int capacity = 50;
        System.out.println("最大价值: " + knapsack(weights, profits, capacity));
    }
}

