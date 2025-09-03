class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        int[] visited = new int[numCourses]; 

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, visited)) return false;
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int node, int[] visited) {
        if (visited[node] == 1) return false;
        if (visited[node] == 2) return true;

        visited[node] = 1; 

        for (int neighbor : graph.get(node)) {
            if (!dfs(graph, neighbor, visited)) return false;
        }

        visited[node] = 2; 
        return true;
    }
}