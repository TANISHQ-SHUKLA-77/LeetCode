class Solution {
    private int MAX=Integer.MAX_VALUE;
    private int MIN= Integer.MIN_VALUE;
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = MIN;
        }

        for(int[] guard:guards){
            grid[guard[0]][guard[1]]=MAX;
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==MAX)
                {
                    for(int k=j+1;k<n;k++){
                        if(grid[i][k]==MAX || grid[i][k]==MIN) break;
                        grid[i][k]-=1;
                    }
                    for(int k=j-1;k>=0;k--){
                        if(grid[i][k]==MAX || grid[i][k]==MIN) break;
                        grid[i][k]-=1;
                    }
                    for(int k=i+1;k<m;k++){
                        if(grid[k][j]==MAX || grid[k][j]==MIN) break;
                        grid[k][j]-=1;
                    }
                    for(int k=i-1;k>=0;k--){
                        if(grid[k][j]==MAX || grid[k][j]==MIN) break;
                        grid[k][j]-=1;
                    }
                }
            }
        }
        int count=0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) count++;
            }
        }

        return count;
    }
}