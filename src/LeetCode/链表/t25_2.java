package LeetCode.链表;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/12 20:22
 * @description
 */
public class t25_2 {
    /**
     * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     * <p>
     * 示例 1：
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[2,1,4,3,5]
     * <p>
     * 示例 2：
     * 输入：head = [1,2,3,4,5], k = 3
     * 输出：[3,2,1,4,5]
     */
    // 迭代
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++){
                tail = tail.next;
                if (tail == null){
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }
    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
    
    // 变成数组排序后再存入链表--超内存了了
    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode old = head;
        List<Integer> list = new ArrayList<>();
        while (old != null) {
            list.add(old.val);
        }
        Integer[] array = list.toArray(new Integer[list.size()]);
        for (int i = 0; i < list.size(); i += k) {
            swap(array, i, k);
        }
        ListNode newNode = head;
        for (Integer i : array) {
            newNode.val = i;
            newNode = newNode.next;
        }
        return head;
    }
    
    public void swap(Integer[] nums, int start, int k) {
        int end = Math.min(start + k - 1, nums.length - 1);
        for (int i = start; i < end; i++) {
            int temp = nums[i];
            nums[i] = nums[end];
            nums[end] = temp;
            end--;
        }
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
