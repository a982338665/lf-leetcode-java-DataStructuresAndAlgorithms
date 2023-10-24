package pers.li.zk;

import java.util.List;
import java.util.Stack;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2022/11/1 14:11
 * @Description :
 * 链表翻转
 */
public class $3ListConvert {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(5,
                new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(3,
                        new ListNode(4, new ListNode(5, new ListNode(1))))))));
//        ListNode listNode1 = new $3ListConvert().reverseList(listNode);
        ListNode listNode1 = new $3ListConvert().reverseList2(listNode,6);
        System.err.println(listNode1.toString2());
    }

    /**
     * 迭代法
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 翻转链表的前k个元素
     * @param head
     * @param k
     * @return
     * -----------------------------------
     * 1:
     * curr(5,4)
     * next(4,3)
     * curr(5,3)    ====
     * next(4,5)    ====
     * prev(-1,4)   ==== 4,5,3
     * 2:
     * curr(5,3)
     * next(3,2)
     * curr(5,2)    ====
     * next(3,4)    ====
     * prev(-1 3)   ==== 3,4,5
     * 3：
     * curr(5,2)
     * next(2,3)
     * curr(5,3)    ====
     * next(2,3)    ====
     * prev(-1 2)   ==== 2,3,4,5
     */
    public ListNode reverseList2(ListNode head,int k) {
        ListNode dummy = new ListNode(-1,head);
        ListNode prev = dummy;
        ListNode curr = prev.next;
        for (int i = 0; i < k-1; i++) {
            System.err.println("------------------"+i);
            System.err.println("1-curr-="+curr.val);
            System.err.println("2-curr-=curr-="+ curr.next.val);
            ListNode next = curr.next;
            System.err.println("3-next-="+next.val);
            System.err.println("4-next-=next-="+ next.next.val);
            curr.next = next.next;
            System.err.println("5-curr.next-="+curr.val);
            System.err.println("6-curr.next-=curr.next-="+ curr.next.val);
            next.next = prev.next;
            System.err.println("7-next.next-="+next.val);
            System.err.println("8-next.next-=next.next-="+ next.next.val);
            prev.next = next;
            System.err.println("9-prev.next-="+prev.val);
            System.err.println("10-prev.next-=prev.next-="+ prev.next.val);
        }
//        prev = curr;
        return dummy.next;
    }

    /**
     * 栈的特性
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        ListNode listNode = head;
        //压栈
        Stack<ListNode> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }
        if (stack.isEmpty()) {
            return null;

        }
        //出栈
        ListNode header = stack.pop();
        ListNode curr = header;
        while (!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
        }
        curr.next= null;
        return header;
    }

    public ListNode zu(int[] test) {
        ListNode last = new ListNode(test[test.length - 1]);

        for (int i = test.length - 2; i >= 0; i--) {
            last = new ListNode(test[i], last);
        }
        return last;
    }
//    public int[] chai(ListNode node) {
//        StringBuilder sv= new StringBuilder();
//        sv.append(val);
//        while (next!=null){
//            sv.append(",");
//            sv.append(next.val);
//            next = next.next;
//        }
//        return sv.toString();
//    }


}
