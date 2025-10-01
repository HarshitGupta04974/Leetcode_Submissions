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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null||postorder==null) return null;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mpp.put(inorder[i],i);
        }
        return help(inorder,0,inorder.length-1,postorder,0,postorder.length-1,mpp);
    }
    public TreeNode help(int []inorder,int inS,int inE,int[]postorder,int posS,int posE,HashMap<Integer,Integer>mpp){
        if(posS>posE || inS>inE)return null;
        TreeNode root=new TreeNode(postorder[posE]);
        int inRoot=mpp.get(postorder[posE]);
        int nleft=inRoot-inS;
        root.left=help(inorder,inS,inRoot-1,postorder,posS,posS+nleft-1,mpp);
        root.right=help(inorder,inRoot+1,inE,postorder,posS+nleft,posE-1,mpp);
        return root;
    }
}