package LeetCode.链表;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/3 10:08
 * @description
 */
public class t142 {
    /**
     * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     *
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
     * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。
     * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     *
     * 不允许修改 链表。
     * 示例 1：
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：返回索引为 1 的链表节点
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * 示例 2：
     * 输入：head = [1,2], pos = 0
     * 输出：返回索引为 0 的链表节点
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     * 示例 3：
     * 输入：head = [1], pos = -1
     * 输出：返回 null
     * 解释：链表中没有环。
     */
    // 快慢指针
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        // 快慢指针都从头结点出发,快指针每次都是走2步,慢指针走一步,则快指针路程是慢指针的两倍
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
            slow =slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            }else {
                return null;
            }
            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
    
    // 使用set集合
    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
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
