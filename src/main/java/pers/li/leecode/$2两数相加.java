package pers.li.leecode;

import pers.li.zk.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2022/11/2 10:29
 * @Description :
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class $2两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a1 = l1;
        ListNode a2 = l2;
        int count = 0;
        ListNode head = null;
        ListNode finals = null;
        int jinwei = 0;
        //两个链表可能长度不同
        while (a1 != null || a2 != null) {
            if (a1 == null) {
                a1 = new ListNode(0);
            }
            if (a2 == null) {
                a2 = new ListNode(0);
            }
            int total = a1.val + a2.val + jinwei;
            jinwei = total / 10;
            int yushu = total % 10;
            if (count == 0) {
                head = new ListNode(yushu);
                finals = head;
            } else {
                head.next = new ListNode(yushu);
                head = head.next;
            }
            count++;
            //处理最后一位
            if (a1.next == null && a2.next == null && jinwei != 0) {
                head.next = new ListNode(jinwei);
                head = head.next;
            }
            a1 = a1.next;
            a2 = a2.next;
        }
        return finals;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.zu(new int[]{9, 9, 9, 9, 9, 9, 9,9,1});
        ListNode l2 = ListNode.zu(new int[]{9, 9, 9, 9});
        ListNode listNode = new $2两数相加().addTwoNumbers(l1, l2);
        System.err.println(listNode.toString2());
    }
}
