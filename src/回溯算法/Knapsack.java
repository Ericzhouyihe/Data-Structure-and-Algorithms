package 回溯算法;

public class Knapsack {
    static int maxW = Integer.MIN_VALUE; // 存储背包中物品总重量的最大值
    static int[] weight = {2, 2, 6, 5, 4}; // 物品重量
    static int[] value = {6, 3, 5, 4, 6}; // 物品价值
    static int n = 5; // 物品个数
    static int w = 10; // 背包承受的最大重量

    static int[] bestx = new int[n + 1]; // 存储最优解
    static int[] cx = new int[n + 1]; // 存储当前解



    /**
     * 从根节点出发以深度优先的方式搜索空间树
     * @param i     考察到哪个物品了
     * @param cw    当前已经装进去的物品的重量和
     * @param cv    当前已经装进去的物品的价值和
     */
    public static void f(int i, int cw, int cv) {
        if (cw == w || i == n) { // cw==w 表示装满了，i==n 表示物品都考察完了
            if (cv > maxW) maxW = cv;
            return;
        }
        f(i + 1, cw, cv); // 选择不装第 i 个物品
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i], cv + value[i]); // 选择装第 i 个物品
        }
    }


    public static void main(String[] args) {
        f(0, 0, 0);
        System.out.println(maxW);
    }
}

