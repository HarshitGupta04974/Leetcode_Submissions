/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParents(TreeNode root,Map<TreeNode,TreeNode> parent,TreeNode target){
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode current=q.poll();
            if(current.left!=null){
                parent.put(current.left,current);
                q.offer(current.left);
            }
            if(current.right!=null){
                parent.put(current.right,current);
                q.offer(current.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> mpp=new HashMap<>();
        markParents(root,mpp,root);
        Map<TreeNode,Boolean> visited=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int curr_level=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(curr_level==k){
                break;
            }
            curr_level++;
            for(int i=0;i<size;i++){
                TreeNode current=q.poll();
                if(current.left!=null && visited.get(current.left)==null){
                    q.offer(current.left);
                    visited.put(current.left,true);
                }
                if(current.right!=null && visited.get(current.right)==null){
                    q.offer(current.right);
                    visited.put(current.right,true);
                }
                if(mpp.get(current)!=null && visited.get(mpp.get(current))==null){
                    q.offer(mpp.get(current));
                    visited.put(mpp.get(current),true);
                }
            }
        }
        List<Integer> result=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode current=q.poll();
            result.add(current.val);
        }
        return result;
    }
    
}