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

    static ListNode revList(ListNode head){
        ListNode prev=null;
        ListNode curr=head;

        while(curr!=null){
            ListNode forward=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forward;
        }

        return prev;
    }

    public ListNode doubleIt(ListNode head) {

        head=revList(head);

        ListNode curr=head;
        int carry=0;

        while(curr!=null){

            int total=(2*curr.val)+carry;

            curr.val=total%10;
            carry=total/10;

            curr=curr.next;
        }

        if(carry!=0){
            curr=head;

            while(curr.next!=null){
                curr=curr.next;
            }

            curr.next=new ListNode(carry);
        }

        head=revList(head);

        return head;
    }
}