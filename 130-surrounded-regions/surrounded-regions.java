class Solution {
    public void solve(char[][] board) {
        int N = board.length;
        int M = board[0].length;
        int[][] visited = new int[N][M];
        //Traverse the borders of the Matrix 
        //Top and bottom row
        for(int i=0;i<M;i++){
            if(board[0][i]=='O') dfs(0,i,visited,board);
            if(board[N-1][i]=='O') dfs(N-1,i,visited,board);
        }
        for(int i=0;i<N;i++){
            if(board[i][0]=='O') dfs(i,0,visited,board);
            if(board[i][M-1]=='O') dfs(i,M-1,visited,board);
        }
        //Traverse the board and check for the visited matrix 
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j]=='O' && visited[i][j]==0){
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(int r, int c, int[][] visited, char[][] board){
        int N = board.length;
        int M = board[0].length;
        visited[r][c] = 1;
        int[] dRow = {-1,0,0,1};
        int[] dCol = {0,-1,1,0};
        for(int i=0;i<4;i++){
            int nRow = r+dRow[i];
            int nCol = c+dCol[i];
            if(nRow>=0 && nCol>=0 && nRow<N && nCol<M && board[nRow][nCol]=='O' && visited[nRow][nCol]==0){
                dfs(nRow,nCol,visited,board);
            }
        }
    }
}