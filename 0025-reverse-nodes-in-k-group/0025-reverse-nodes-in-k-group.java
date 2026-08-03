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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        if (head == null) {
            return null;
        }
        ListNode left = head;
        ListNode right = left;
        ListNode prevLeft = null;
        ListNode nextLeft = null;
        ListNode res = null;
        int size = k;
        while (left != null) {
            right=left;//resetting right every time
            for (int i = 0; i < size - 1; i++) {// traversing to right according to question.
                if (right == null) {
                    break;
                } else {
                    right = right.next;
                }
            }
            if (right != null) {

                nextLeft = right.next;
                reverse(left, size);
                if (prevLeft != null) {
                    prevLeft.next = right;
                }
                if (res == null) {
                    res = right;
                }
                prevLeft = left;//we need this to connect it to next pair 
                left = nextLeft;//allowing left to proceed further 
            }

            else {
                if (prevLeft != null) {
                    prevLeft.next = left;
                }
                 if (res == null) {
                        res = left;
                    }   
                break;
            }

        }
        return res;

    }

    public void reverse(ListNode head, int size) {
        ListNode prev = null;
        ListNode current = head;
        int times = size;
        while (times > 0 && current != null) {
            ListNode nex = current.next;
            current.next = prev;
            prev = current;
            current = nex;
            times--;
        }
    }
}
    
        