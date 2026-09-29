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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode ans[]=new ListNode[k];
        ListNode temp=head;
        int len=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        int partition=len/k;
        int extra=len%k;
        ListNode curr=head;
        ListNode prev=null;
        for(int i=0;i<k;i++){
            if(curr==null){
                ans[i]=curr;
                continue;
            }
            ans[i]=curr;
            int width=partition+(extra>0?1:0);
            extra--;
            for(int j=1;j<=width;j++){
                prev=curr;
                curr=curr.next;
            }
            prev.next=null;
        }
        return ans;
    }
}