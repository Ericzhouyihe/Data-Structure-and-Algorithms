package LeetCode.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/11 23:18
 * @description
 */
public class t101 {
    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     * 示例 1：
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * 示例 2：
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     */
    // 迭代法
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }
    
    public boolean check(TreeNode leftNode,TreeNode rightNode) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(leftNode);
        q.offer(rightNode);
        while (!q.isEmpty()) {
            leftNode = q.poll();
            rightNode = q.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if ((leftNode == null || rightNode == null) || (leftNode.val != rightNode.val)){
                return false;
            }
            
            q.offer(leftNode.left);
            q.offer(rightNode.right);
            q.offer(leftNode.right);
            q.offer(rightNode.left);
        }
        return true;
    }
    // 递归法
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }
    
    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val) && isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
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
