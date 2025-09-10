class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        List<Integer> ans = new ArrayList<>();

        if(n == 1){
            ans.add(0);
            return ans;
        }

        List<Set<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new HashSet<>());
        }

        for(int[] edge : edges){

            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Deque<Integer> leaves = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            if(adj.get(i).size() == 1) leaves.add(i);
        }

        while (n > 2){
            int size = leaves.size();

            n -= size;

            for(int i=0; i<size; i++){

                int leaf = leaves.poll();
                int neighbour = adj.get(leaf).iterator().next();
                adj.get(neighbour).remove(leaf);

                if (adj.get(neighbour).size() == 1) leaves.add(neighbour);
            }
        }

        ans.addAll(leaves);
        return ans;
    }
}