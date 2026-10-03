class Solution {
    public void dfs(int row,int col, boolean[][] visited,char[][] grid){
        visited[row][col] = true; 
        int n = grid.length,m=grid[0].length;
        if(row-1>=0 && grid[row-1][col]=='1' && !visited[row-1][col]) dfs(row-1,col,visited,grid);
         if(row+1<n && grid[row+1][col]=='1' && !visited[row+1][col]) dfs(row+1,col,visited,grid); 
         if(col-1>=0 && grid[row][col-1]=='1' && !visited[row][col-1]) dfs(row,col-1,visited,grid);
          if(col+1<m && grid[row][col+1]=='1' && !visited[row][col+1]) dfs(row,col+1,visited,grid);
       
        
    }
    public int numIslands(char[][] grid) {
        int n = grid.length,m=grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int islandCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1' && !visited[i][j]) {

                    dfs(i, j, visited, grid);
                    islandCount++;
                }
            }
        }
        return islandCount;
        
    }
}