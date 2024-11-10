package LeetCode.链表;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/10 10:11
 * @description
 */
public class t19_2 {
    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = new ListNode(0,head);
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if(slow.next == head){
            head = head.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    
    public class ListNode {
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
