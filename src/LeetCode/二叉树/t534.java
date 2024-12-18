package LeetCode.二叉树;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/15 22:23
 * @description
 */
public class t534 {
    /**
     * 给你一棵二叉树的根节点，返回该树的 直径 。
     * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
     * 两节点之间路径的 长度 由它们之间边数表示。
     * 示例 1：
     * 输入：root = [1,2,3,4,5]
     * 输出：3
     * 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
     * 示例 2：
     * 输入：root = [1,2]
     * 输出：1
     */
    // 实际上还是通过最大深度求解,只不过每个节点下的左右子树都需要考虑,而不能只考虑根节点的左右子树的
    // 需要使用递归的时候记录最大的直径的值
    int res;
    
    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        depth(root);
        return res - 1;
    }
    
    public int depth(TreeNode root) {
        if (root == null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        res = Math.max(res, left + right + 1);
        return Math.max(left, right) + 1;  // 记录左右子树中深度更大的那个 + 1(root)
    }
    // 自己尝试用左右两边的最大深度写的,未考虑全在一边的情况
    // public int diameterOfBinaryTree(TreeNode root) {
    //     int leftMaxLenth = maxDepth(root.left);
    //     int rightMaxLenth = maxDepth(root.right);
    //     return leftMaxLenth + rightMaxLenth;
    // }
    //
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
