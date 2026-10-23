class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n];
        boolean[] visited = new boolean[n];

        for(int i=0;i<pre.length;i++){
            int a = pre[i][0], b = pre[i][1]; //  b->a edge
            adj.get(b).add(a);
            indegree[a]++;


        }
        // kahn's algo.
        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.add(i);


        }
                int idx = 0;

        while(q.size()>0){
            int front = q.remove();
            ans[idx++] = front;
            for(int ele:adj.get(front)){
                indegree[ele]--;
                if(indegree[ele]==0) q.add(ele);
                    
                
            }
        }
        return (idx==n)?ans:new int[0];


        
    }
}