package easy.linkedList;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 *
 * Constraints:
 *
 *     The number of the nodes in the list is in the range [0, 104].
 *     -105 <= Node.val <= 105
 *     pos is -1 or a valid index in the linked-list.
 *
 * Time Complexith O(n) --> doubtfull
 */

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        else {
            ListNode counter1 = head;
            ListNode counter2 = head;
            while (counter1.next != null && counter2.next != null && counter2.next.next != null) {
                counter1 = counter1.next;
                counter2 = counter2.next.next;
                if (counter1 == counter2) return true;
            }
        }
        return false;
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode(int x) {
 *       val = x;
 *       next = null;
 *   }
 * }
 * */