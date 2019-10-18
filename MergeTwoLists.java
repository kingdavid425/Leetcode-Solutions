/*
Leetcode Instructions: Merge two sorted linked lists and return it as a new list. The new list
   should be made by splicing together the nodes of the first two lists.
https://leetcode.com/problems/merge-two-sorted-lists/
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        
        if(l2 == null) {
            return l1;
        }
        
        if(l1.next == null) {
            if(l1.val <= l2.val) {
                l1.next = l2;
                return l1;
            } 
        }
        
        if(l2.next == null) {
            if(l2.val <= l1.val) {
                l2.next = l1;
                return l2;
            } 
        }
        
        ListNode current, root, temp, temp2;
        
        while(l1.val > l2.val) {
            temp = l1;
            temp2 = l2;
            l2 = l2.next;    
            l1 = temp2;
            l1.next = temp;
        }
        
        root = l1;
        current = l1;
        while(l2 != null) {
            if(current.next == null){
                current.next = l2;
                l2 = null;
            } else if(current.next.val >= l2.val) {
                temp = current.next;
                temp2 = l2;
                l2 = l2.next;
                current.next = temp2;
                current.next.next = temp;
            }
            current = current.next;
        }
        
        return root;
    }
}