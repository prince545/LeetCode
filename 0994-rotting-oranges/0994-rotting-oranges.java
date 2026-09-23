class Triplet{
    int row;
    int col;
    int time;
    Triplet(int row,int col,int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        Queue<Triplet> q = new LinkedList<>();
        for(int i=0;i<n;i++){ // check for all starting points i.e. spot all rotten tomatoes in grid
            for(int j=0;j<m;j++){
                if(grid[i][j]==2) {
                    q.add(new Triplet(i,j,0));
                }
            }
        }
        int maxTime = 0;
        while(q.size()>0){
            Triplet front = q.remove();
            int row=front.row,col=front.col,time=front.time;
            maxTime = Math.max(time,maxTime);
            // up 
            if(row-1>=0 && grid[row-1][col]==1) {
                grid[row-1][col]=2; // fresh oranges rotted 
                q.add(new Triplet(row-1,col,time+1));
            } 
            // down
            if(row+1<n && grid[row+1][col]==1){
                grid[row+1][col]=2;
                q.add(new Triplet(row+1,col,time+1));
            }
            // left
            if(col-1>=0 && grid[row][col-1]==1){
                grid[row][col-1]=2;
                q.add(new Triplet(row,col-1,time+1));
            }
            // right
            if(col+1<m && grid[row][col+1]==1){
                 grid[row][col+1]=2;
                q.add(new Triplet(row,col+1,time+1));
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){ 
                if(grid[i][j]==1) return -1; // even if one tomato is still fresh return -1;
            }
        }
        return maxTime;
    }
}