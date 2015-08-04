/**
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
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        TreeNode current = root,delete = null;
        while(current != null){
            if(current.val == value){
                delete = current;
                break;
            }
            if(current.val > value){
                current = current.left;
            }else if(current.val < value){
                current = current.right;
            }
        }
        if(delete == null){
            return root;
        }
        
        if(delete.left != null && delete.right != null){
            //寻找要删除节点，左子树中的最大元素
            TreeNode max = delete.left, mp = delete;  //mp为max的父亲
            while(max.right != null){
                mp = max;
                max = max.right;
            }
            delete.val = max.val;
            if(max == delete.left){
                delete.left = max.left;
            }else{
                if(max.left == null && max.right == null){
                    mp.right = null;
                }else{
                    mp.right = max.left;
                }
            }
            return root;
        }
        TreeNode c;
        if(delete.left != null){
            c = delete.left;
        }else{
            c = delete.right;
        }
        if(delete == root){
            return c;
        }
        delete.val = c.val;
        delete.left = c.left;
        delete.right = c.right;
        return root;
    }
}