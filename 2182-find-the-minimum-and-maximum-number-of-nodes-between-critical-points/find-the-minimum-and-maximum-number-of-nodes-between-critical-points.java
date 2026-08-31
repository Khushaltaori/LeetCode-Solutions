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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        int[] ans = {-1,-1};

        if(head == null || head.next == null || head.next.next == null){
            return ans;
        }

        ListNode prev = head;
        ListNode temp = head.next;

        int first = -1;
        int last = -1;
        int index=1;
        int minDis = Integer.MAX_VALUE;

        while(temp.next!=null){
            ListNode next = temp.next;

            if((temp.val > prev.val && temp.val > next.val) || (temp.val< prev.val && temp.val < next.val)){
                if(first == -1){
                    first = index;
                }else{
                    minDis = Math.min(minDis,index - last);
                }

                last = index;
            }

            prev = temp;
            temp = next;
            index++;
        }

        if(first == -1 || first == last){
            return ans;
        }

        int maxDist = last - first;
        ans[0] = minDis;
        ans[1] = maxDist;

        return ans;
    }
}