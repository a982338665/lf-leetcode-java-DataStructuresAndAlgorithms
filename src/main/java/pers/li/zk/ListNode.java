package pers.li.zk;

/**
 * 链表
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toString2() {
        StringBuffer sv= new StringBuffer();
        sv.append(val);
        while (next!=null){
            sv.append(",");
            sv.append(next.val);
            next = next.next;
        }
        return sv.toString();
    }

    public static ListNode zu(int[] test) {
        ListNode last = new ListNode(test[test.length - 1]);

        for (int i = test.length - 2; i >= 0; i--) {
            last = new ListNode(test[i], last);
        }
        return last;
    }
}
