class DSU{
    int par[],size[];
    DSU(int n)
    {
        par=new int[n+1];
        size=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            par[i]=i;
            size[i]=1;
        }
    }
    public int find(int node)
    {
        if(par[node]==node)
        {
            return node;
        }
        return par[node]=find(par[node]);
    }
    public void union(int u,int v)
    {
        int ulu=find(u);
        int ulv=find(v);
        if(ulu==ulv) return;
        if(size[ulu]<size[ulv])
        {
            par[ulu]=ulv;
            size[ulv]+=size[ulu];
        }
        else{
            par[ulv]=ulu;
            size[ulu]+=size[ulv];
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DSU dsu=new DSU(n);
        int countEx=0;
        for(int i=0;i<connections.length;i++)
        {
            int u=connections[i][0];
            int v= connections[i][1];
            if(dsu.find(u)==dsu.find(v))
            {
                countEx++;
            }
            else{
                dsu.union(u,v);
            }
        }
        int countC=0;
        for(int i=0;i<n;i++)
        {
            if(dsu.find(i)==i) countC++;
        }
        int ans=countC-1;
        if(countEx>=ans) return ans;
        return -1;
    }
}