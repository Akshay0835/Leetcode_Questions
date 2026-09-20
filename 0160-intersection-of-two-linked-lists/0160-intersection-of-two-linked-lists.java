/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
      ListNode a=headA;
      ListNode b=headB;
      while(a!=null&&b!=null){
        a=a.next;
        b=b.next;
      }
      if(a==null){
        int blen=0;
        while(b!=null){
            blen++;
            b=b.next;
        }
        while(blen-- >0){
            headB=headB.next;
        }
      }
      else{
        int alen=0;
        while(a!=null){
            alen++;
            a=a.next;
        }
        while(alen-- >0){
            headA=headA.next;
        }
      }
      while(headA!=null&&headB!=null){
        if(headA==headB){
            return headA;
        }
        else{
            headA=headA.next;
            headB=headB.next;
        }
      }
      return null;
    }
}