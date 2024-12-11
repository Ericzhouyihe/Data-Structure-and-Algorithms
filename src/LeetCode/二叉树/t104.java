package LeetCode.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/3 23:01
 * @description
 */
public class t104 {
    
    // 广度优先遍历
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            ans++;
        }
        return ans;
    }
    
    // 递归进行左右的分支的最大对比 -- 深度优先搜索
    // public int maxDepth(TreeNode root) {
    //     if (root == null) return 0;
    //
    //     int left = maxDepth(root.left);
    //     int right = maxDepth(root.right);
    //     return Math.max(left, right) + 1;
    // }
    
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
