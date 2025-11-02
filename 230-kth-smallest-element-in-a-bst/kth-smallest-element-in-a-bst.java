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
    private static void help(TreeNode root,int k,int ans[],int ckt[]){
        if(root==null||ckt[0]>=k) return;
        help(root.left,k,ans,ckt);
        ckt[0]++;
        if(ckt[0]==k){
            ans[0]=root.val;
            return;
        }
        help(root.right,k,ans,ckt);
    }
    public int kthSmallest(TreeNode root, int k) {
        int ans[]=new int[1];
        help(root,k,ans,new int[1]);
        return ans[0];
    }
}