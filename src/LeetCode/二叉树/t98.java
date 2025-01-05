package LeetCode.二叉树;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2025/1/5 22:06
 * @description
 */
public class t98 {
    /**
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     *
     * 有效 二叉搜索树定义如下：
     * 节点的左
     * 子树
     * 只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     * 示例 1：
     * 输入：root = [2,1,3]
     * 输出：true
     *
     * 示例 2：
     * 输入：root = [5,1,4,null,null,3,6]
     * 输出：false
     * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    // 优化
    public boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        
        if (node.val <= min || node.val >= max) return false;
        
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
    
    // 自己写的时候用的
    public boolean isValidBST1(TreeNode node, long min, long max) {
        if (node == null) return true;
        
        if (node.val <= min || node.val >= max) return false;
        if (node.left != null) {
            boolean left = isValidBST(node.left, min, node.val);
            if (!left) return false;
        }
        if (node.right != null) {
            boolean right = isValidBST(node.right, node.val, max);
            if (!right) return false;
        }
        return true;
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
