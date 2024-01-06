package school.Test2;

public class Test2 {
    public static void main(String[] args) {
        //数据初始化
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        ListNode result = removeElements(head, 6);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

        System.out.println();
        ListNode head1 = null;
        ListNode result1 = removeElements(head1, 6);
        System.out.println(result1);
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {//判断是否为空链表
            return null;
        }

        ListNode prev = head;
        ListNode cur = head.next;

        while (cur != null) {
            //循环遍历
            if (cur.val == val) {//是val就跳转删除
                prev.next = cur.next;
                cur = cur.next;
            } else {//不是就找下一个
                prev = cur;
                cur = cur.next;
            }
        }
        //最后再查看一下头节点
        if (head.val == val) {
            head = head.next;
        }
        return head;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}