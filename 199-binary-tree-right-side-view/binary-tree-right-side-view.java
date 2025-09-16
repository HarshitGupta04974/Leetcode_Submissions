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
    private static void help(TreeNode node,int level,List<Integer> ds){
        if(node==null) return;

        if(level==ds.size()){
            ds.add(node.val);
        }
        help(node.right,level+1,ds);
        help(node.left,level+1,ds);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls=new ArrayList<>();
        help(root,0,ls);
        return ls;
    }
}