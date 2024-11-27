package LeetCode.链表;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/27 16:36
 * @description
 */
public class t148 {
    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     * 示例 1：
     * 输入：head = [4,2,1,3]
     * 输出：[1,2,3,4]
     * 示例 2：
     * 输入：head = [-1,5,3,4,0]
     * 输出：[-1,0,3,4,5]
     * 示例 3：
     * 输入：head = []
     * 输出：[]
     */
    // 暴力解法,转换成数组排序完之后再转换成链表
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        list.sort(Integer::compareTo);
        ListNode pre = new ListNode(0);
        ListNode temp = pre;
        for (int i : list) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return pre.next;
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
