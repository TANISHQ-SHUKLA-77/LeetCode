/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    static int sum;
    
    public TreeNode convertBST(TreeNode root) {
        
        sum = 0;

        inOrder(root);
        helper(root);
        
        return root;
    }


    private void inOrder(TreeNode temp){

        if(temp == null) return;

        inOrder(temp.left);

        sum += temp.val;

        inOrder(temp.right);


    }

    private void helper(TreeNode node){

        if(node == null) return;

        helper(node.left);

        int a = node.val;
        node.val=sum;
        
        sum -= a;
        helper(node.right);


    }
}