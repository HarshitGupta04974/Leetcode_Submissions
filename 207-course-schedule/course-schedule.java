class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        
        int []indegree=new int[numCourses];
        
        for(int i=0;i<prerequisites.length;i++)
        {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for(int i=0;i<numCourses;i++)
        {
            for(int it:adj.get(i))
            {
                indegree[it]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int count=0;
        while(!q.isEmpty())
        {   
            int v=q.poll();
            count++;
            for(int it:adj.get(v)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.offer(it);
                }
            }
        }
        return count==numCourses;
    }
}