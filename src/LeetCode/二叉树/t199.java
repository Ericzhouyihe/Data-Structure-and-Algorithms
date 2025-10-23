package LeetCode.二叉树;

import java.util.*;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2025/1/12 22:27
 * @description
 */
public class t199 {
    /**
     * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     *
     * 示例 1：
     * 输入：root = [1,2,3,null,5,null,4]
     * 输出：[1,3,4]
     *
     * 示例 2：
     * 输入：root = [1,2,3,4,null,null,null,5]
     * 输出：[1,3,4,5]
     *
     * 示例 3：
     * 输入：root = [1,null,3]
     * 输出：[1,3]
     *
     * 示例 4：
     * 输入：root = []
     * 输出：[]
     */
    // 深度优先遍历
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 二叉树的最大深度
        int max_depth = -1;
        
        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> depthStack = new LinkedList<>();
        nodeStack.push(root);
        depthStack.push(0);
        
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();
            
            if (node != null) {
                // 更新最大深度
                max_depth = Math.max(max_depth, depth);
                
                // 如果不存在对应深度的节点,就进行插入
                if (!map.containsKey(depth)) {
                    map.put(depth, node.val);
                }
                
                nodeStack.push(root.left);
                nodeStack.push(root.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }
        
        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(map.get(depth));
        }
        
        return rightView;
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
