package school.Test5;

public class BinaryTree {//二叉树类
    TreeNode root; // 根结点

    public BinaryTree() {
        root = null;
    }

    // 建立二叉树
    public void buildTree(int[] nums) {
        root = buildTreeHelper(nums, 0, nums.length - 1);
    }

    // 递归建立二叉树
    private TreeNode buildTreeHelper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTreeHelper(nums, left, mid - 1);
        node.right = buildTreeHelper(nums, mid + 1, right);
        return node;
    }

    // 前序遍历
    public void preOrderTraversal() {
        preOrderTraversalHelper(root);
        System.out.println();
    }

    // 递归前序遍历
    private void preOrderTraversalHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraversalHelper(root.left);
        preOrderTraversalHelper(root.right);
    }

    // 中序遍历
    public void inOrderTraversal() {
        inOrderTraversalHelper(root);
        System.out.println();
    }

    // 递归中序遍历
    private void inOrderTraversalHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversalHelper(root.left);
        System.out.print(root.val + " ");
        inOrderTraversalHelper(root.right);
    }

    // 后序遍历
    public void postOrderTraversal() {
        postOrderTraversalHelper(root);
        System.out.println();
    }

    // 递归后序遍历
    private void postOrderTraversalHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversalHelper(root.left);
        postOrderTraversalHelper(root.right);
        System.out.print(root.val + " ");
    }
}
