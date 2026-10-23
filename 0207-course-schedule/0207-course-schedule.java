class Solution {
    static boolean ans;
    public void dfs(int i, List<List<Integer>> adj, boolean[] visited, boolean[] path){
        visited[i] = true;
        path[i] = true;
        for(int ele:adj.get(i)){
            if(path[ele]==true){
                ans = false; // cycle detected , cant finish all courses
                return;
            }
          if(visited[ele]==false)  dfs(ele,adj,visited,path);
        }
        path[i] = false;
    }
    public boolean canFinish(int n, int[][] pre) {
        ans = true; // true means you can finish all course and no cycle is there
       List<List<Integer>> adj = new ArrayList<>();
       for(int i=0;i<n;i++) adj.add(new ArrayList<>());
       for(int i=0;i<pre.length;i++){
        int a = pre[i][0], b = pre[i][1];
        adj.get(b).add(a);
       }
       boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]==false) dfs(i,adj,visited,path);

        }

       return ans;








    // using BFS(kahn's algo.)
    //     List<List<Integer>> adj = new ArrayList<>();
    //     for(int i=0;i<n;i++) adj.add(new ArrayList<>());
    //     int[] indegree = new int[n];
    //     boolean[] visited = new boolean[n];

    //     for(int i=0;i<pre.length;i++){
    //         int a = pre[i][0], b = pre[i][1]; //  b->a edge
    //         adj.get(b).add(a);
    //         indegree[a]++;


    //     }
    //     // kahn's algo.
    //     Queue<Integer> q = new LinkedList<>();
    //     List<Integer> ans = new ArrayList<>();
    //     for(int i=0;i<n;i++){
    //         if(indegree[i]==0) q.add(i);


    //     }
    //     while(q.size()>0){
    //         int front = q.remove();
    //         ans.add(front);
    //         for(int ele:adj.get(front)){
    //             indegree[ele]--;
    //             if(indegree[ele]==0) q.add(ele);
                    
                
    //         }
    //     }
    //    return (ans.size()==n);


        
    }
}