class DSU{
    int par[];
    int size[];
    DSU(int n){
        par=new int[n+1];
        size=new int[n+1];
        for(int i=0;i<n;i++)
        {
            par[i]=i;
            size[i]=1;
        }
    }
    int findUp(int node)
    {
        if(node==par[node])
        {
            return node;
        }
        par[node]=findUp(par[node]);
        return (par[node]);
    }
    void unionBysize(int u,int v)
    {   int upu=findUp(u);
        int upv=findUp(v);
        if(upu==upv )return;
        if(size[upu]<size[upv])
        {
            par[upu]=upv;
            size[upv]+=size[upu];
        }
        else{
            par[upv]=upu;
            size[upu]+=size[upv];
        }
        
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DSU ds=new DSU(n);
        HashMap<String,Integer> mpp=new HashMap<>();

        for(int i=0;i<n;i++)
        {
            for(int j=1;j<accounts.get(i).size();j++)
            {
                String mail=accounts.get(i).get(j);
                if(!mpp.containsKey(mail))
                {
                    mpp.put(mail,i);
                }
                else{
                    ds.unionBysize(i,mpp.get(mail));
                }
            }
        }
        ArrayList<String>[] mergeMail=new ArrayList[n];
        for(int i=0;i<n;i++)
        mergeMail[i]=new ArrayList<>();

        for(Map.Entry<String,Integer> it:mpp.entrySet())
        {
            String m=it.getKey();
            int node=ds.findUp(it.getValue());
            mergeMail[node].add(m);
        }
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(mergeMail[i].isEmpty()) continue;
            Collections.sort(mergeMail[i]);
            List<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String mail:mergeMail[i])
            {
                temp.add(mail);
            }
            ans.add(temp);
        }
        ans.sort((a,b)->a.get(0).compareTo(b.get(0)));
        return ans;
    }
}