public class Triplet implements Comparable<Triplet>{
    int row;
    int col;
    int effort;
    Triplet(int row, int col, int effort){
        this.row = row;
        this.col = col;
        this.effort = effort;
    }
    public int compareTo(Triplet t){
        if(this.effort == t.effort) return this.row - t.row;
        return this.effort - t.effort;
    }
}
class Solution {
    public int minimumEffortPath(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] ans = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j] = Integer.MAX_VALUE;
            }
        }
        ans[0][0] = 0;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0,0,0));
        int[] r = {-1,0,1,0};
        int[] c = {0,-1,0,1};
        while(pq.size()>0){
            Triplet top = pq.remove();
            int row = top.row, col = top.col, effort = top.effort;
            if(row == m-1 && col == n-1) break;
            for(int i=0;i<=3;i++){
                int newRow = row + r[i];
                int newCol = col + c[i];
                if(newRow<0 || newCol<0 || newRow>m-1 || newCol>n-1) continue;
                int e = Math.abs(arr[row][col] - arr[newRow][newCol]);
                e = Math.max(e,effort);
                if(e < ans[newRow][newCol]) {
                    ans[newRow][newCol] = e;
                    pq.add(new Triplet(newRow,newCol,e));
                }
            }

            
        }
        return ans[m-1][n-1];



        
    }
}