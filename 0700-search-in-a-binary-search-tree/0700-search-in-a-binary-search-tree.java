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
    private TreeNode ans = null;  // class variable

    public TreeNode searchBST(TreeNode root, int val) {
        helper(root, val);        // helper changes ans
        return ans;               // searchBST returns ans
    }

    private void helper(TreeNode root, int val) {
        if (root == null) {
            return;               // stop this helper call
        }

        if (root.val == val) {
            ans = root;            // store the found node in ans
            return;                // stop helper
        }

        if (root.val > val) {
            helper(root.left, val);
        } else {
            helper(root.right, val);
        }
    }
}