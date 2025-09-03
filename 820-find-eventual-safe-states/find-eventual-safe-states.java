class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n = graph.length;

        int [] visited = new int[n];

        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<n; i++){

            if (dfs(graph, i, visited)) ans.add(i);

        }
        return ans;
    }

    private boolean dfs(int[][] graph, int node, int[] visited){

        if(visited[node] > 0) return visited[node] == 2;

        visited[node] = 1;

        for(int next : graph[node]){

            if(visited[next] == 1 || !dfs(graph, next, visited)) return false;
        }

        visited[node] = 2;

        return true;
    }
}