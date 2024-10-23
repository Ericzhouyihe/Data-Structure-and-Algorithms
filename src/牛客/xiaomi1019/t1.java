package 牛客.xiaomi1019;

import java.util.Scanner;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/19 16:43
 * @description
 */
public class t1 {
    /**
     * 数独计数
     * 要求:
     * 第一行数据表示有n组数独的数据,后面的都是每组的数据,其中为0的部分为还没有填的数
     * 输出每组的解法个数
     *
     * 输入实例:
     * 2
     * 1 8 5
     * 4 6 3
     * 0 2 0
     * 1 3 5
     * 4 6 8
     * 2 7 0
     *
     * 输出实例:
     * 2
     * 1
     */
    
    private static final int SIZE = 3; // 数独的大小
    private static int solutionCount = 0; // 解的数量
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 读取测试组数
        scanner.nextLine(); // 读取剩余的换行符
        
        for (int i = 0; i < n; i++) {
            int[][] board = new int[SIZE][SIZE];
            
            // 读取数独数据
            for (int row = 0; row < SIZE; row++) {
                String line = scanner.nextLine();
                String[] values = line.trim().split(" ");
                for (int col = 0; col < SIZE; col++) {
                    board[row][col] = Integer.parseInt(values[col]);
                }
            }
            
            solutionCount = 0; // 重置解数
            solveSudoku(board);
            System.out.println("解法数: " + solutionCount);
        }
        scanner.close();
    }
    
    private static void solveSudoku(int[][] board) {
        backtrack(board);
    }
    
    private static void backtrack(int[][] board) {
        int row = -1;
        int col = -1;
        boolean isFull = true;
        
        // 寻找下一个空位置
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isFull = false; // 发现空位置
                    break;
                }
            }
            if (!isFull) {
                break;
            }
        }
        
        // 如果没有空位置，则说明找到一个解
        if (isFull) {
            solutionCount++;
            return;
        }
        
        // 尝试 1 到 3 的数字
        for (int num = 1; num <= SIZE; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num; // 填入数字
                backtrack(board); // 递归
                board[row][col] = 0; // 回溯
            }
        }
    }
    
    private static boolean isValid(int[][] board, int row, int col, int num) {
        // 检查行
        for (int j = 0; j < SIZE; j++) {
            if (board[row][j] == num) {
                return false;
            }
        }
        
        // 检查列
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        
        // 检查子网格（对于 3x3 数独，子网格就是整个格子）
        return true;
    }
}
