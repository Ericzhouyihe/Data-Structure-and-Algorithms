package 回溯算法;

import java.util.Arrays;

public class NQueens {
    static int count = 0;

    // 遍历每一列
    private static void solveNQueens(int[] queens, int row, int n) {
        // 如果行数等于n，则表示已经找到一个解
        if (row == n) {
            // 计数器加1
            count++;
            // 打印解
            printSolution(queens);
            return;
        }
        // 遍历每一列
        for (int col = 0; col < n; col++) {
            // 如果当前列是有效的
            if (isValid(queens, row, col)) {
                // 将当前列赋值给queens[row]
                queens[row] = col;
                // 递归调用solveNQueens函数，行数加1
                solveNQueens(queens, row + 1, n);
                // 将queens[row]赋值为-1，表示当前列无效
                queens[row] = -1;
            }
        }
    }

    // 判断当前列是否有效
    private static boolean isValid(int[] queens, int row, int col) {
        // 遍历之前的行
        for (int i = 0; i < row; i++) {
            // 如果当前列和之前的列的值相等，或者当前行和之前的行的差值等于当前列和之前的列的差值，则表示当前位置不合法
            if (queens[i] == col || Math.abs(row - i) == Math.abs(col - queens[i])) {
                return false;
            }
        }
        return true;
    }
    private static void printSolution(int[] queens) {
        // 打印解
        System.out.println("Solution " + count + ":");
        // 遍历queens数组
        for (int i = 0; i < queens.length; i++) {
            for (int j = 0; j < queens.length; j++) {
                // 如果queens[i]等于j，则表示当前位置是皇后
                if (queens[i] == j) {
                    System.out.print("Q ");
                } else {
                    // 否则表示当前位置不是皇后
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        solveNQueens(queens, 0, n);
        System.out.println("There are " + count + " solutions for " + n + "-queens problem.");
    }
}
