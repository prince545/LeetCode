class Solution {
    public static void dfs(int i,boolean[] visited,int[][] isConnected){
        int n = isConnected.length;
       
        visited[i] = true;
        for(int j=0;j<n;j++){
            if(isConnected[i][j]==1 && !visited[j]){
                dfs(j,visited,isConnected);
            }
        }

    }
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]) {
                dfs(i,visited,isConnected);
                count++;

            }
        }
        return count;
    }
}
