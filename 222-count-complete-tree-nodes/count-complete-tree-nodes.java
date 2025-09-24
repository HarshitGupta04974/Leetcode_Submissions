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
    public int lefth(TreeNode root){
        int count=0;
        while(root.left!=null){
            count++;
            root=root.left;
        }
        return count;
   }
public int righth(TreeNode root){
        int count=0;
        while(root.right!=null){
            count++;
            root=root.right;
        }
        return count;
   }
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int left_h=lefth(root);
        int right_h=righth(root);

        if(left_h==right_h) return ((2<<(left_h))-1);
        
        return countNodes(root.left)+countNodes(root.right)+1;
    }
}