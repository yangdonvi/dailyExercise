package com.donvi.letcode.链表;

public class No206反转链表 {

//    反转一个单链表。
//
//    示例:
//
//    输入: 1->2->3->4->5->NULL
//    输出: 5->4->3->2->1->NULL
//    进阶:
//    你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/reverse-linked-list
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
//    reverseList: head=1
//    reverseList: head=2
//    reverseList: head=3
//    reverseList: head=4
//    reverseList: head=5
//    终止返回
//            cur = 5
//				4.next.next->4，即5->4
//    cur=5
//            3.next.next->3，即4->3
//    cur = 5
//            2.next.next->2，即3->2
//    cur = 5
//            1.next.next->1，即2->1
//
//    最后返回cur

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;

    }


}
