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
    private static void help(TreeNode root,int count[],List<Integer> paths,List<List<Integer>> ans,int targetSum){
        if(root==null) return;

        paths.add(root.val);
        count[0]+=root.val;
        if(root.left==null&&root.right==null){
            if(count[0]==targetSum){
                ans.add(new ArrayList<>(paths));
            }
            count[0]-=root.val;
            paths.remove(paths.size() - 1);
            return;
        }
        help(root.left, count, paths, ans, targetSum);
        help(root.right, count, paths, ans, targetSum);
        count[0]-=root.val;
        paths.remove(paths.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        int count[]=new int[]{0};
        help(root,count,path,ans,targetSum);
        return ans;
}
}