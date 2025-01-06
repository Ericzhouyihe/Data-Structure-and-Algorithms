package LeetCode.二叉树;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2025/1/5 23:17
 * @description
 */
public class t230 {
    /**
     * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
     *
     * 示例 1：
     * 输入：root = [3,1,4,null,2], k = 1
     * 输出：1
     *
     * 示例 2：
     * 输入：root = [5,3,6,2,4,null,null,1], k = 3
     * 输出：3
     */
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            // 一左到底
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 弹出一个
            root = stack.pop();
            k--;
            if (k == 0) {
                break;
            }
            // 右节点
            root = root.right;
        }
        return root.val;
    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {
        }
        
        TreeNode(int val) {
            this.val = val;
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
