package LeetCode.矩阵;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/23 23:06
 * @description
 */
public class t73 {
    /**
     * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     */
    
    // 使用两个标记变量
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRow = false, firstCol = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0){
                firstCol = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0){
                firstRow = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstRow) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
    
    // 使用标记数组
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    // 使用set的暴力法,运行比较慢
    public void setZeroes1(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> rols = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    rows.add(i);
                    rols.add(j);
                }
            }
        }
        for (int row : rows) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[row][j] = 0;
            }
        }
        for (int col : rols) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}
