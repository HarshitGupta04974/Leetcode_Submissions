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
    private static void help(TreeNode root,int count[],int[]flag,int targetSum){
        
        if(root==null) return; 
        if (flag[0] == 1) {
            return;
        }
        count[0]+=root.val;
        if(root.left==null&&root.right==null){
            if(count[0]==targetSum)
            {flag[0]=1;
            
            }
            count[0]-=root.val;
            return;
        }
        help(root.left,count,flag,targetSum);
        help(root.right,count,flag,targetSum);

        count[0]-=root.val;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int count[]=new int[]{0};
        int flag[]=new int[]{0};
        help(root,count,flag,targetSum);

        return flag[0]==1;
    }
}