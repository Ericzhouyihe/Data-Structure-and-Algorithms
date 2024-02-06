package LeetCode.链表;

public class t21 {

    //方式一:递归
    public static ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs1(newHead.next);
        newHead.next = head;
        return newHead;
    }

    //方式二:迭代
    public static ListNode swapPairs2(ListNode head) {
        ListNode dummyHead = new ListNode(0,head);
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        //链表的顺序和数据
        int[] nums = new int[]{1,2,3,4};
        //创建相应的链表
        ListNode head = cre(nums);
        print(swapPairs2(head));
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
