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
    private TreeNode help(int[] preorder, int preS,int preE,int[] inorder,int inS,int inE,HashMap<Integer,Integer> mpp){
        if(preS>preE || inS>inE){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preS]);
        int inRoot=mpp.get(root.val);
        int leftnum=inRoot-inS;
        root.left=help(preorder,preS+1,preS+leftnum,inorder,inS,inRoot-1,mpp);
        root.right=help(preorder,preS+leftnum+1,preE,inorder,inRoot+1,inE,mpp);
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mpp.put(inorder[i],i);
        }
        TreeNode root=help(preorder,0,preorder.length-1,inorder,0,inorder.length-1,mpp);
        return root;
    }
}