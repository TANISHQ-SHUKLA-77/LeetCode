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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        inOrder(root, arr);

        return constructTree(0, arr.size() - 1, arr);
    }

    private TreeNode constructTree(int l, int r, List<Integer> arr) {
        if( l > r ) return null;

        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = constructTree(l, mid - 1, arr);
        root.right = constructTree(mid + 1, r, arr);

        return root;
    }

    private void inOrder(TreeNode root, List<Integer> arr) {
        if(root == null) return;

        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right, arr);
    }
}