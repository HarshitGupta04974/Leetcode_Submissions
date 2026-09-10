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
    private static int[] help(TreeNode root,int ans[])
    {
        if(root==null)
        {
            return new int[]{0,0};
        }
        int leftTree[]=help(root.left,ans);
        int rightTree[]=help(root.right,ans);
        int sum=root.val+leftTree[0]+rightTree[0];
        int num=1+leftTree[1]+rightTree[1];
        if(root.val==(sum/num))
        {
            ans[0]++;
        }
        return new int[]{sum,num};
    }
    public int averageOfSubtree(TreeNode root) {
        int ans[]={0};
        help(root,ans);
        return ans[0];

    }
}