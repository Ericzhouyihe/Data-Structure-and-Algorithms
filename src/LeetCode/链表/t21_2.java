package LeetCode.链表;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/3 10:57
 * @description
 */
public class t21_2 {
    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 示例 1：
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * <p>
     * 示例 2：
     * 输入：l1 = [], l2 = []
     * 输出：[]
     * <p>
     * 示例 3：
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     */
    // 递归的方法
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
    
    // 暴力法,直接拼接出链表 (也就是迭代的方法)
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
    
    // 转换成数组 然后排序 再转成链表  --两边转换效率比较低,时间复杂度和空间复杂度都高
    public ListNode mergeTwoListsdemo(ListNode list1, ListNode list2) {
        List<Integer> list = new ArrayList<Integer>();
        while (list1 != null) {
            list.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            list.add(list2.val);
            list2 = list2.next;
        }
        list.sort(Integer::compareTo);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int val : list) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return dummy.next;
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
