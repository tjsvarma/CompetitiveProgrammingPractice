package easy;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 * Example 1:
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Constraints:
 *
 *     The number of nodes in both lists is in the range [0, 50].
 *     -100 <= Node.val <= 100
 *     Both list1 and list2 are sorted in non-decreasing order.
 *
 * Time Complexity O(n)
 */

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        if (list1 == null) return list2;
        else if (list2 == null) return list1;
        else {
            if (list1.val >= list2.val) {
                head = list2;
                list2 = list2.next;
            }
            else {
                head = list1;
                list1 = list1.next;
            }
            ListNode temp = head;
            while (list1 != null && list2 != null) {
                if (list1.val >= list2.val) {
                    temp.next = list2;
                    temp = temp.next;
                    list2 = list2.next;
                } else {
                    temp.next = list1;
                    temp = temp.next;
                    list1 = list1.next;
                }
            }
            if (list1 != null) {
                temp.next = list1;
            }
            if (list2 != null) {
                temp.next = list2;
            }
        }
        return head;
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}