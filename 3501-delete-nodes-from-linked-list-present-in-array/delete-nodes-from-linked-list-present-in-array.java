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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set=new HashSet<>();
        for(int val:nums) set.add(val);
        ListNode dummy=new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr =head;

        while(curr != null){
            int value = curr.val;
            if(set.contains(value)){
                prev.next = curr.next;
            }
            else{
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next;

    }
}