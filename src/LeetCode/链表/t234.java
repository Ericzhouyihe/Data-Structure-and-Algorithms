package LeetCode.链表;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/31 21:40
 * @description
 */
public class t234 {
    
    /**
     * 给你一个单链表的头节点 head ，请你判断该链表是否为
     * 回文链表
     * 如果是，返回 true ；否则，返回 false 。
     */
    
    
    // 快慢指针
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        
        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
        
        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        
        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    
    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    
    
    // 将值复制到数组中后用双指针法
    public boolean isPalindrome1(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        
        // 使用双指针判断是否回文
        int front = 0;
        int back = list.size() - 1;
        while (front < back) {
            if (!list.get(front).equals(list.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
    
    // 结点类
    class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
