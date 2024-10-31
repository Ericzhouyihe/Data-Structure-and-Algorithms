package LeetCode.链表;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/10/31 19:56
 * @description
 */
public class t160 {
    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     * <p>
     * 图示两个链表在节点 c1 开始相交：
     * <p>
     * 题目数据 保证 整个链式结构中不存在环。
     * <p>
     * 注意，函数返回结果后，链表必须 保持其原始结构 。
     * <p>
     * 自定义评测：
     * <p>
     * 评测系统 的输入如下（你设计的程序 不适用 此输入）：
     * <p>
     * intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
     * listA - 第一个链表
     * listB - 第二个链表
     * skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
     * skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
     * 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。
     */
    // 双指针,利用两个指针的特性,两个链表假如有公共链(长度为c),则a链长度a + c,b链长度b + c,
    // 所以两个指针都一直往后next,指针a到null之后去到headB,b指针到null之后去到headA
    // 这样两个如果有相交位置的话,一定会在某一个位置相等 a走的长度为a + c + b  b走的长度为b + c + a
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
    
    // 哈希集合
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            temp = temp.next;
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
