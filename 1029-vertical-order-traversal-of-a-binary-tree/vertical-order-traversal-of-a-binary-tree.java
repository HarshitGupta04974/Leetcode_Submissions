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
 class Tuple{
    TreeNode node;
    int row;
    int column;
    Tuple(TreeNode node,int row,int column){
        this.node=node;
        this.row=row;
        this.column=column;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>mpp=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple tup=q.poll();
            TreeNode node=tup.node;
            int x=tup.row;
            int y=tup.column;

            if(!mpp.containsKey(x)){
                mpp.put(x,new TreeMap<>());
            }
            if(!mpp.get(x).containsKey(y)){
                mpp.get(x).put(y,new PriorityQueue<>());
            }
            mpp.get(x).get(y).offer(node.val);
            if(node.left!=null){
                q.offer(new Tuple(node.left,x-1,y+1));
            }
            if(node.right!=null){
                q.offer(new Tuple(node.right,x+1,y+1));
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> ys:mpp.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes:ys.values()){
                while(!nodes.isEmpty()){
                    ans.get(ans.size()-1).add(nodes.poll());
                }
            }
        }
        return ans;

    }
}