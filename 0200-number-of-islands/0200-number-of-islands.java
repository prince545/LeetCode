class Solution {
    public void bfs(int i,int j, boolean[][] visited,char[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j]=true;
        while (q.size() > 0) {

            int[] front = q.remove();

            int row = front[0];
            int col = front[1];

            // up
            if (row - 1 >= 0 &&
                grid[row - 1][col] == '1' &&
                !visited[row - 1][col]) {

                q.add(new int[]{row - 1, col});
                visited[row - 1][col] = true;
            }

            // down
            if (row + 1 < n &&
                grid[row + 1][col] == '1' &&
                !visited[row + 1][col]) {

                q.add(new int[]{row + 1, col});
                visited[row + 1][col] = true;
            }

            // right
            if (col + 1 < m &&
                grid[row][col + 1] == '1' &&
                !visited[row][col + 1]) {

                q.add(new int[]{row, col + 1});
                visited[row][col + 1] = true;
            }

            // left
            if (col - 1 >= 0 &&
                grid[row][col - 1] == '1' &&
                !visited[row][col - 1]) {

                q.add(new int[]{row, col - 1});
                visited[row][col - 1] = true;
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length,m=grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int islandCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1' && !visited[i][j]) {

                    bfs(i, j, visited, grid);
                    islandCount++;
                }
            }
        }
        return islandCount;
        
    }
}