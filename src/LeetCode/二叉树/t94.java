package LeetCode.二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/30 22:27
 * @description
 */
public class t94 {
    // 迭代
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
    
    // 官方解法递归,果然简洁明了
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }
    
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
    
    // 自己想用递归没写出来
    // List<Integer> res = new ArrayList<>();
    //
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     if(root == null){
    //         return res;
    //     }
    //     left(root);
    //     right(root);
    //     return res;
    // }
    //
    // public TreeNode left(TreeNode node) {
    //     if(node.left == null){
    //         return node;
    //     }
    //     TreeNode left = left(node.left);
    //     res.add(left.val);
    //     if (node.right != null){
    //         right(node.right);
    //     }
    //     return node;
    // }
    //
    // public void right(TreeNode node) {
    //     if(node.left != null){
    //         left(node.left);
    //     }
    //     res.add(node.val);
    //     if (node.right != null) {
    //         right(node.right);
    //     }
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

