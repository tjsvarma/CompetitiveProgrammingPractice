package easy.linkedList;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Constraints:
 *
 *     The number of nodes in the list is the range [0, 5000].
 *     -5000 <= Node.val <= 5000
 *
 * Time Complexity O(n)
 */

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode previous = head;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            if (previous == current) {
                previous.next = null;
            } else {
                current.next = previous;
            }
            previous = current;
            current = temp;
        }
        head = previous;
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