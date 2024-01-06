package 回溯算法;

import java.util.Scanner;

public class Knapsack1 {

    static int NUM = 100;
    static int n; //物品个数

    static int bestw = Integer.MIN_VALUE; // 存储最优解的总重
    static int cw = 0; // 存储当前解的总重
    static int cv = 0; // 存储当前解的总价值

    static int[] w = new int[NUM]; // 存储每个集装箱的重量;
    static int[] v = new int[NUM]; // 存储每个集装箱的价值;
    static int t = 0; // 当前已经选择的集装箱的数量;
    static int maxW = 0; // 背包的容量;

    static int[] bestX = new int[NUM]; // 存储最优解
    static int[] cx = new int[NUM]; // 存储当前解


    private static int bound(int t) {
        //初始设置为0
        int rw = 0;
        for (int i = t + 1; i <= n; ++i) {
            rw += w[i];
        }
        //
        return rw + cw;
    }
    /**
     *  递归搜索
     */
    public static void KnapsackRec(int t) {
        //搜索第t层的结点
        if(t > n){//n为物品总数
            if (cw > bestw){
                bestw = cw;
                for (int i = 1; i <= n; i++)
                    bestX[i] = cx[i];
                return;
            }else {
                if (cw + w[t] < maxW){
                    cx[t] = 1;
                    cw += w[t];
                    cv += v[t];
                    KnapsackRec(t+1);

                    //判断右子树
                    cx[t] = 0;
                    cw -= w[t];
                    cv -= v[t];
                }
                if (bound(t) > bestw){
                    cx[t] = 0;
                    //递归下一层
                    KnapsackRec(t+1);
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入物品的个数：");
        n = sc.nextInt();
        System.out.println("请输入物品的重量 (整数）：");
        for (int i = 1; i <= n; ++i) {
            w[i] = sc.nextInt();
        }
        System.out.println("请输入物品的价值(整数）：");
        for (int i = 1; i <= n; ++i) {
            w[i] = sc.nextInt();
        }
        sc.nextLine();
        for (int i = 1; i <= n; ++i) {
            if (bestX[i] == 1) {
                System.out.println("物品" + i + "装入背包");
            }
        }
        int cw2 = 0;
        int cv2 = 0;
        for (int i = 1; i <= n; ++i) {
            if (bestX[i] == 0) {
                cw2 += w[i];
                cv2 += v[i];
            }
        }
        sc.close();
        KnapsackRec(0);
        System.out.println("最大重量:"+cw2+",最大价值:"+cv2);
    }
}

