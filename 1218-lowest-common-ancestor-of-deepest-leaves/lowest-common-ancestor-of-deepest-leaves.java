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
    private static int depth(TreeNode root)
    {
        if(root!=null)
        {
            return 1+Math.max(depth(root.left),depth(root.right));
        }
        return 0;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) 
    {
        int l_depth=depth(root.left);
        int r_depth=depth(root.right);
        if(l_depth==r_depth)
        {
            return root;
        }    
        if(l_depth>r_depth)
        {
          return lcaDeepestLeaves(root.left);
        }
        
        return lcaDeepestLeaves(root.right);
        
    }
}