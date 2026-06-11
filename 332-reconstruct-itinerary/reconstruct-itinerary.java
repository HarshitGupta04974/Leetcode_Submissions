class Solution {

    Map<String , PriorityQueue<String>> graph=new HashMap<>();
    List<String> ans=new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for(List<String> t : tickets)
        {
            String from=t.get(0);
            String to=t.get(1);

            graph.putIfAbsent(from , new PriorityQueue<>());
            graph.get(from).add(to);
        }

        dfs("JFK");

        Collections.reverse(ans);
        return ans;
    }

    void dfs(String curr)
    {
        PriorityQueue<String> pq=graph.get(curr);

        while( pq != null && !pq.isEmpty())
        {
            String nextdest=pq.poll();
            dfs(nextdest);
        }
        ans.add(curr);
    }
}