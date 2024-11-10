package LeetCode.链表;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/9 23:12
 * @description
 */
public class t2 {
    /***
     * 两数相加
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     */
    
    // 暴力法也叫模拟,这里是刚刚的代码优化后的样子
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
    
    // 暴力法, 一步一步相加
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode(0);
        ListNode pre = new ListNode(0, head);
        int curr = 0;
        pre = pre.next;
        while (p1 != null || p2 != null) {
            int currValue1 = 0;
            int currValue2 = 0;
            if (p1 != null) {
                currValue1 = p1.val;
            }
            if (p2 != null) {
                currValue2 = p2.val;
            }
            if (currValue1 + currValue2 + curr >= 10) {
                pre.val = currValue1 + currValue2 + curr - 10;
                curr = 1;
            } else {
                pre.val = currValue1 + currValue2 + curr;
                curr = 0;
            }
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
            if(p1 != null || p2 != null) {
                pre.next = new ListNode();
                pre = pre.next;
            }
        }
        if(curr == 1){
            pre.next = new ListNode(1);
        }
        return head;
    }
    
    // 结点类
    class ListNode {
        int val;
        ListNode next;
        
        ListNode() {
        }
        
        ListNode(int x) {
            val = x;
            next = null;
        }
        
        ListNode(int x, ListNode next) {
            val = x;
            next = next;
        }
    }
}
