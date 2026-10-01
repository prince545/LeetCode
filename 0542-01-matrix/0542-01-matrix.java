class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] grid) {
    int n=grid.length,m=grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    q.add(new Pair(i,j));
                    dist[i][j] = 0;
                }
            }
        }
       
        while(q.size()>0){
            Pair front = q.remove();
            int row = front.row, col = front.col;

            // down
            if(row+1<n && grid[row+1][col]==1 && dist[row+1][col]==0) {
           dist[row+1][col] = dist[row][col] + 1;

                q.add(new Pair(row+1,col));
            }
             // up
            if(row-1>=0 && grid[row-1][col]==1 && dist[row-1][col]==0) {
    dist[row-1][col] = dist[row][col] + 1;


                q.add(new Pair(row-1,col));
            }
             // right
            if(col+1<m && grid[row][col+1]==1 && dist[row][col+1]==0) {
    dist[row][col+1] = dist[row][col] + 1;

                q.add(new Pair(row,col+1));

            }
             // left
            if(col-1>=0 && grid[row][col-1]==1 && dist[row][col-1]==0) {
    dist[row][col-1] = dist[row][col] + 1;

                q.add(new Pair(row,col-1));

            }

        }
        return dist;
            }
}