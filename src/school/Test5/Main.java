package school.Test5;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        BinaryTree tree = new BinaryTree();
        tree.buildTree(nums);
        System.out.print("前序遍历：");
        tree.preOrderTraversal();
        System.out.print("中序遍历：");
        tree.inOrderTraversal();
        System.out.print("后序遍历：");
        tree.postOrderTraversal();
    }
}
