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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode last = head;
        ListNode middle = head;
        ListNode newhead = null;
        int n = 1;

           while(last.next != null){
            last = last.next;
            n++;
        } 
        last.next = head;

        int m = k %n;
        for(int i = 0; i < n - m -1; i++){
            middle = middle.next;
        }
        newhead = middle.next;
        middle.next = null;

        return newhead;
    }
       
}