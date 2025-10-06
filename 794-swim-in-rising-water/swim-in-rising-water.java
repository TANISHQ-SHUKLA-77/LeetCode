class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        int n = grid.length, m = grid[0].length;
        int[][] md = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(md[i], Integer.MAX_VALUE);
        }
        pq.offer(new int[]{0, 0, grid[0][0]});
        md[0][0] = grid[0][0];

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(md[curr[0]][curr[1]] < curr[2]){
                continue;
            }
            if(curr[0] == n - 1 && curr[1] == m - 1){
                return curr[2];
            }
            for(int[] d : dirs){
                int nr = curr[0] + d[0];
                int nc = curr[1] + d[1];
                if(nr < 0 || nr == n || nc < 0 || nc == m){
                    continue;
                }
                int dis = Math.max(grid[nr][nc], curr[2]);
                if(md[nr][nc] <= dis){
                    continue;
                }
                md[nr][nc] = dis;
                pq.offer(new int[]{nr, nc, dis});
            }
        }
        return -1;
    }
}