package removeNthNodeFromEndOfList;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next != null){
            removeNthFromEnd(head.next,n);
        }
        if(n == 1){
            head.next = head.next.next;
        }else{
            n--;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        solution.removeNthFromEnd(node1,3);
    }

}
