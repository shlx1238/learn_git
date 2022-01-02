/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /**
     * 复杂度分析：考虑一般情况：list1与list2的长度分别为M和N
     * 对于本程序，采用了两个指针分别指向两个链表，并进行遍历
     * 当两个链表的最大值相同时，遍历的元素个数为(M+N)
     * 当两个链表的最大值不同时，遍历的元素个数小于（M+N)
     * 因此，本算法的时间复杂度应为 O(n)
     */


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 处理空链表
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode head, merge, i = list1, j = list2;

        // 初始化合并链表的第一个节点
        if (i.val <= j.val) {   
            merge = i;
            i = i.next;
        } else {
            merge = j;
            j = j.next;
        }

        head = merge;

        // 处理可以比较的部分
        while (i != null && j != null) {
            if (i.val <= j.val) {
                merge.next = i;
                i = i.next;
            } else {
                merge.next = j;
                j = j.next;
            }
            merge = merge.next;
        }

        // 处理无法比较的部分
        if (i != null) {
            merge.next = i;
        } else {
            merge.next = j;
        }

        return head;
    }
}