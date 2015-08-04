/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        
        if(head == null){
            return null;
        }
        
        ListNode current = head;
        int count  = 0;
        while(current != null){  //遍历单链表
            count++;
            current = current.next;
        }
        
        ListNode middle = head, prev = null;
        for(int i = 0; i < count/2; i++){
            prev = middle;
            middle = middle.next;
        }
        TreeNode root = new TreeNode(middle.val);
       
        if(middle == head){//说明链表长度为1，直接输出
            return root;
        }
        
        prev.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(middle.next);
        
        return root;

    }
}