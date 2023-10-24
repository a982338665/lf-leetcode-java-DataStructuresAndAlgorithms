package pers.li.zk;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2022/11/1 14:11
 * @Description :
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换
 */
public class $5ListConvertK {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(5,
                new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(3,
                        new ListNode(4, new ListNode(5, new ListNode(1))))))));
        ListNode listNode1 = reverseKGroup2(listNode, 3);
        System.err.println(listNode1.toString2());
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        int count = 0;
        while (true) {
            count++;
            // 检查剩余节点是否有k个，不足则返回
            System.err.println("第" + count + "次检查剩余节点个数：==============");
            ListNode last = prev;
            for (int i = 0; i < k; i++) {
                last = last.next;
                if (last == null) {
                    return dummy.next;
                }
            }
            System.err.println("第" + count + "次翻转节点：==============");
            // 翻转k个节点
            ListNode curr = prev.next;
            for (int i = 0; i < k - 1; i++) {
                ListNode next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = curr;
//            System.err.println("prev2->"+prev);
        }
    }

    public static ListNode reverseKGroup2(ListNode head, int k) {
        System.err.println("head:" + head);
        ListNode dummy = new ListNode(-1, head);
        System.err.println("dummy:" + dummy);
        ListNode prev = dummy;
        System.err.println("prev:" + prev);
        int count = 0;
        while (true) {
            count++;
            // 检查剩余节点是否有k个，不足则返回
            System.err.println("第" + count + "次检查剩余节点个数：==============");
            ListNode last = prev;
            System.err.println("LAST:" + last);
            for (int i = 0; i < k; i++) {
                last = last.next;
                if (last == null) {
                    return dummy.next;
                }
            }
            System.err.println("第" + count + "次翻转节点：==============");
            // 翻转k个节点
            ListNode curr = prev.next;
            System.err.println("CURR:=======" + curr);
            for (int i = 0; i < k - 1; i++) {
                ListNode next = curr.next;
                System.err.println("next0->" + next);
                curr.next = next.next;
                System.err.println("curr->" + curr);
                next.next = prev.next;
                System.err.println("next1->" + next);
                prev.next = next;
                System.err.println("prev->" + prev);
            }
            prev = curr;
            System.err.println("prev2->" + prev);
        }
    }


    /**
     * 翻转
     *
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


}
