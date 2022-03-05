package easy.linkedList;

/**
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 *
 * Example 1:
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 *
 * Constraints:
 *
 *     The number of nodes in the list is in the range [0, 104].
 *     1 <= Node.val <= 50
 *     0 <= val <= 50
 *
 * Time Complexity O(n)
 */

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        } else {
            ListNode previous = head;
            ListNode current = head;
            while (current != null) {
                if (current.val == val) {
                    if (current == head) {
                        head = current.next;
                    }
                    previous.next = current.next;
                    current = current.next;
                } else {
                    previous = current;
                    current = current.next;
                }
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
