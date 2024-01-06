package 回溯算法;

import java.util.Scanner;

/**
 * 装载问题
 * 输入:物品的数量和重量;两个船的载重量
 * 输出:第一个船的最优情况,剩余是否能装入第二个船(是否有解)
 * 回溯法
 */
public class LoadingProblem {
    static final int NUM = 100;
    static int n; //集装箱数
    static int[] w = new int[NUM]; //集装箱重量数组
    static int[] bestX = new int[NUM];  //当前最优解
    static int[] x = new int[NUM]; //当前解
    static int bestW = 0; //当前最优载重量

    static int c1; //第一艘轮船的载重量
    static int c2; //第二艘轮船的载重量

    static int cw = 0; //当前放进轮船的集装箱重量

    //计算t层以后,还剩余的没进行判断的集装箱的总重
    private static int bound(int t) {
        //初始设置为0
        int rw = 0;
        for (int i = t + 1; i <= n; ++i) {
            rw += w[i];
        }
        //返回当前放入的总重+还没进行判断的集装箱的总重
        return rw + cw;
    }

    //回溯算法
    public static void loadingRec(int t) {
        //搜索第t层结点
        if (t > n) {//n是集装箱个数，搜索层数大于n，说明搜索到达叶结点
            if (cw > bestW) {
                bestW = cw;//得到最优装载重量
                //将当前解的路径赋给最优解
                for (int i = 1; i <= n; i++) {
                    bestX[i] = x[i];
                }
            }
            //到达叶子结点直接返回
            return;
        } else {//未达叶子结点
            //当前放进轮船的重量+现在判断是否要加入的重量<=轮船1的最大载重
            if (cw + w[t] <= c1) {//能放进就放
                cw += w[t];
                x[t] = 1; //当前步的解赋值为1
                loadingRec(t + 1); //判断下一层
                //设置为0,去查看右子树
                x[t] = 0;
                //改为右子树的当前放进轮船的集装箱重量
                cw -= w[t];
            }

            //当前放入的总重 + 还没进行判断的集装箱的总重 > 当前最优载重量
            if (bound(t) > bestW) {	//限界函数，当前重量加上剩余在岸上的重量大于最优载重量则说明有可能找到更优解

                x[t] = 0;
                //递归下一层
                loadingRec(t + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入集装箱的个数：");
        n = sc.nextInt();
        System.out.println("请输入集装箱的重量 (整数）：");
        for (int i = 1; i <= n; ++i) {
            w[i] = sc.nextInt();
        }
        sc.nextLine();
        System.out.print("请输入第一船的载重量：");
        c1 = sc.nextInt();
        sc.nextLine();
        System.out.print("请输入第二船的载重量：");
        c2 = sc.nextInt();
        loadingRec(1);
        System.out.println("第一船的最优重量为：" + bestW);
        System.out.println("第一船的最优解为：");
        for (int i = 1; i <= n; ++i) {
            if (bestX[i] == 1) {
                System.out.println("物品" + i + "装入第1个集装箱");
            }
        }
        int cw2 = 0;
        for (int i = 1; i <= n; ++i) {
            if (bestX[i] == 0) {
                cw2 += w[i];
            }
        }
        if (cw2 <= c2) {
            System.out.println("可以将剩余集装箱装入第二船，问题有解");
        } else {
            System.out.println("不能将剩余集装箱装入第二船，问题无解");
        }
        sc.close();
    }
}

