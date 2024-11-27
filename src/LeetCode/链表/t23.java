package LeetCode.链表;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/27 16:45
 * @description
 */
public class t23 {
    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * 示例 1：
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 示例 2：
     * 输入：lists = []
     * 输出：[]
     * 示例 3：
     * 输入：lists = [[]]
     * 输出：[]
     */
    // 纯暴力.模拟一步步迭代
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        ListNode pre = new ListNode(0);
        ListNode node = pre;
        int indexMin = 0;
        while (indexMin != -1) {
            int currMin = Integer.MAX_VALUE;
            indexMin = -1;
            for (int i = 0; i < len; i++) {
                if (lists[i] != null && lists[i].val < currMin) {
                    currMin = lists[i].val;
                    indexMin = i;
                }
            }
            if(indexMin != -1){
                node.next = new ListNode(lists[indexMin].val, null);
                lists[indexMin] = lists[indexMin].next;
                node = node.next;
            }
            
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
