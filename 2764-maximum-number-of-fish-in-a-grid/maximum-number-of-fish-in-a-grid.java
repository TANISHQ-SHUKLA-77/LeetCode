class Solution {
    public int findMaxFish(int[][] grid) {
        
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        int val = 0;
        
        for(int i=0; i<m; i++){
            for (int j=0; j<n; j++){

                if(grid[i][j] != 0){
                    
                    val = dfs(i, j, grid);

                    max = Math.max(max, val);
                }
            }
        }
        return max;
    }

    public static int dfs(int r, int c, int[][] grid){


        if(r<0 || r>=grid.length || c<0 || c >= grid[0].length || grid[r][c] == 0) return 0;

        int curr = grid[r][c];

        grid[r][c] = 0;

        curr += dfs(r+1, c, grid);
        curr += dfs(r-1, c, grid);
        curr += dfs(r, c+1, grid);
        curr += dfs(r, c-1, grid);

        return curr;
    }
}