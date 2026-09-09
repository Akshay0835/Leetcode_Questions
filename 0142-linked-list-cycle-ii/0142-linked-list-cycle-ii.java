/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        List<ListNode> list=new ArrayList<>();
        ListNode temp=head;
        ListNode ans=null;
        while(temp!=null){
            if(list.contains(temp)){
                ans=temp;
                break;
            }
            list.add(temp);
            temp=temp.next;
        }
        return ans;
    }
}