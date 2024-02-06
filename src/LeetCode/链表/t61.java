package LeetCode.链表;

public class t61 {

    public static ListNode removeNthFromEnd(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }


    //根据数组创建单链表
    public static ListNode cre(int[] nums){
        ListNode nodeSta = new ListNode(nums[0]);    //创建首节点
        ListNode nextNode;                     //声明一个变量用来在移动过程中指向当前节点
        nextNode = nodeSta;                    //指向首节点

        //创建链表
        for(int i=1;i < nums.length;i++){
            ListNode node = new ListNode(nums[i]);  //生成新的节点
            nextNode.next = node;               //把新节点连起来
            nextNode = nextNode.next;           //当前节点往后移动
        } //当for循环完成之后 nextNode指向最后一个节点，

        return nodeSta;
    }

    //打印某节点之后就的全部结点
    public static void print(ListNode listNode){
        //创建链表节点
        while(listNode != null){
            System.out.println("节点:" + listNode.val);
            listNode = listNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //链表的顺序和数据
        int[] nums = new int[]{1,2,3,4,5};
        //创建相应的链表
        ListNode head = cre(nums);
        print(removeNthFromEnd(head,2));

        System.out.println();

        int[] nums1 = new int[]{0,1,2};
        //创建相应的链表
        ListNode head1 = cre(nums1);
        print(removeNthFromEnd(head1,4));


    }


    static  class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
