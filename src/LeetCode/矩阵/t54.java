package LeetCode.矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/23 23:44
 * @description
 */
public class t54 {
    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，
     * 请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     */
    
    //
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int col = left; col <= right; col++) {
                res.add(matrix[top][col]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int col = right - 1; col >= left; col--) {
                    res.add(matrix[bottom][col]);
                }
                for (int row = bottom - 1; row > top; row--) {
                    res.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
    
    
    // 创建一个波尔类型的数组记录索引位置的数据,是否被使用孤傲
    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (null == matrix || 0 == matrix.length || matrix[0].length == 0) {
            return res;
        }
        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int row = 0, col = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // 表示上下左右移动时,索引变化
        int directionIndex = 0;
        for (int i = 0; i < rows * cols; i++) {
            res.add(matrix[row][col]);
            visited[row][col] = true;
            int newRow = row + directions[directionIndex][0], newCol = col + directions[directionIndex][1];
            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || visited[newRow][newCol]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
            
        }
        return res;
    }
}
