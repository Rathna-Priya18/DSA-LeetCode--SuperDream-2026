class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean vis[] = new boolean[n];
        boolean path[] = new boolean[n];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                dfs(graph,vis,path,i);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(!path[i])list.add(i);
        }
        return list;
    }
    boolean dfs(int graph[][],boolean vis[],boolean path[],int node)
    {
        vis[node]=path[node]=true;

        for(int next : graph[node])
        {
            if(!vis[next] && dfs(graph,vis,path,next))return true;
            else if(path[next])return true;
        }
        path[node]=false;
        return false;
    }
}