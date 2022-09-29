package easy.linkedList;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 *
 * Example 1:
 * Input: head = [1,1,2]
 * Output: [1,2]
 *
 * Constraints:
 *
 *     The number of nodes in the list is in the range [0, 300].
 *     -100 <= Node.val <= 100
 *     The list is guaranteed to be sorted in ascending order.
 *
 * Time Complexity O(n)
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode previous = head;
        while (current != null) {
            if (current.val == previous.val) {
                previous.next = current.next;
                current = current.next;
            } else {
                previous = current;
                current = current.next;
            }
        }
        return head;
    }
}

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
