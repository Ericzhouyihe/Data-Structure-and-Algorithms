package LeetCode.链表;

/**
 * 给定单链表,要求返回反转的链表
 */
public class t206 {
    
    /**
     * 迭代的方法
     *
     * @param head
     * @return 反转的单链表
     */
    public static ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    /**
     * 递归的方法
     *
     * @param head
     * @return 反转的单链表
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    
    // 根据数组创建单链表
    public static ListNode cre(int[] nums) {
        ListNode nodeSta = new ListNode(nums[0]);    // 创建首节点
        ListNode nextNode;                     // 声明一个变量用来在移动过程中指向当前节点
        nextNode = nodeSta;                    // 指向首节点
        
        // 创建链表
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);  // 生成新的节点
            nextNode.next = node;               // 把新节点连起来
            nextNode = nextNode.next;           // 当前节点往后移动
        } // 当for循环完成之后 nextNode指向最后一个节点，
        
        return nodeSta;
    }
    
    // 打印某节点之后就的全部结点
    public static void print(ListNode listNode) {
        // 创建链表节点
        while (listNode != null) {
            System.out.println("节点:" + listNode.val);
            listNode = listNode.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // 链表的顺序和数据
        int[] nums = new int[]{1, 2, 3, 4, 5};
        // 创建相应的链表
        ListNode head = cre(nums);
        // 打印反转的链表
        print(reverseList1(head));
        print(reverseList2(head));
    }
    
    // 递归的方式
    // 以链表1->2->3->4->5举例
    public ListNode reverseList(ListNode head) {
        /**
         * 直到当前节点的下一个节点为空时返回当前节点
         * 由于5没有下一个节点了，所以此处返回节点5
         */
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);/**
         * 第一轮出栈，head为5，head.next为空，返回5
         * 第二轮出栈，head为4，head.next为5，执行head.next.next=head也就是5.next=4，
         *           把当前节点的子节点的子节点指向当前节点
         *           此时链表为1->2->3->4<->5，由于4与5互相指向，所以此处要断开4.next=null
         *           此时链表为1->2->3->4<-5
         *           返回节点5
         * 第三轮出栈，head为3，head.next为4，执行head.next.next=head也就是4.next=3，
         *           此时链表为1->2->3<->4<-5，由于3与4互相指向，所以此处要断开3.next=null
         *           此时链表为1->2->3<-4<-5
         *           返回节点5
         * 第四轮出栈，head为2，head.next为3，执行head.next.next=head也就是3.next=2，
         *           此时链表为1->2<->3<-4<-5，由于2与3互相指向，所以此处要断开2.next=null
         *           此时链表为1->2<-3<-4<-5
         *           返回节点5
         * 第五轮出栈，head为1，head.next为2，执行head.next.next=head也就是2.next=1，
         *           此时链表为1<->2<-3<-4<-5，由于1与2互相指向，所以此处要断开1.next=null
         *           此时链表为1<-2<-3<-4<-5
         *           返回节点5
         * 出栈完成，最终头节点5->4->3->2->1
         */
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    
    // 双指针进行迭代
    public ListNode reverseList3(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
    
    static class ListNode {
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
